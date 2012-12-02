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

import com.google.common.base.Function;

public class PaxosInstanceManager {

	private static final Map<String, Map<Range, ExpiringMap<Long, PaxosInstance>>> instances;
	
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
        Set<String> tables = DatabaseDescriptor.getTables();
    	for(String tableName : tables){
    		instances.put(tableName, new HashMap<Range, ExpiringMap<Long, PaxosInstance>>());
    		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
    			instances.get(tableName).put(range, new ExpiringMap<Long, PaxosInstance>(getExpireTime(), expiredInstanceHandler));
    		}
    	}
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
	
	public static PromiseResult promiseInstance(String tableName, Range range, long instanceNum, long proposalNum) throws NullPointerException{
		boolean success = false;
		long previousProposalNumber = -1;
		IPaxosValue acceptedValue = null;
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		synchronized (instance){
			//1, check its state
			if (instance.getProposalNumber() <= proposalNum){
				//2, make a promise stabilization
				SimpleAccess.updateProposalNum(tableName, range, instanceNum, proposalNum);
				instance.setProposalNumber(proposalNum);
				success = true;
			}
			else{
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
	
	public static boolean acceptInstance(String tableName, Range range, long instanceNum, long proposalNum, IPaxosValue paxosValue) throws NullPointerException{
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		if (instance == null) return false;
		synchronized (instance){
			//1, check its state
//			if (instance.getProposalNumber() <= proposalNum && (instance.getPaxosValue() == null || instance.getPaxosValue().equals(paxosValue))){
			if (instance.getProposalNumber() <= proposalNum ){
				//2, if this is a no-op value, just close this instance
				if (paxosValue == null){
					SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Closed);
					return true;
				}
				//3, else, make an accept stabilization
				SimpleAccess.closeWithValue(tableName, range, instanceNum, proposalNum, paxosValue);
				PaxosInstance i = SimpleAccess.getInstance(tableName, range, instanceNum);
//				assert i.getPaxosValue().equals(instance.getPaxosValue());
				if (i.getPaxosValue() != null)
					System.out.println("value from cassandra: " + i.getPaxosValue().getValue());
				instance.setProposalNumber(proposalNum);
				instance.setPaxosValue(paxosValue);
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public static boolean acceptInstance(AcceptMessage acceptMessage) throws NullPointerException{
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
				SimpleAccess.updateState(tableName, range, instanceNum, PaxosState.Closed);
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
			//2, if this is a no-op value, just close this instance
			if (paxosValue == null){
				SimpleAccess.deliverNoOpValue(tableName, range, instanceNum);
				return true;
			}
			else{
				//3, else, make an accept stabilization
				SimpleAccess.deliverValue(tableName, range, instanceNum, paxosValue);
				//TODO delete debug codes
				PaxosInstance i = SimpleAccess.getInstance(tableName, range, instanceNum);
//				assert i.getPaxosValue().equals(instance.getPaxosValue());
				if (i.getPaxosValue() != null)
					System.out.println("delivered Value: " + i.getPaxosValue().getValue());
				instance.setPaxosValue(paxosValue);
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
