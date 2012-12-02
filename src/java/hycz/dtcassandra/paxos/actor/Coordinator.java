package hycz.dtcassandra.paxos.actor;

import hycz.dtcassandra.paxos.PaxosInstance;

import org.apache.cassandra.dht.Range;

public class Coordinator extends ActorDecorator{
	
	public Coordinator(Actor decoratedActor) {
		super(decoratedActor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRole(Role r) {
		if (Role.Coordinator==r) {
			return true;	
		}
		else {
			return super.isRole(r);	
		}
	}
	
	public void printRole(){
		System.out.println("this is a Coordinator");
	}

	public PaxosInstance getInstance(Long instanceNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Range getRange() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public xxxxx createSubTransactions(){	
//	}

}
