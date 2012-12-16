package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.actor.ActorRole;
import hycz.dtcassandra.paxos.callback.IPaxosResponseHandler;
import hycz.dtcassandra.paxos.callback.PaxosResponseType;
import hycz.dtcassandra.paxos.callback.PrepareResponseHandler;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;
import hycz.dtcassandra.transaction.NWRLevel;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;

import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.net.IMessageCallback;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.utils.ExpiringMap;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.Pair;
import org.apache.cassandra.utils.SimpleCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.nio.ch.SocketOpts.IP;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/***
 * manage all Paxos instances for a token range
 * @author Hycz
 *
 */
public class PaxosLeaderInstanceManager {
	private static Logger logger = LoggerFactory.getLogger(PaxosLeaderInstanceManager.class);
	
	//TODO find real instance number that we should use
	public AtomicLong instanceNumberGen;
	public Long getNewInstanceNumber(){
		return instanceNumberGen.incrementAndGet();
	}
	
	public String tableName;
	public Range range;
	//Map<instance number, instance reference>
	private final ExpiringMap<Long, PaxosLeaderInstance> leaderInstances;
//	SimpleCondition condition = new SimpleCondition();
	private BlockingDeque<IPaxosValue> queue = new LinkedBlockingDeque<IPaxosValue>();
	
	private boolean isSteady;
	
	public PaxosLeaderInstanceManager(String tableName, Range range){
		this.tableName = tableName;
		this.range = range;
		Function<Pair<Long, PaxosLeaderInstance>, ?> expiredInstanceHandler = new Function<Pair<Long, PaxosLeaderInstance>, Object>()
        {
            public Object apply(Pair<Long, PaxosLeaderInstance> pair)
            {
//                PaxosLeaderInstance expiredValue = pair.right;

                //check instance state, flush if necessary
                //TODO
                return null;
            }
        };
        
//		paxosInstances=new ExpiringMap<String, PaxosInstance>((long) (1.1 * DatabaseDescriptor.getRpcTimeout()), timeoutReporter);;
		leaderInstances=new ExpiringMap<Long, PaxosLeaderInstance>(getExpireTime(), expiredInstanceHandler);
		long currentInstanceNum = PaxosInstanceManager.getCurrentInstanceNum(tableName, range);
//		System.out.println("table = " + tableName + " range = " + range + " currentInstanceNum = " + currentInstanceNum);
		if (currentInstanceNum <= -1){
			instanceNumberGen = new AtomicLong(-1);
		}
		else {
			instanceNumberGen = new AtomicLong(currentInstanceNum);
		}
		
		isSteady = false;
	}
	
	// execute phase 1 to find a phase 1
	private PaxosLeaderInstance getNextEmptyLeaderInstance() throws IOException{
		long instanceNum = getNewInstanceNumber();
		// if not steady, then execute phase 1 to get an empty instance
		if (!isSteady){
			//1, get an leader instance
			final PaxosLeaderInstance instance = getAndCreateLeaderInstance(instanceNum);
			while (true){
				//2, execute phase one
				PaxosResponseType prepareResult = instance.executePhaseOne();
				
				if (prepareResult == PaxosResponseType.Timeout){
					logger.debug("prepare result: Timeout");
					System.out.println("Leader: prepare result: Timeout");
					instance.increaseProposalNumber();
					continue;
				}
				else if (prepareResult==PaxosResponseType.Nack){
					logger.debug("prepare result: Nack");
					System.out.println("Leader: prepare result: Nack");
					try {
						while (instance.getProposalNumber() < instance.getPrepareResponseHandler().getPromisedProposalNumber()){
							instance.increaseProposalNumber();
						}
					}catch(NullPointerException e){
						e.printStackTrace();
					}
					continue;
				}
				else if (prepareResult==PaxosResponseType.Quorum){
					logger.debug("prepare result: Quorum");
					System.out.println("Leader: prepare result: Quorum");
					break;
				}
			}
			// if get an empty instance
			if (instance.getPaxosValue() == null) {
				return instance;
			}
			/***
			 *  If get a non-empty instance, continue it and try to get a new empty instance.
			 *  Leader will call this method only when it thinks all the existed instances are closed.
			 *  So this means some other leader is also proposing some value and this local leader 
			 *  already disturbed that instance. 
			 *  The only thing this local leader should do is to continue this instance, 
			 *  and this leader confliction will cause the old leader to give up.
			 */ 
			else {
				//3, recover this instance
//				Runnable recover = new Runnable() {
				long num = instance.getInstanceNumber();
//					public void run() {
				System.out.println("Leader: trying to recover instance " + num);
				try {
					PaxosResponseType acceptResult = instance.executePhaseTwo();
					if (acceptResult == PaxosResponseType.Quorum){
						logger.debug("recover : accept result: Quorum");
						System.out.println("Leader: recover : accept result: Quorum");
					}
					else if (acceptResult == PaxosResponseType.Timeout){
						logger.debug("recover : accept result: Timeout");
						System.out.println("Leader: recover : accept result: Timeout");
						
						// accept fail, try to execute phase one to make this replica leader
						while (true){
							isSteady = false;
//							acceptResult = instance.executePhaseTwo();
//							if (acceptResult == PaxosResponseType.Quorum){
//								break;
//							}
//							else if (acceptResult == PaxosResponseType.Timeout){
//								continue;
//							}
						
							PaxosResponseType prepareResult = instance.executePhaseOne();
							if (prepareResult == PaxosResponseType.Timeout){
								logger.debug("recover : prepare result: Timeout");
								instance.increaseProposalNumber();
								continue;
							}
							else if (prepareResult==PaxosResponseType.Nack){
								logger.debug("recover : prepare result: Nack");
								try {
									while (instance.getProposalNumber() < instance.getPrepareResponseHandler().getPromisedProposalNumber()){
										instance.increaseProposalNumber();
									}
								} catch(NullPointerException e){
									e.printStackTrace();
								}
								continue;
							}
							else if (prepareResult==PaxosResponseType.Quorum){
								logger.debug("recover : prepare result: Quorum");
								
								acceptResult = instance.executePhaseTwo();
								if (acceptResult == PaxosResponseType.Quorum){
									break;
								}
								else if (acceptResult == PaxosResponseType.Timeout){
									continue;
								}
							}
						}								
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
//				};
//				StageManager.getStage(Stage.PAXOS_LEADER).execute(recover);
				
			//4, try to get a new empty instance
			return getNextEmptyLeaderInstance();
//			}
		}
		// if steady, then skip phase 1
		else {
			return getAndCreateLeaderInstance(instanceNum);
		}
	}
	
	/***
	 * ���ص������ռ�¼��value���Ǹ�instance num
	 * @param value
	 * @return ���ص������ռ�¼��value���Ǹ�instance num, ʧ���򷵻�-1
	 */
	public long makeConsensus(IPaxosValue value){
		try {
			PaxosLeaderInstance empty = null;
			while (true){
				empty = getNextEmptyLeaderInstance();
				if (empty.moveToAcceptPhase(value)){
					PaxosResponseType acceptResult = empty.executePhaseTwo();
					if (acceptResult == PaxosResponseType.Quorum){
						logger.debug("accept result: Quorum");
						System.out.println("Leader: accept result: Quorum");
						isSteady = true;
					}
					else if (acceptResult == PaxosResponseType.Timeout){
						logger.debug("accept result: Timeout");
						System.out.println("Leader: accept result: Timeout");
						isSteady = false;
						boolean getResult = false;
						// accept fail, try to execute phase one to make this replica leader
						while (true){
							PaxosResponseType prepareResult = empty.executePhaseOne();
							if (prepareResult == PaxosResponseType.Timeout){
								logger.debug("prepare result: Timeout");
								System.out.println("Leader: prepare result: Timeout");
								empty.increaseProposalNumber();
								continue;
							}
							else if (prepareResult==PaxosResponseType.Nack){
								logger.debug("prepare result: Nack");
								System.out.println("Leader: prepare result: Nack");
								try {
									while (empty.getProposalNumber() < empty.getPrepareResponseHandler().getPromisedProposalNumber()){
										empty.increaseProposalNumber();
									}
								} catch(NullPointerException e){
									e.printStackTrace();
								}
								continue;
							}
							else if (prepareResult==PaxosResponseType.Quorum){
								logger.debug("prepare result: Quorum");
								System.out.println("Leader: prepare result: Quorum");
								acceptResult = empty.executePhaseTwo();
								if (acceptResult == PaxosResponseType.Quorum){
									//executed an instance with an existed value
									if (!value.equals(empty.getPaxosValue())){	
										getResult = false;
										break;
									}
									//success
									else {
										getResult = true;
										break;
									}
								}
								else if (acceptResult == PaxosResponseType.Timeout){
									continue;
								}
								else if (acceptResult == PaxosResponseType.NoConsensus){
									getResult = false;
									break;
								}
							}
						}
						if (!getResult){
							continue;
						}						
					}
					System.out.println("timestamp of instance " + empty.getInstanceNumber() + " = " + empty.getPaxosValue().getTimestamp());
					break;
				}
				else {
					continue;
				}
			}		
			return empty.getInstanceNumber();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean deliverValue(long instanceNum, ConsistencyLevel consistencyLevel){
		final PaxosLeaderInstance instance = getAndCreateLeaderInstance(instanceNum);
		try {
			PaxosResponseType result = instance.deliverValue(consistencyLevel);
			if (result == PaxosResponseType.Quorum){
				return true;
			}
			else if (result == PaxosResponseType.Timeout){
				return false;
			}
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	/***
	 * the commit point is that a majority of acceptors has accepted a value
	 * so, we find out this value.
	 * if this value exists, we deliver it,
	 * if not, we deliver no-op value
	 * @param instanceNum
	 * @return true if successfully delivered some value locally, false if timeout
	 */
	public boolean recoverWithNoop(long instanceNum){
		final PaxosLeaderInstance instance = getAndCreateLeaderInstance(instanceNum);
		
		//1, check if this instance reach consensus before
		PaxosResponseType acceptResult;
		try {
			acceptResult = instance.executePhaseTwoWithNoOp();
			System.out.println("get value for instance " + instanceNum + " using no-op phase 2 : " 
					+ (instance.getAcceptResponseHandler().getAcceptedValue()==null?null:instance.getAcceptResponseHandler().getAcceptedValue().getValue()));
		
			//2, if so, deliver the consensus value
			if (acceptResult == PaxosResponseType.Quorum){
				logger.debug("recover : a value is chosen by no-op phase 2");
				System.out.println("recover : a value is chosen by no-op phase 2");
				Runnable deliverAndApply = new Runnable(){
					public void run(){
						instance.setPaxosValue(instance.getAcceptResponseHandler().getAcceptedValue());
						try {
							instance.deliverValue(ConsistencyLevel.ONE);
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
				};
				StageManager.getStage(Stage.PAXOS_DELIVER).execute(deliverAndApply);
				return PaxosInstanceManager.deliverInstance(tableName, range, instanceNum, instance.getAcceptResponseHandler().getAcceptedValue());
			}
			//3, if not, deliver noop value
			else if (acceptResult == PaxosResponseType.NoConsensus){
				logger.debug("recover : no consensus is reached, deliver no-op");
				System.out.println("recover : no consensus is reached, deliver no-op");
				Runnable deliverAndApply = new Runnable(){
					public void run(){
						try {
							instance.deliverValueWithNoOp(ConsistencyLevel.ANY);
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
				};
				StageManager.getStage(Stage.PAXOS_DELIVER).execute(deliverAndApply);
				return PaxosInstanceManager.deliverInstance(tableName, range, instanceNum, null);
			}
			else if (acceptResult == PaxosResponseType.Timeout){
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}		
	
	public boolean cleanupExpired(){
		//1, get min apply num of this replica group
		Map<InetAddress, InetAddress> acceptors = ReplicationManager.instance().getReplicationAcceptors(tableName, range);
		Collection<InetAddress> acceptorEndpoints = acceptors.keySet();
		Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(acceptorEndpoints.size(), 1);
		for (Entry<InetAddress, InetAddress> entry : acceptors.entrySet()){
			witnessAcceptorEndpoints.put(entry.getValue(), entry.getKey());
		}
		
		//1.1, set prepare callback
		IPaxosResponseHandler prepareResponseHandler = 
			PrepareResponseHandler.create(tableName, range, -1, acceptors, ConsistencyLevel.ALL);
		//1.2, make prepare message
		PrepareMessage preparemessage = new PrepareMessage(
				tableName, range, -1, -1);
//		System.out.println(preparemessage);
		//1.3, send messages
		for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints.asMap().entrySet()){
			InetAddress destination = entry.getKey();
            Collection<InetAddress> targets = entry.getValue();
            
            if (targets.size() == 1 && targets.iterator().next().equals(destination))
            {
        	   	try {
					MessagingService.instance().sendRR(
							preparemessage.getMessage(MessagingService.version_), 
							destination, 
							prepareResponseHandler);
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            }
		}
//		System.out.println("send over");
		
		//1.4, wait for prepare response
		PrepareResponseHandler prh= (PrepareResponseHandler) prepareResponseHandler;
		PaxosResponseType prepareResult = prepareResponseHandler.get();
		
//		final long currentCommitNum = prh.getPromisedProposalNumber();
//		final long currentTimestamp = prh.getTimestamp();
		final long minApplyNum = prh.getInstanceNumber();
		
		final long minInstanceNum = PaxosInstanceManager.getMinInstanceNum(tableName, range);
		//2, clean up
//		System.out.println("cleanup from "+minInstanceNum+" to "+minApplyNum);

		for (long i=minInstanceNum<0?0:minInstanceNum; i <= minApplyNum; ++i){
			try{
				PaxosInstanceManager.deleteInstance(tableName, range, i);
			}catch(Exception e){
				e.printStackTrace();
			}
			PaxosInstanceManager.setMinInstanceNum(tableName, range, i+1);
		}
		return true;
	}
	
	private PaxosLeaderInstance getAndCreateLeaderInstance(Long instanceNum){
		PaxosLeaderInstance instance = getLeaderInstance(instanceNum);
		if (instance != null) 
			return instance;
		else{
			return putLeaderInstance(instanceNum, new PaxosLeaderInstance(tableName, range, instanceNum));
		}
	}

	private PaxosLeaderInstance getLeaderInstance(Long instanceNum){
		return leaderInstances.get(instanceNum);
	}
	
	public PaxosLeaderInstance putLeaderInstance(Long instanceNum, PaxosLeaderInstance instance){
		PaxosLeaderInstance existed = getLeaderInstance(instanceNum);
		if (existed == null){
			synchronized(leaderInstances){
				if ((existed = getLeaderInstance(instanceNum)) == null){
					leaderInstances.put(instanceNum, instance);
					return instance;
				}
				return existed;
			}
		}
		return existed;
	}
		
	//just for test
	public PaxosLeaderInstance getAndCreateLeaderInstance() {
		long instanceNumber;
		PaxosLeaderInstance instance;
		do {
			instanceNumber = getNewInstanceNumber();
			instance = leaderInstances.get(instanceNumber);
			if (instance == null){
				instance = new PaxosLeaderInstance(tableName, range, instanceNumber);
				leaderInstances.put(instanceNumber, instance);
			}
		}
		while(instance.getPaxosValue() != null);
		return instance;
	}
	

	
	public PaxosLeaderInstance getLeaderInstance(long instanceNumber){
		return leaderInstances.get(instanceNumber);
	}
	
	private boolean addLeaderInstance(PaxosLeaderInstance instance) {
		leaderInstances.put(instance.getInstanceNumber(), instance);
		return true;
	}
	
	//TODO
	public static long getExpireTime(){
		return 50000;
	}
	
	//maintain a boundary that distinguish out-of-date instances
	//any instance that has an instance number smaller than or equal to this number is out-of-date
	//TODO multi-thread problem
	private static long outOfDateInstanceNumber;
	
	public static boolean shouldAbandon(long instanceNumber){
		if (instanceNumber<=outOfDateInstanceNumber) return true;
		else return false;
	}
	
	public static void updateOutOfDateInstanceNumber(long instanceNumber){
		if (instanceNumber<=outOfDateInstanceNumber) return ;
		else 
			outOfDateInstanceNumber=instanceNumber;
	}
	
	public void readyToLearn(){
		
	}

}
