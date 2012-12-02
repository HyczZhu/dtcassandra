package hycz.dtcassandra.paxos.actor;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;

//only for role check
public class ActorRole {
	String tableName;
	Range range;
	private boolean isProposer;
	private boolean isAcceptor;
	private boolean isLearner;
	private boolean isLeader;
	
	public ActorRole(String tableName, Range range){
		this.tableName = tableName;
		this.range = range;
		isProposer = false;
		isAcceptor = false;
		isLearner = false;
		isLeader = false;
	}
	
	public void print(){
		System.out.println("Table = " + tableName + ", Range = " + range);
	}
	
	public boolean isProposer(){
		return isProposer;
	}
	public boolean isAcceptor(){
		return isAcceptor;
	}
	public boolean isLearner(){
		return isLearner;
	}
	public boolean isLeader(){
		return isLeader;
	}
	
	public void setProposer(){
		isProposer = true;
	}
	public void setAcceptor(){
		isAcceptor = true;
	}
	public void setLearner(){
		isLearner = true;
	}
	public void setLeader(){
		isLeader = true;
	}
	
	public void resetProposer(){
		isProposer = false;
	}
	public void resetAcceptor(){
		isAcceptor = false;
	}
	public void resetLearner(){
		isLearner = false;
	}
	public void resetLeader(){
		isLeader = false;
	}
}
