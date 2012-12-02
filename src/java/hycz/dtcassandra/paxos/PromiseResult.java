package hycz.dtcassandra.paxos;

public class PromiseResult {
	private boolean success;
	private long previousProposalNumber;
	private IPaxosValue acceptedValue;
	
	public PromiseResult(boolean success, long previousProposalNumber, IPaxosValue acceptedValue){
		this.success = success;
		this.previousProposalNumber = previousProposalNumber;
		this.acceptedValue = acceptedValue;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public long getPreviousProposalNumber(){
		return previousProposalNumber;
	}
	
	public IPaxosValue getAcceptedValue() {
		return acceptedValue;
	}
}
