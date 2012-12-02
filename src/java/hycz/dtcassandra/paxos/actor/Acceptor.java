package hycz.dtcassandra.paxos.actor;

import hycz.dtcassandra.paxos.PaxosInstance;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;

import org.apache.cassandra.dht.Range;

public class Acceptor extends ActorDecorator{
	
	public Acceptor(Actor decoratedActor) {
		super(decoratedActor);
	}

	@Override
	public boolean isRole(Role r) {
		if (Role.Acceptor==r) {
			return true;	
		}
		else {
			return super.isRole(r);	
		}

	}
	
	public Actor getRole(Role r){
		if (Role.Acceptor==r)
			return this;
		else 
			return super.getRole(r);
	}
	
	public void printRole(){
		System.out.println("this is an Accepter");
	}
	
	public void tryPromise(PrepareMessage prepareMessage){
		
	}
	
	public void tryAccept(AcceptMessage acceptMessage){
		//1, check from storage if this instance enter phase 2
		
		//2, check from storage if this instance could accept this value
		
		//3, if so, use stage to stabilize the accept result
	}
	
	public void doPrepare(){
		
	}
	
	public void promise(){
		System.out.println("acceptor.promise");
	}
	
	public void doAccept(){
		
	}
	
	public void doLearn(){
		
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
