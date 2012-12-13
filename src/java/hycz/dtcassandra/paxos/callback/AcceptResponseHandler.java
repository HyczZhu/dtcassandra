package hycz.dtcassandra.paxos.callback;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.message.AcceptedMessage;
import hycz.dtcassandra.paxos.message.IPaxosMessage;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.UnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.nio.ch.SocketOpts.IP;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class AcceptResponseHandler extends AbstractPaxosResponseHandler{

	protected static final Logger logger = LoggerFactory
			.getLogger(AcceptResponseHandler.class);

	private final AtomicInteger totalResponses;
	protected final AtomicInteger responses;
	private final int expectedResponses;
	
	protected boolean nackResponse;
	private AtomicInteger nackcount;

	private long promisedProposalNumber;
	private Map<IPaxosValue, AtomicInteger> responseValues;
	private IPaxosValue expectedValue;
	private IPaxosValue acceptedValue;

	protected AcceptResponseHandler(
			String tableName,
			Range range, 
			long instanceNumber,
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistencyLevel,
			IPaxosValue expectedValue) {
		super(tableName,range,instanceNumber, acceptorEndpoints, witnessAcceptorEndpoints,
				consistencyLevel);
		// responses = new AtomicInteger(determineBlockFor(table));
		totalResponses = new AtomicInteger(acceptorEndpoints.size());
		responses = new AtomicInteger(determineConsistency());
		expectedResponses = responses.get();
		nackResponse = false;
		nackcount = new AtomicInteger(0);
		promisedProposalNumber = -1;
		responseValues = new HashMap<IPaxosValue, AtomicInteger>();
		this.expectedValue = expectedValue;
		acceptedValue = null;
	}

	protected AcceptResponseHandler(String tableName, Range range, long instanceNumber, InetAddress endpoint, IPaxosValue expectedValue) {
		super(tableName,range,instanceNumber, Arrays.asList(endpoint), ImmutableMultimap
				.<InetAddress, InetAddress> builder().put(endpoint, endpoint)
				.build(), ConsistencyLevel.ALL);
		totalResponses = new AtomicInteger(acceptorEndpoints.size());
		responses = new AtomicInteger(1);
		expectedResponses = responses.get();
		nackResponse = false;
		nackcount = new AtomicInteger(0);
		promisedProposalNumber = -1;
		responseValues = new HashMap<IPaxosValue, AtomicInteger>();
		this.expectedValue = expectedValue;
		acceptedValue = null;
	}

	public static AcceptResponseHandler create(
			String tableName,
			Range range,
			long instanceNumber,
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistencyLevel,
			IPaxosValue expectedValue) {
		return new AcceptResponseHandler(tableName,range,instanceNumber, acceptorEndpoints, witnessAcceptorEndpoints,
				consistencyLevel, expectedValue);
	}

	public static AcceptResponseHandler create(String tableName,
			Range range, long instanceNumber, InetAddress endpoint, IPaxosValue expectedValue) {
		return new AcceptResponseHandler(tableName,range,instanceNumber, endpoint, expectedValue);
	}
	
	@Override
	public void response(IPaxosMessage pmsg) {
		if (pmsg instanceof AcceptedMessage){
			if (((AcceptedMessage)pmsg).isNack()){
				if (nackcount.incrementAndGet() >= expectedResponses)
					condition.signal();
			}
			else{
				IPaxosValue value = pmsg.getPaxosValue();
				// normal paxos phase 2
				if (expectedValue != null && value != null) {
					if (expectedValue.equals(value)){
						if (responses.decrementAndGet() == 0)
							condition.signal();
					}
				}
				// no-op value phase 2, consistency level should be all
				// need to receive all responses, or any value got more than half of all responses
				else {
					if (responseValues.get(value) != null){
						if (responseValues.get(value).incrementAndGet() >= expectedResponses)
							condition.signal();
					}
					else {
						synchronized(this){
							if (responseValues.get(value) == null){
								responseValues.put(value, new AtomicInteger(1));
								if (1 >= expectedResponses)
									condition.signal();
							}
						}
					}
					if (totalResponses.decrementAndGet() == 0)
						condition.signal();
				}
				
			}
		}
	}
	
	@Override
	public void response(IPaxosMessage pmsg, Message message) {
	}

	public void response(Message m) {
		if (responses.decrementAndGet() == 0)
			condition.signal();
	}
	
//	public void reponseNack() {
//		nackResponse=true;
//		condition.signal();
//	}
	
	public PaxosResponseType get(){
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
		
		if (nackcount.get() >= expectedResponses)
			return PaxosResponseType.Nack;
		
		// normal paxos phase 2
		if (expectedValue != null){
//			System.out.println("AcceptResponseHandler : Quorum");
			return PaxosResponseType.Quorum;
		}
		// no-op phase 2
		else{
			for(Entry<IPaxosValue, AtomicInteger> entry : responseValues.entrySet()){
				if (entry.getValue().get() >= expectedResponses){
					this.acceptedValue = entry.getKey();
					return PaxosResponseType.Quorum;
				}
			}
			this.acceptedValue = null;
			return PaxosResponseType.NoConsensus;
		}
	}
	
	public IPaxosValue getAcceptedValue(){
		return this.acceptedValue;
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
