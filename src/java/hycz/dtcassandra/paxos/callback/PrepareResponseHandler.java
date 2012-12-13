package hycz.dtcassandra.paxos.callback;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.PaxosLeaderInstance;
import hycz.dtcassandra.paxos.PaxosLeaderInstanceManager;
import hycz.dtcassandra.paxos.PaxosOverallManager;
import hycz.dtcassandra.paxos.message.IPaxosMessage;
import hycz.dtcassandra.paxos.message.PromiseMessage;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.cassandra.utils.FBUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class PrepareResponseHandler extends AbstractPaxosResponseHandler {

	protected static final Logger logger = LoggerFactory
			.getLogger(PrepareResponseHandler.class);

	protected final AtomicInteger responses;
	private final int expectedResponses;
	
	protected boolean nackResponse;
	private AtomicInteger nackcount;

	// when this handler is used for prepare phase, promisedProposalNumber is just what it is as the name represents
	// when this handler is used for current read up-to-date validation, promisedProposalNumber represents the current instance num
	private long promisedProposalNumber;
	private IPaxosValue acceptedPaxosValue;
	
	// only used for current read up-to-date validation
	private List<InetAddress> uptodateEndpoints;

	protected PrepareResponseHandler(
			String tableName,
			Range range,
			long instanceNumber,
			Map<InetAddress, InetAddress> acceptors,
			ConsistencyLevel consistencyLevel) {
		super(tableName,range,instanceNumber, acceptors, consistencyLevel);
//		responses = new AtomicInteger(determineBlockFor(table));
		responses = new AtomicInteger(determineConsistency());
		expectedResponses = responses.get();
		nackResponse=false;
		nackcount = new AtomicInteger(0);
		promisedProposalNumber=-1;
		acceptedPaxosValue=null;
		uptodateEndpoints = new ArrayList<InetAddress>();
	}
	
	protected PrepareResponseHandler(
			String tableName,
			Range range,
			long instanceNumber,
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistencyLevel) {
		super(tableName,range,instanceNumber,acceptorEndpoints, witnessAcceptorEndpoints, consistencyLevel);
//		responses = new AtomicInteger(determineBlockFor(table));
		responses = new AtomicInteger(determineConsistency());
		expectedResponses = responses.get();
		nackResponse=false;
		nackcount = new AtomicInteger(0);
		promisedProposalNumber=-1;
		acceptedPaxosValue=null;
		uptodateEndpoints = new ArrayList<InetAddress>();
	}

	protected PrepareResponseHandler(String tableName, Range range, long instanceNumber, InetAddress endpoint) {
		super(	tableName,
				range,
				instanceNumber,
				Arrays.asList(endpoint), 
				ImmutableMultimap.<InetAddress, InetAddress> builder().put(endpoint, endpoint).build(), 
				ConsistencyLevel.ALL);
		responses = new AtomicInteger(1);
		expectedResponses = responses.get();
		nackResponse=false;
		nackcount = new AtomicInteger(0);
		promisedProposalNumber=-1;
		acceptedPaxosValue=null;
		uptodateEndpoints = new ArrayList<InetAddress>();
	}
	
	public static PrepareResponseHandler create(
			String tableName, 
			Range range,
			long instanceNumber,
			Map<InetAddress, InetAddress> acceptors,
			ConsistencyLevel consistencyLevel) {
		return new PrepareResponseHandler(tableName, range, instanceNumber, acceptors, consistencyLevel);
	}

	public static PrepareResponseHandler create(
			String tableName, 
			Range range,
			long instanceNumber,
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistencyLevel) {
		return new PrepareResponseHandler(tableName, range, instanceNumber, acceptorEndpoints,
				witnessAcceptorEndpoints, consistencyLevel);
	}

	public static PrepareResponseHandler create(String tableName, Range range, long instanceNumber, InetAddress endpoint) {
		return new PrepareResponseHandler(tableName, range, instanceNumber,endpoint);
	}
	
	@Override
	public void response(IPaxosMessage pmsg){
		if (pmsg instanceof PromiseMessage){
			if (pmsg.getProposalNumber()>this.promisedProposalNumber){
				this.promisedProposalNumber=pmsg.getProposalNumber();
				if (pmsg.getPaxosValue() != null)
					this.acceptedPaxosValue=pmsg.getPaxosValue();
			}
			if (((PromiseMessage)pmsg).getTimestamp() > getTimestamp()){
				setTimestamp(((PromiseMessage)pmsg).getTimestamp());
			}
			if (((PromiseMessage)pmsg).isNack()){
				if (nackcount.incrementAndGet() >= expectedResponses)
					condition.signal();
			}
			else {
				if (responses.decrementAndGet() == 0)
					condition.signal();
			}
		}
		
		
//		if (responses.decrementAndGet() == 0)
//			condition.signal();
	}
	
	@Override
	public void response(IPaxosMessage pmsg, Message msg){
		if (pmsg instanceof PromiseMessage){
			if (pmsg.getProposalNumber()>this.promisedProposalNumber){
				this.promisedProposalNumber=pmsg.getProposalNumber();
				this.uptodateEndpoints.clear();
				if (pmsg.getInstanceNumber() == pmsg.getProposalNumber()){
					this.uptodateEndpoints.add(msg.getFrom());
				}
				if (pmsg.getPaxosValue() != null)
					this.acceptedPaxosValue=pmsg.getPaxosValue();
			}
			// this branch is only for current read up-to-date validation
			else if (pmsg.getProposalNumber() == this.promisedProposalNumber){
				if (pmsg.getInstanceNumber() == pmsg.getProposalNumber()){
					this.uptodateEndpoints.add(msg.getFrom());
				}
			}
			if (((PromiseMessage)pmsg).getTimestamp() > getTimestamp()){
				setTimestamp(((PromiseMessage)pmsg).getTimestamp());
			}
			if (((PromiseMessage)pmsg).isNack()){
				if (nackcount.incrementAndGet() >= expectedResponses)
					condition.signal();
			}
			else {
				if (responses.decrementAndGet() == 0)
					condition.signal();
			}
		}
	}
	
	public long getPromisedProposalNumber(){
		return promisedProposalNumber;
	}
	
	public IPaxosValue getAcceptedPaxosValue(){
		return acceptedPaxosValue;
	}
	
	public List<InetAddress> getUptodateEndpoints(){
		return uptodateEndpoints;
	}

	public void response(Message m) {
		if (responses.decrementAndGet() == 0)
			condition.signal();
	}
	
	public PaxosResponseType get() {
		long timeout = DatabaseDescriptor.getRpcTimeout()
				- (System.currentTimeMillis() - startTime);
		boolean success;
		try {
			success = condition.await(timeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ex) {
			throw new AssertionError(ex);
		}

		if (!success) {
			return PaxosResponseType.Timeout;
		}
		if (nackcount.get() >= expectedResponses )
			return PaxosResponseType.Nack;

//		PaxosLeaderInstance instance = PaxosOverallManager.get(getTableName(),getRange()).getLeaderInstance(getInstanceNumber());
//		if (acceptedPaxosValue!=null)
//			instance.setPaxosValue(acceptedPaxosValue);
		return PaxosResponseType.Quorum;
//		}
	}

	protected int determineConsistency() {
		switch (consistencyLevel) {
		case ONE:
			return 1;
		case ANY:
			return 1;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case QUORUM:
			return (acceptorEndpoints.size() / 2) + 1;
		case ALL:
			return acceptorEndpoints.size();
		default:
			throw new UnsupportedOperationException(
					"invalid consistency level: " + consistencyLevel.toString());
		}
	}
	
	protected int determineBlockFor	(String table) {
		switch (consistencyLevel) {
		case ONE:
			return 1;
		case ANY:
			return 1;
		case TWO:
			return 2;
		case THREE:
			return 3;
		case QUORUM:
			return (acceptorEndpoints.size() / 2) + 1;
		case ALL:
			return acceptorEndpoints.size();
		default:
			throw new UnsupportedOperationException(
					"invalid consistency level: " + consistencyLevel.toString());
		}
	}

	public void assureSufficientLiveNodes() throws UnavailableException {
		if (consistencyLevel == ConsistencyLevel.ANY) {
			// ensure there are blockFor distinct living nodes (hints are ok).
			if (witnessAcceptorEndpoints.keySet().size() < responses.get())
				throw new UnavailableException();
			return;
		}

		// count destinations that are part of the desired target set
		int liveNodes = 0;
		for (InetAddress destination : witnessAcceptorEndpoints.keySet()) {
			if (acceptorEndpoints.contains(destination))
				liveNodes++;
		}
		if (liveNodes < responses.get()) {
			throw new UnavailableException();
		}
	}

	public boolean isLatencyForSnitch() {
		return false;
	}


}
