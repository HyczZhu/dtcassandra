package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.DeliverMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.cassandra.Util;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.ColumnFamily;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.SuperColumn;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.db.filter.QueryFilter;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.marshal.BytesType;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.ExpiringMap;
import org.apache.cassandra.utils.Pair;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.google.common.base.Function;

public class PaxosInstanceManager {
	
	

	private static final Map<String, Map<Range, ExpiringMap<Long, PaxosInstance>>> instances;
	private static final Map<String, Map<Range, ReplicaGroupState>> replicaGroupStates;
	
	static {
		Function<Pair<Long, PaxosInstance>, ?> expiredInstanceHandler = new Function<Pair<Long, PaxosInstance>, Object>()
        {
            public Object apply(Pair<Long, PaxosInstance> pair)
            {
                //PaxosInstance expiredValue = pair.right;

                //check instance state, flush if necessary
                //TODO
                return null;
            }
        };
        
        instances = new HashMap<String, Map<Range, ExpiringMap<Long, PaxosInstance>>>();
        replicaGroupStates = new HashMap<String, Map<Range,ReplicaGroupState>>();
        Set<String> tables = DatabaseDescriptor.getTables();
		
        try{
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    	for(String tableName : tables){
//    		System.out.println(tableName);
    		if (tableName.equals("system") || tableName.equals("instanceSlot"))
    			continue;
    		instances.put(tableName, new HashMap<Range, ExpiringMap<Long, PaxosInstance>>());
    		replicaGroupStates.put(tableName, new HashMap<Range, ReplicaGroupState>());
    		//TODO dynamic range detection
    		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
    			System.out.println("initializing PaxosInstance and ReplicaGroupState for table = " + tableName + " range = " + range);
    			instances.get(tableName).put(range, new ExpiringMap<Long, PaxosInstance>(getExpireTime(), expiredInstanceHandler));
    			replicaGroupStates.get(tableName).put(range, new ReplicaGroupState(tableName, range));
    		}
    	}
	}
	
	public static void setup(){
		
	}
	
	/***
	 * 1, try to get instance from memory
	 * 2, if it does not exist, try to get it from storage and put it input memory
	 * 3, if not exist, return null
	 * @param tableName
	 * @param range
	 * @param instanceNum
	 * @return the instance object, or null if not exist
	 */
	public static PaxosInstance getInstance(String tableName, Range range, long instanceNum){
		PaxosInstance instance = instances.get(tableName).get(range).get(instanceNum);
		if (instance == null){
			instance = SimpleAccess.getInstance(tableName, range, instanceNum);
			if (instance != null)
				instances.get(tableName).get(range).put(instanceNum, instance);
			return instance;
		}
		return instance;
	}
	
	public static PaxosInstance getOrNewInstance(String tableName, Range range, long instanceNum){
		PaxosInstance instance = getInstance(tableName, range, instanceNum);
		if (instance == null){
			SimpleAccess.newInstance(tableName, range, instanceNum);
			instance = SimpleAccess.getInstance(tableName, range, instanceNum);
			if (instance != null){
				instances.get(tableName).get(range).put(instanceNum, instance);
				return instance;
			}
			return null;
		}
		return instance;
	}
	
	public static boolean tryNewInstance(String tableName, Range range, long instanceNum) {
		// new instance
		if (getInstance(tableName, range, instanceNum) == null){
			newInstance(tableName, range, instanceNum);
			return true;
		}
		// existed instance
		else {
			return false;
		}
	}
	
	public static boolean tryNewInstance(PrepareMessage prepareMessage){
		return tryNewInstance(prepareMessage.getTableName(), prepareMessage.getRange(), prepareMessage.getInstanceNumber());
	}
	
	public static void newInstance(String tableName, Range range, long instanceNum) {
		SimpleAccess.newInstance(tableName, range, instanceNum);
	}
	
	public static void deleteInstance(String tableName, Range range, long instanceNum){
//		System.out.println("deleting instance " + instanceNum);
		SimpleAccess.deleteInstance(tableName, range, instanceNum);
	}
	
	public static PromiseResult promiseInstance(String tableName, Range range, long instanceNum, long proposalNum) throws NullPointerException{
		boolean success = false;
		long previousProposalNumber = -1;
		IPaxosValue acceptedValue = null;
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		synchronized (instance){
			//1, check its state
			if ((PaxosState.Pending.equals(instance.getState()) || PaxosState.Accepted.equals(instance.getState()))
					&& instance.getProposalNumber() <= proposalNum){
				System.out.println("    Actor: phase 1: promising "+proposalNum);
				//2, make a promise stabilization
				SimpleAccess.updateProposalNum(tableName, range, instanceNum, proposalNum);
				instance.setProposalNumber(proposalNum);
				success = true;
			}
			else{
				System.out.println("    Actor: phase 1: ignore");
				success = false;
				previousProposalNumber = instance.getProposalNumber();
			}
			acceptedValue = instance.getPaxosValue();
		}
		return new PromiseResult(success, previousProposalNumber, acceptedValue);
	}
	
	public static PromiseResult promiseInstance(PrepareMessage prepareMessage) throws NullPointerException{
		return promiseInstance(
				prepareMessage.getTableName(), 
				prepareMessage.getRange(), 
				prepareMessage.getInstanceNumber(), 
				prepareMessage.getProposalNumber()
			);
	}
	
	/***
	 * a convenient method to promise, 
	 * which call tryNewInstance first and promiseInstance then.
	 * @param prepareMessage
	 * @return
	 * @throws NullPointerException
	 */
	public static PromiseResult tryPromiseInstance(PrepareMessage prepareMessage) throws NullPointerException{
		tryNewInstance(prepareMessage);
		return promiseInstance(
				prepareMessage.getTableName(), 
				prepareMessage.getRange(), 
				prepareMessage.getInstanceNumber(), 
				prepareMessage.getProposalNumber()
			);
	}
	
	public static AcceptResult acceptInstance(String tableName, Range range, long instanceNum, long proposalNum, IPaxosValue paxosValue) throws NullPointerException{
		boolean success = false;
		long previousProposalNumber = -1;
		IPaxosValue acceptedValue = null;		
		PaxosInstance instance = PaxosInstanceManager.getOrNewInstance(tableName, range, instanceNum);
		if (instance == null) return new AcceptResult(false, previousProposalNumber, acceptedValue);
//		System.out.println("before synchoronized");
		synchronized (instance){
//			System.out.println("after synchoronized");
			previousProposalNumber = instance.getProposalNumber();
			
			//1, if this is a no-op value, just return the accepted value
			if (paxosValue == null){
				System.out.println("    Actor: phase 2: no-op ");
//					SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Accepted);
				// for a noop value, we just update the proposalNum and the state 
				// then return the accepted value no matter it is null or not
//					SimpleAccess.acceptValue(tableName, range, instanceNum, proposalNum, null);
//					instance.setProposalNumber(proposalNum);
//					instance.setState(PaxosState.Accepted);
				success = true;
				acceptedValue = instance.getPaxosValue();
			}
			//2, check its state
			else if ((PaxosState.Pending.equals(instance.getState()) || PaxosState.Accepted.equals(instance.getState())) 
					&& instance.getProposalNumber() <= proposalNum){
				System.out.println("    Actor: phase 2: accepting value "+ paxosValue.getValue());
				//3, else, make an accept stabilization
				SimpleAccess.acceptValue(tableName, range, instanceNum, proposalNum, paxosValue);
				setCurrentInstanceTimestamp(tableName, range, paxosValue.getTimestamp());
//				PaxosInstance i = SimpleAccess.getInstance(tableName, range, instanceNum);
////				assert i.getPaxosValue().equals(instance.getPaxosValue());
//				if (i.getPaxosValue() != null)
//					System.out.println("value from cassandra: " + i.getPaxosValue().getValue());
				instance.setProposalNumber(proposalNum);
				instance.setPaxosValue(paxosValue);
				instance.setState(PaxosState.Accepted);
				success = true;
				acceptedValue = paxosValue;
			}
			else{
				System.out.println("    Actor: phase 2: ignore");
				return new AcceptResult(false, previousProposalNumber, acceptedValue);
			}
			return new AcceptResult(success, previousProposalNumber, acceptedValue);
		}
	}
	
	

	public static AcceptResult acceptInstance(AcceptMessage acceptMessage) throws NullPointerException{
		return acceptInstance(
				acceptMessage.getTableName(), 
				acceptMessage.getRange(), 
				acceptMessage.getInstanceNumber(), 
				acceptMessage.getProposalNumber(), 
				acceptMessage.getPaxosValue()
			);
	}
	
	@Deprecated
	public static boolean closeInstance(String tableName, Range range, long instanceNum, boolean consensus){
		if (consensus){
			PaxosInstance instance = getInstance(tableName, range, instanceNum);
			if (instance != null){
				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Accepted);
				return true;
			}
			else 
				return false;
		}
		else{
			PaxosInstance instance = getInstance(tableName, range, instanceNum);
			if (instance != null){
				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Hole);
				return true;
			}
			else 
				return false;
		}
	}
	
	/***
	 * deliver value for instance.
	 * deliver no-op value if paxosValue is null
	 * @param tableName
	 * @param range
	 * @param instanceNum
	 * @param paxosValue
	 * @return
	 * @throws NullPointerException
	 */
	public static boolean deliverInstance(String tableName, Range range, long instanceNum, IPaxosValue paxosValue) throws NullPointerException{
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		if (instance == null) return false;
		synchronized (instance){
			//1, if this is a no-op value, just close this instance
			if (paxosValue == null){
				//2, check state, if already delivered noop, check the value
				if (PaxosState.Hole.equals(instance.getState())){
					if (instance.getChosenValue() == null)
						return true;
					else 
						return false;
				}
				SimpleAccess.deliverNoOpValue(tableName, range, instanceNum);
				setCurrentCommitNum(tableName, range, instanceNum);
				instance.setChosenValue(null);
				instance.setState(PaxosState.Hole);
				return true;
			}
			else{
				//2, check state, if already delivered, check the value
				if (PaxosState.Delivered.equals(instance.getState())){ 
					if (paxosValue.equals(instance.getChosenValue())){
						return true;
					}
					else
						return false;
				}
				//3, else, make an accept stabilization
				SimpleAccess.deliverValue(tableName, range, instanceNum, paxosValue);
				setCurrentCommitNum(tableName, range, instanceNum);
				//TODO delete debug codes
				PaxosInstance i = SimpleAccess.getInstance(tableName, range, instanceNum);
//				assert i.getPaxosValue().equals(instance.getPaxosValue());
				if (i.getPaxosValue() != null)
					System.out.println("delivered Value: " + i.getPaxosValue().getValue());
				instance.setState(PaxosState.Delivered);
				instance.setChosenValue(paxosValue);
				return true;
			}
		}
	}

	public static boolean deliverInstance(DeliverMessage deliverMessage) {
		return deliverInstance(
				deliverMessage.getTableName(), 
				deliverMessage.getRange(), 
				deliverMessage.getInstanceNumber(), 
				deliverMessage.getPaxosValue());
	}
	
	public static boolean applyInstance(String tableName, Range range, long instanceNum){
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		if (instance == null) return false;
		synchronized (instance){
			if (PaxosState.Hole.equals(instance.getState())){
				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Applied);
				instance.setState(PaxosState.Applied);
				if ((getCurrentApplyNum(tableName, range) + 1) == instanceNum)
					setCurrentApplyNum(tableName, range, instanceNum);
				return true;
			}
			else if (PaxosState.Delivered.equals(instance.getState())){
				try {
					instance.getChosenValue().apply();
				} catch (IOException e) {
					e.printStackTrace();
				}
				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Applied);
				instance.setState(PaxosState.Applied);
				if ((getCurrentApplyNum(tableName, range) + 1) == instanceNum)
					setCurrentApplyNum(tableName, range, instanceNum);
				return true;
			}
			else if (PaxosState.Applied.equals(instance.getState())){
				return true;
			}
			return false;
		}
	}
	
	public static boolean applyInstance(DeliverMessage deliverMessage) {
		return applyInstance(
				deliverMessage.getTableName(), 
				deliverMessage.getRange(), 
				deliverMessage.getInstanceNumber());
	}
	
//	public static boolean repairAndApplyInstance(String tableName, Range range, long instanceNum){
//		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
//		if (instance == null) return false;
//		synchronized (instance){
//			if (PaxosState.Hole.equals(instance.getState())){
//				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Applied);
//				instance.setState(PaxosState.Applied);
//				return true;
//			}
//			else if (PaxosState.Delivered.equals(instance.getState())){
//				try {
//					instance.getChosenValue().apply();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Applied);
//				instance.setState(PaxosState.Applied);
//				return true;
//			}
//			else if (PaxosState.Applied.equals(instance.getState())){
//				return true;
//			}
//			// start an no-op phase 2
//			else {
//				
//			}
//			return false;
//		}
//	}
	
	public static long getCurrentInstanceNum(String tableName, Range range){
		return replicaGroupStates.get(tableName).get(range).getCurrentInstanceNum();
//		return SimpleAccess.getCurrentInstanceNum(tableName, range);
	}
	
	public static long getCurrentTimestamp(String tableName, Range range){
		return replicaGroupStates.get(tableName).get(range).getCurrentTimestamp();
//		return SimpleAccess.getCurrentInstanceTimestamp(tableName, range);
	}
	
	public static long getCurrentCommitNum(String tableName, Range range){
		return replicaGroupStates.get(tableName).get(range).getCurrentCommitNum();
//		return SimpleAccess.getCurrentCommitNum(tableName, range);
	}
	
	public static long getCurrentApplyNum(String tableName, Range range){
		return replicaGroupStates.get(tableName).get(range).getCurrentApplyNum();
//		return SimpleAccess.getCurrentApplyNum(tableName, range);
	}
	
	public static long getMinInstanceNum(String tableName, Range range){
		return replicaGroupStates.get(tableName).get(range).getMinInstanceNum();
	}
	
	public static void setCurrentApplyNum(String tableName, Range range, long applyNum){
		replicaGroupStates.get(tableName).get(range).setCurrentApplyNum(applyNum);
//		SimpleAccess.setCurrentApplyNum(tableName, range, applyNum);
	}
	
	private static void setCurrentInstanceTimestamp(String tableName, Range range, long timestamp) {
		replicaGroupStates.get(tableName).get(range).setCurrentInstanceTimestamp(timestamp);
//		SimpleAccess.setCurrentInstanceTimestamp(tableName, range, timestamp);
	}
	
	private static void setCurrentCommitNum(String tableName, Range range, long instanceNum) {
		replicaGroupStates.get(tableName).get(range).setCurrentCommitNum(instanceNum);
//		SimpleAccess.setCurrentCommitNum(tableName, range, instanceNum);
	}
	
	public static void setMinInstanceNum(String tableName, Range range, long instanceNum){
		replicaGroupStates.get(tableName).get(range).setMinInstanceNum(instanceNum);
	}
	
//	/***
//	 * a convenient method to accept, 
//	 * which call getInstance first and promiseInstance then.
//	 * @param acceptMessage
//	 * @return
//	 * @throws NullPointerException
//	 */
//	public static boolean tryAcceptInstance(AcceptMessage acceptMessage) throws NullPointerException{
//		
//		return acceptInstance(
//				acceptMessage.getTableName(), 
//				acceptMessage.getRange(), 
//				acceptMessage.getInstanceNumber(), 
//				acceptMessage.getProposalNumber(), 
//				acceptMessage.getPaxosValue()
//			);
//	}
	
//	public static void updateState(String tableName, Range range, long instanceNum, String state){
//		
//	}
//	
//	public static void updateProposalNum(String tableName, Range range, long instanceNum, long proposalNum){
//		
//	}
//	
//	public static void updateValue(String tableName, Range range, long instanceNum, long proposalNum, IPaxosValue value){
//		
//	}
	
	//TODO
	public static long getExpireTime(){
		return 50000;
	}

	
}
