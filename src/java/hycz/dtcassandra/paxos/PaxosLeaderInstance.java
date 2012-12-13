package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.callback.AcceptResponseHandler;
import hycz.dtcassandra.paxos.callback.DeliverResponseHandler;
import hycz.dtcassandra.paxos.callback.IPaxosResponseHandler;
import hycz.dtcassandra.paxos.callback.PaxosResponseType;
import hycz.dtcassandra.paxos.callback.PrepareResponseHandler;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.DeliverMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.transaction.NWRLevel;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/***
 * This class is an overall view of a Paxos instance for a leader.
 * 
 * @author Hycz
 *
 */
public class PaxosLeaderInstance {
	private static Logger logger = LoggerFactory.getLogger(PaxosLeaderInstance.class);
	
	private final String tableName;
	private final Range range;
	
//	private final PaxosInstance instance;
	private final Long instanceNum;
	private AtomicLong proposalNum;
//	private Long promisedProposalNumber = new Long(0);
	private IPaxosValue paxosValue;
	private String state;
	
	private long timestamp;
	
//	private IPaxosValue paxosValueAfterPhase1;
//	private Long proposalNumberAfterPhase1;
//	private Set<InetAddress> promiseRecieved;
//	private IPaxosValue paxosValueForPhase2;
//	private boolean isClientValue;
	
	
	
	public PaxosLeaderInstance(String tableName, Range range, long instanceNum) {
		this.tableName = tableName;
		this.range = range;
		this.instanceNum = instanceNum;
		// try to recover
		PaxosInstance existed = PaxosInstanceManager.getOrNewInstance(tableName, range, instanceNum);
		if (existed != null && existed.getProposalNumber() >= 0){
			this.proposalNum = new AtomicLong(existed.getProposalNumber());
			this.paxosValue = existed.getPaxosValue();
		}
		else{
			this.proposalNum = new AtomicLong(0L);
			this.paxosValue = null;
		}
		state = existed.getState();
		this.timestamp = -1L;
	}
	
	/***
	 * 
	 * @param instanceNum need to guarantee unique when initialize
	 * @param proposalNum
	 * @param paxosValue
	 */
//	private PaxosLeaderInstance(String tableName, Range range, long instanceNumber, long proposalNumber, IPaxosValue paxosValue) {
//		this.tableName = tableName;
//		this.range = range;
//		this.instance = new PaxosInstance(instanceNumber, proposalNumber, paxosValue);
////		this.instanceNumber = instanceNumber;
////		this.proposalNumber = new AtomicLong(proposalNumber);
////		this.paxosValue = paxosValue;
//		state = PaxosState.Empty;
////		this.promisedProposalNumber = proposalNumber;
//	}
	
	
	
	//handle the progress of this instance
//	public void progress(Collection<InetAddress> acceptorEndpoints,
//			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
//			ConsistencyLevel consistency_level){
////		IPaxosResponseHandler responseHandler = getPaxosResponseHandler(acceptorEndpoints, witnessAcceptorEndpoints, ConsistencyLevel.ALL);
//		
//
//	}
//	
//	public void beforeFirstMessage(){
//		
//	}

	public PaxosResponseType executePhaseOne() throws IOException{
		Map<InetAddress, InetAddress> acceptors = ReplicationManager.instance().getReplicationAcceptors(tableName, range);
		Collection<InetAddress> acceptorEndpoints = acceptors.keySet();
		Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(acceptorEndpoints.size(), 1);
		for (Entry<InetAddress, InetAddress> entry : acceptors.entrySet()){
			witnessAcceptorEndpoints.put(entry.getValue(), entry.getKey());
		}
		
		//1, set prepare callback
		IPaxosResponseHandler prepareResponseHandler = 
			createPrepareResponseHandler(
					acceptorEndpoints, 
					witnessAcceptorEndpoints, 
					ConsistencyLevel.QUORUM);
		//2, make prepare message
		PrepareMessage preparemessage = new PrepareMessage(
				tableName, range, getInstanceNumber(), getProposalNumber());
//		System.out.println(preparemessage);
		//3, send messages
		for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints.asMap().entrySet()){
			InetAddress destination = entry.getKey();
            Collection<InetAddress> targets = entry.getValue();
            
            if (targets.size() == 1 && targets.iterator().next().equals(destination))
            {
        	   	MessagingService.instance().sendRR(
            			preparemessage.getMessage(MessagingService.version_), 
            			destination, 
            			prepareResponseHandler);
                
            }
            // witness 发送, 使用RowMutation.HINT标记这是一个发往witness的消息，
            // 在acceptor端，都要检验这个标记，如果发现是一个witness，则在固化时要 额外 使用一个HINT写
            else
            {
            	Message hintedMessage = preparemessage.getMessage(MessagingService.version_);
				for (InetAddress target : targets) {
					if (!target.equals(destination)) {
						logger.debug("A Hint appears: (destination = "
								+ destination.getHostAddress()
								+ ", target = " + target.getHostAddress()
								+ ")");
						 StorageProxy.addHintHeader(hintedMessage, target);
					}
				}	                
				logger.debug("sending the prepare message to " + destination.getHostAddress());
				MessagingService.instance().sendRR(hintedMessage, destination, prepareResponseHandler);				
            }
		}
		System.out.println("send over");
		
		//4, wait for prepare response
		PaxosResponseType prepareResult=prepareResponseHandler.get();
		
		setPaxosValue(((PrepareResponseHandler)prepareResponseHandler).getAcceptedPaxosValue());
		timestamp = ((PrepareResponseHandler)prepareResponseHandler).getTimestamp();
		
		return prepareResult;
	}
	
	public void moveToNoopAcceptPhase(){
		this.paxosValue = null;
	}
	
	//should be called after responseHandler.get()
	public boolean moveToAcceptPhase(IPaxosValue paxosValue){
		return setPaxosValue(paxosValue);
	}
	
	public PaxosResponseType executePhaseTwo() throws IOException{
		if (getPaxosValue() == null) return executePhaseTwo(null, true);
		return executePhaseTwo(null, false);
	}
	
	/***
	 * execute phase two with no-op value
	 * @return
	 * @throws IOException
	 */
	public PaxosResponseType executePhaseTwoWithNoOp() throws IOException {
		return executePhaseTwo(null, true);
	}
	
	public PaxosResponseType executePhaseTwo(IPaxosValue value) throws IOException{
		return executePhaseTwo(value, false);
	}
	
	private PaxosResponseType executePhaseTwo(IPaxosValue value, boolean noop) throws IOException{
		Map<InetAddress, InetAddress> acceptors = ReplicationManager.instance().getReplicationAcceptors(tableName, range);
		Collection<InetAddress> acceptorEndpoints = acceptors.keySet();
		Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(acceptorEndpoints.size(), 1);
		for (Entry<InetAddress, InetAddress> entry : acceptors.entrySet()){
			witnessAcceptorEndpoints.put(entry.getValue(), entry.getKey());
		}
		
//		ConsistencyLevel cl;
//		if (NWRLevel)
		if (!noop && !(getPaxosValue() != null || value != null)) return PaxosResponseType.Error;
		if (noop) 
			moveToNoopAcceptPhase();
		else
			moveToAcceptPhase(value);
		if (!noop){
			long timestamp = System.currentTimeMillis();
			//this.timestamp is either -1 or the highest timestamp got from phase 1
			while (timestamp < this.timestamp){
				++timestamp;
			}
			this.timestamp = timestamp;
			this.paxosValue.setTimestamp(this.timestamp);
		}
		//1, set accept callback
		IPaxosResponseHandler acceptResponseHandler = noop ?
			createAcceptResponseHandler(
					acceptorEndpoints, 
					witnessAcceptorEndpoints, 
					ConsistencyLevel.ALL)
			:
			createAcceptResponseHandler(
					acceptorEndpoints, 
					witnessAcceptorEndpoints, 
					ConsistencyLevel.QUORUM)
					;
		//2, find out which value to accept
		
//		logger.debug("instance "+instance.instanceNumber +" 's value is set to "+instance.paxosValue.getValue());
		//already done in responseHandler.get()
					
//		System.out.println("timestamp is set to "+ this.paxosValue.getTimestamp());
		//3, make accept message
		AcceptMessage acceptMessage = new AcceptMessage(tableName, range, getInstanceNumber(), getProposalNumber(), getPaxosValue());
//		System.out.println(acceptMessage);
		
		//4, send message
		for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints.asMap().entrySet()) {
			InetAddress destination = entry.getKey();
			Collection<InetAddress> targets = entry.getValue();

			// 本地
			if (targets.size() == 1 && targets.iterator().next().equals(destination))
            {
				logger.debug("sending the accept message to "
						+ destination.getHostAddress());
        	   	MessagingService.instance().sendRR(
        	   			acceptMessage.getMessage(MessagingService.version_), 
            			destination, 
            			acceptResponseHandler);
            }
			// witness 发送, 使用RowMutation.HINT标记这是一个发往witness的消息，
            // 在acceptor端，都要检验这个标记，如果发现是一个witness，则在固化时要 额外 使用一个HINT写
            else
            {
            	Message hintedMessage = acceptMessage.getMessage(MessagingService.version_);
				for (InetAddress target : targets) {
					if (!target.equals(destination)) {
						logger.debug("A Hint appears: (destination = "
								+ destination.getHostAddress()
								+ ", target = " + target.getHostAddress()
								+ ")");
						 StorageProxy.addHintHeader(hintedMessage, target);
					}
				}	                
				logger.debug("sending the accept message to " + destination.getHostAddress());
				MessagingService.instance().sendRR(hintedMessage, destination, acceptResponseHandler);				
            }
		}
		
		//5, wait for accept response
		PaxosResponseType acceptResult = acceptResponseHandler.get();
//		this.paxosValue = ((AcceptResponseHandler)acceptResponseHandler).getAcceptedValue();
		return acceptResult;
	}
	
	public PaxosResponseType deliverValueWithNoOp(ConsistencyLevel consistencyLevel) throws IOException {
		return deliverValue(null, true, consistencyLevel);
	}
	
	public PaxosResponseType deliverValue(ConsistencyLevel consistencyLevel) throws IOException{
		return deliverValue(null, false, consistencyLevel);
	}
	
	public PaxosResponseType deliverValue(IPaxosValue value, ConsistencyLevel consistencyLevel) throws IOException{
		return deliverValue(value, false, consistencyLevel);
	}
	
	private PaxosResponseType deliverValue(IPaxosValue value, boolean noop, ConsistencyLevel consistencyLevel) throws IOException{
		List<InetAddress> learners = ReplicationManager.instance().getReplicationLearners(tableName, range);
		
		//1, set deliver callback
		IPaxosResponseHandler deliverResponseHandler = 
			createDeliverResponseHandler(
					learners,
					consistencyLevel);
		//2, find out which value to deliver
		if (!noop && !(getPaxosValue() != null || value != null)) return PaxosResponseType.Error;
		if (noop) value = null;
		
		//3, make deliver message
		DeliverMessage deliverMessage = new DeliverMessage(tableName, range, getInstanceNumber(), getProposalNumber(), getPaxosValue());
//		System.out.println(deliverMessage);
		
		//4, send message
		//TODO may use HINT
		for (InetAddress target : learners){
			MessagingService.instance().sendRR(
					deliverMessage.getMessage(MessagingService.version_), 
        			target, 
        			deliverResponseHandler);
		}
		
		//5, wait for accept response
		PaxosResponseType deliverResult = deliverResponseHandler.get();
		return deliverResult;
	}
	
	public boolean closeInstance(boolean consensus){
		return PaxosInstanceManager.closeInstance(tableName, range, instanceNum, consensus);
	}
	
	private PrepareResponseHandler prepareResponseHandler = null;
	private AcceptResponseHandler acceptResponseHandler = null;
	private DeliverResponseHandler deliverResponseHandler = null;
	
	/***
	 * if prepareResponseHandler != null, returen it
	 * if prepareResponseHandler == null, create one and return it
	 * @return
	 */
	public PrepareResponseHandler getPrepareResponseHandler(){
		return prepareResponseHandler;
	}
	
	public AcceptResponseHandler getAcceptResponseHandler(){
//		synchronized (acceptResponseHandler){
			return acceptResponseHandler;
//		}
	}
	
	public DeliverResponseHandler getDeliverResponseHandler(){
		return deliverResponseHandler;
	}
	
	public IPaxosResponseHandler createPrepareResponseHandler(
			Map<InetAddress, InetAddress> acceptors,
			ConsistencyLevel consistency_level) {
		synchronized (this){
			prepareResponseHandler =  PrepareResponseHandler.create(tableName, range, instanceNum, acceptors,
					consistency_level);
			return prepareResponseHandler;
		}
	}
	
	public IPaxosResponseHandler createPrepareResponseHandler(
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistency_level) {
		synchronized (this){
			prepareResponseHandler =  PrepareResponseHandler.create(tableName, range, instanceNum, acceptorEndpoints,
					witnessAcceptorEndpoints, consistency_level);		
			return prepareResponseHandler;
		}
	}
	
	public IPaxosResponseHandler createAcceptResponseHandler(
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistency_level) {
		synchronized (this){
			acceptResponseHandler = AcceptResponseHandler.create(tableName, range, instanceNum, acceptorEndpoints,
					witnessAcceptorEndpoints, consistency_level, this.paxosValue);
			return acceptResponseHandler;
		}
	}
	
	public IPaxosResponseHandler createDeliverResponseHandler(
			Collection<InetAddress> learnerEndpoints,
			ConsistencyLevel consistency_level) {
		synchronized (this){
			deliverResponseHandler = DeliverResponseHandler.create(tableName, range, instanceNum, learnerEndpoints, consistency_level);
			return deliverResponseHandler;
		}
	}
	
	public boolean increaseProposalNumber(){
		try{
			proposalNum.getAndAdd(paxosValue.getTable().getReplicationStrategy().getReplicationFactor());
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public boolean setPaxosValue(IPaxosValue paxosValue){
		if (this.paxosValue == null){
			this.paxosValue=paxosValue;
			return true;
		}
		return false;
	}
	
	public IPaxosValue getPaxosValue(){
		return this.paxosValue;
	}
	
	public Long getInstanceNumber(){
		return instanceNum;
	}
	
//	public long getInstanceNumber(){
//		return instanceNumber.longValue();
//	}
//	
	public long getProposalNumber() {
		return proposalNum.get();
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	
}
