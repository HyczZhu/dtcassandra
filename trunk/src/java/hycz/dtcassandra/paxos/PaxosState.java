package hycz.dtcassandra.paxos;

public class PaxosState {
	public static final String Pending = "Pending";
	public static final String Closed = "Closed";// accept a value, but don't know the consensus value
	public static final String Delivered = "Delivered";// a value is chosen for this instance
	public static final String Hole = "Hole";// no value is chosen for this instance
	
	public static final String Empty = "Empty";
	public static final String P1Pending = "P1Pending";
	public static final String P1ReadyWithValue = "P1ReadyWithValue";
	public static final String P1ReadyWithoutValue = "P1ReadyWithoutValue";
	public static final String P2Pending = "P2Pending";
}
