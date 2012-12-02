package hycz.dtcassandra.paxos.actor;

public abstract class ActorDecorator implements Actor{
	protected final Actor decoratedActor;
	
	public ActorDecorator(Actor decoratedActor){
		this.decoratedActor=decoratedActor;
	}
	
	public boolean isRole(Role r){
		return decoratedActor.isRole(r);
	}
	
	public Actor getRole(Role r){
		return decoratedActor.getRole(r);
	}

}
