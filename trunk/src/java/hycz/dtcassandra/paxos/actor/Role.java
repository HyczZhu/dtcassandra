package hycz.dtcassandra.paxos.actor;

/***
 * when you do a Paxos operation, you must be one of these roles
 * 
 * @author Hycz
 *
 */
public enum Role {
	//candidate is a special role, is only use for an actor that has not specify its Paxos role
	Candidate,
	Learner,
	Acceptor, 
	Proposer, 	 
	Leader, 
	Coordinator
}
