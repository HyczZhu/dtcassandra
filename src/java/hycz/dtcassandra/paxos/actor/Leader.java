package hycz.dtcassandra.paxos.actor;

//a noble proposer
public class Leader extends Proposer{

	public Leader(Actor decoratedActor) {
		super(decoratedActor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isRole(Role r) {
		if (Role.Leader==r) {
			return true;	
		}
		else {
			return super.isRole(r);	
		}
	}
	
	public void printRole(){
		System.out.println("this is a Leader");
	}
	
}
