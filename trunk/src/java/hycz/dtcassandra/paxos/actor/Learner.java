package hycz.dtcassandra.paxos.actor;

import hycz.dtcassandra.paxos.PaxosInstance;

import org.apache.cassandra.dht.Range;

public class Learner extends ActorDecorator{

	public Learner(Actor decoratedActor) {
		super(decoratedActor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRole(Role r) {
		if (Role.Learner==r) {
			return true;	
		}
		else {
			return super.isRole(r);	
		}

	}
	
	public Actor getRole(Role r){
		if (Role.Learner==r)
			return this;
		else 
			return super.getRole(r);
	}
	
	public void printRole(){
		System.out.println("this is a Learner");
	}
	
	public void learn(){
		
	}

	public PaxosInstance getInstance(Long instanceNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Range getRange() {
		// TODO Auto-generated method stub
		return null;
	}
}
