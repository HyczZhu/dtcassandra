package hycz.dtcassandra.paxos;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class PaxosInstance2 {
	private Long instanceNumber;
	private PaxosState state;
	private AtomicLong proposalNumber;
	private IPaxosValue paxosValueAfterPhase1;
	private Long proposalNumberAfterPhase1;
	private Set<InetAddress> promiseRecieved;
	private IPaxosValue paxosValueForPhase2;
	private boolean cv;
	
	
}
