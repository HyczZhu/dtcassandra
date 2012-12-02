package hycz.dtcassandra.paxos.message;

import org.apache.cassandra.dht.Range;

import hycz.dtcassandra.paxos.IPaxosValue;

public interface IPaxosMessage {

	public String getTableName();
	public Range getRange();
	public long getInstanceNumber();
	public long getProposalNumber();
	public IPaxosValue getPaxosValue();
}
