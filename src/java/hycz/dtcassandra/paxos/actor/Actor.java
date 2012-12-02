package hycz.dtcassandra.paxos.actor;

import org.apache.cassandra.dht.Range;

import hycz.dtcassandra.paxos.PaxosInstance;

public interface Actor{
//	public Role getRole();
	
	//to check roles
	boolean isRole(Role r);
	
	Actor getRole(Role r);
	
	//1 Actor : n instances
	//PaxosInstance getInstance(Long instanceNumber);
	
	//1 Actor : 1 Range
	//Range getRange();
}
//public abstract class Actor {
//	public enum Roles{
//		Proposer,
//		Accepter,
//		Learner,
//		Leader,
//	}
//	
//	public void prepare(){
//	}
//	
//	public void promise(){
//	}
//	
//	public void accept(){
//	}
//	
//	public void accepted(){
//	}
//
//}
