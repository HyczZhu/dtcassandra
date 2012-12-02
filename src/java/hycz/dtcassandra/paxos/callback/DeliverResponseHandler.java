package hycz.dtcassandra.paxos.callback;

import hycz.dtcassandra.paxos.message.IPaxosMessage;

import java.net.InetAddress;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.utils.SimpleCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * deliver = apply, so this is an apply response handler,
 * the consistency level should be considered W in NWR
 * @author Hycz
 *
 */
public class DeliverResponseHandler implements IPaxosResponseHandler{
	protected static final Logger logger = LoggerFactory.getLogger(DeliverResponseHandler.class);

	private String tableName;
	private Range range;
	private final long instanceNumber;
	private Collection<InetAddress> learnerEndpoints;
	protected final ConsistencyLevel consistencyLevel;
	protected final long startTime;
	protected final SimpleCondition condition = new SimpleCondition();
	
	protected final AtomicInteger responses;
	
	protected DeliverResponseHandler(String tableName, Range range,
			long instanceNumber, Collection<InetAddress> learnerEndpoints,
			ConsistencyLevel consistencyLevel) {
		this.tableName = tableName;
		this.range = range;
		this.instanceNumber=instanceNumber;
		startTime = System.currentTimeMillis();
		this.consistencyLevel = consistencyLevel;
		this.learnerEndpoints = learnerEndpoints;
		responses = new AtomicInteger(determineConsistency());
	}

	public static DeliverResponseHandler create(String tableName, Range range,
			long instanceNumber, Collection<InetAddress> learnerEndpoints,
			ConsistencyLevel consistencyLevel) {
		return new DeliverResponseHandler(tableName, range, instanceNumber,
				learnerEndpoints, consistencyLevel);
	}

	public void response(IPaxosMessage msg) {
//		if (msg instanceof DeliverResponseMessage){
		if (responses.decrementAndGet() == 0)
			condition.signal();
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
		return PaxosResponseType.Quorum;
	}
	
	public String getTableName(){
		return tableName;
	}
	
	public Range getRange() {
		return range;
	}
	
	public long getInstanceNumber(){
		return instanceNumber;
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
			return (learnerEndpoints.size() / 2) + 1;
		case ALL:
			return learnerEndpoints.size();
		default:
			throw new UnsupportedOperationException(
					"invalid consistency level: " + consistencyLevel.toString());
		}
	}

	protected int determineBlockFor(String table) {
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
			return (learnerEndpoints.size() / 2) + 1;
		case ALL:
			return learnerEndpoints.size();
		default:
			throw new UnsupportedOperationException(
					"invalid consistency level: " + consistencyLevel.toString());
		}
	}

//	public void assureSufficientLiveNodes() throws UnavailableException {
//		if (consistencyLevel == ConsistencyLevel.ANY) {
//			// ensure there are blockFor distinct living nodes (hints are ok).
//			if (learnerEndpoints.size() < responses.get())
//				throw new UnavailableException();
//			return;
//		}
//
//		// count destinations that are part of the desired target set
//		int liveNodes = 0;
//		for (InetAddress destination : learnerEndpoints) {
//			if (acceptorEndpoints.contains(destination))
//				liveNodes++;
//		}
//		if (liveNodes < responses.get()) {
//			throw new UnavailableException();
//		}
//	}

	public boolean isLatencyForSnitch() {
		return false;
	}
	
}
