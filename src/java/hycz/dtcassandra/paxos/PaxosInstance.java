package hycz.dtcassandra.paxos;

import sun.nio.ch.SocketOpts.IP;

public class PaxosInstance {
	private final long instanceNumber;
	private long proposalNumber;
	private IPaxosValue paxosValue;
	
	private String state;
	private IPaxosValue chosenValue;
	
	PaxosInstance(long instanceNumber, long proposalNumber) {
		this(instanceNumber, proposalNumber, null);
	}
	
	/***
	 * 
	 * @param instanceNumber need to guarantee unique when initialize
	 * @param proposalNumber
	 * @param paxosValue
	 */
	public PaxosInstance(long instanceNumber, long proposalNumber, IPaxosValue paxosValue) {
		this(instanceNumber, proposalNumber, paxosValue, PaxosState.Pending);
	}
	
	public PaxosInstance(long instanceNumber, long proposalNumber, IPaxosValue paxosValue, String state) {
		this.instanceNumber = instanceNumber;
		this.proposalNumber = proposalNumber;
		this.paxosValue = paxosValue;
		this.state = state;
		this.chosenValue = null;
	}
	
	public PaxosInstance(long instanceNumber, long proposalNumber, IPaxosValue paxosValue, String state, IPaxosValue chosenValue) {
		this.instanceNumber = instanceNumber;
		this.proposalNumber = proposalNumber;
		this.paxosValue = paxosValue;
		this.state = state;
		this.chosenValue = chosenValue;
	}
	
	public long getInstanceNumber() {
		return instanceNumber;
	}
	
	public long getProposalNumber() {
		return proposalNumber;
	}
	
	public IPaxosValue getPaxosValue() {
		return paxosValue;
	}
	
	public String getState(){
		return state;
	}
	
	public IPaxosValue getChosenValue() {
		return chosenValue;
	}
	
	public void setProposalNumber(long proposalNum){
		this.proposalNumber = proposalNum;
	}
	
	public void setPaxosValue(IPaxosValue paxosValue){
		this.paxosValue = paxosValue;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public void setChosenValue(IPaxosValue chosenValue){
		this.chosenValue = chosenValue;
	}
	
	public String toString(){
		String s = "instanceNumber=" + instanceNumber
			+ ", proposalNumber=" + proposalNumber
			+ ", value=";
		return  paxosValue==null? s+"null" : s + paxosValue.getValue();
			
	}
}
