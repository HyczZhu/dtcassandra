package hycz.dtcassandra.paxos.callback;

import hycz.dtcassandra.paxos.message.IPaxosMessage;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.cassandra.utils.SimpleCondition;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public abstract class AbstractPaxosResponseHandler implements
		IPaxosResponseHandler {
	protected final SimpleCondition condition = new SimpleCondition();
	protected final long startTime;
	protected final Collection<InetAddress> acceptorEndpoints;
	//用(live destination, ultimate targets)来表示是否hint，一样则不是hint，不一样则后者是最终目的地
	protected final Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints;
	protected final ConsistencyLevel consistencyLevel;
	
	private String tableName;
	private Range range;
	private final long instanceNumber;
	private long timestamp;

	protected AbstractPaxosResponseHandler(
			String tableName,
			Range range,
			long instanceNumber,
			Map<InetAddress, InetAddress> acceptors,//与acceptorEndpoints相反
			ConsistencyLevel consistencyLevel) {
		this.tableName = tableName;
		this.range = range;
		this.instanceNumber=instanceNumber;
		startTime = System.currentTimeMillis();
		this.consistencyLevel = consistencyLevel;
		this.acceptorEndpoints = acceptors.keySet();
		this.witnessAcceptorEndpoints = HashMultimap.create(this.acceptorEndpoints.size(), 1);
		for (Entry<InetAddress, InetAddress> entry : acceptors.entrySet()){
			this.witnessAcceptorEndpoints.put(entry.getValue(), entry.getKey());
		}
		this.timestamp = -1L;
	}
	
	protected AbstractPaxosResponseHandler(
			String tableName,
			Range range,
			long instanceNumber,
			Collection<InetAddress> acceptorEndpoints,
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints,
			ConsistencyLevel consistencyLevel) {
		this.tableName = tableName;
		this.range = range;
		this.instanceNumber=instanceNumber;
		startTime = System.currentTimeMillis();
		this.consistencyLevel = consistencyLevel;
		this.witnessAcceptorEndpoints = witnessAcceptorEndpoints;
		this.acceptorEndpoints = acceptorEndpoints;
		this.timestamp = -1L;
	}

	// TODO may need overwrite to return PaxosResponseType.Nack
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
	
	public long getTimestamp(){
		return timestamp;
	}
	
	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}

	/** null message means "response from local write" */
	public abstract void response(Message msg);
	
	public abstract void response(IPaxosMessage pmsg);
	
	public abstract void response(IPaxosMessage pmsg, Message message);

	public abstract void assureSufficientLiveNodes()
			throws UnavailableException;
}
