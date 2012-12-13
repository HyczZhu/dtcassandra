package hycz.dtcassandra.paxos.callback;

public enum PaxosResponseType {

	Quorum,
	Nack,
	Timeout,
	NoConsensus,
	Delivered,
	Error
}
