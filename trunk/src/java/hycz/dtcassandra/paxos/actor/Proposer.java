package hycz.dtcassandra.paxos.actor;

import java.util.HashMap;
import java.util.Map;

import org.apache.cassandra.dht.Range;

import hycz.dtcassandra.paxos.PaxosInstance;

/***
 * most time we use Leader instead of Proposer
 * @author Hycz
 *
 */
public class Proposer extends ActorDecorator{
	
	//map<instance number, proposal number>
//	private Map<Long,Long> currentProposalNumber=new HashMap<Long,Long>();

	public Proposer(Actor decoratedActor) {
		super(decoratedActor);
	}

	@Override
	public boolean isRole(Role r) {
		if (Role.Proposer==r) {
			return true;	
		}
		else {
			return super.isRole(r);	
		}

	}
	
	public Actor getRole(Role r){
		if (Role.Proposer==r)
			return this;
		else 
			return super.getRole(r);
	}
	
	public void printRole(){
		System.out.println("this is a Proposer");
	}
	
	//Phase 1a: Prepare
	//A Proposer (the leader) creates a proposal identified with a number N. 
	//This number must be greater than any previous proposal number used by this Proposer. 
	//Then, it sends a Prepare message containing this proposal to a Quorum of Acceptors.
	public void prepare(PaxosInstance instance){
		//ask other actors to prepare	
		//send messages to other actor using the Verb PAXOSPREPARE defined in StorageService.java
		System.out.println("proposer.prepare");
	}
	
	//Phase 2a: Accept Request
	//If a Proposer receives enough promises from a Quorum of Acceptors, it needs to set a value to its proposal. 
	//If any Acceptors had previously accepted any proposals, then they'll have sent their values to the Proposer, 
	//who now must set the value of its proposal to the value associated with the highest proposal number reported by the Acceptors. 
	//If none of the Acceptors had accepted a proposal up to this point, then the Proposer may choose any value for its proposal.
	//The Proposer sends an Accept Request message to a Quorum of Acceptors with the chosen value for its proposal.
	public void accept(){
		//ask other actors to accept
		System.out.println("proposer.accept");
	}

	public PaxosInstance getInstance(Long instanceNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Range getRange() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//save some actor information in this class, 

}
