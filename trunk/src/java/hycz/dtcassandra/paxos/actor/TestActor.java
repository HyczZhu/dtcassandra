package hycz.dtcassandra.paxos.actor;

import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.nio.ByteBuffer;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class TestActor {
	public static void main(String[] args){
		ByteBuffer key=ByteBuffer.allocate(100);
		key.put(new String("key").getBytes());
//		Actor actor=new BasicActor("testtable", BasicActor.keyToToken(key));
		Token token = BasicActor.keyToToken(key);
		Actor actor=ReplicationManager.getActor("testtable", new Range(token,token));
		
		Proposer p = new Proposer(actor);
		p.printRole();
		Acceptor a = new Acceptor(actor);
		a.printRole();
		
		actor = new Proposer(new Acceptor(new Learner(actor)));
//		
		((Acceptor)actor.getRole(Role.Acceptor)).printRole();
		((Learner)actor.getRole(Role.Learner)).printRole();
//		((Acceptor)actor).printRole();
		
		System.out.println(actor.isRole(Role.Proposer));
		System.out.println(actor.isRole(Role.Acceptor));
		System.out.println(actor.isRole(Role.Learner));
		System.out.println(actor.isRole(Role.Leader));
		System.out.println(actor.isRole(Role.Coordinator));
		
		actor=ReplicationManager.getActor("testtable", new Range(token,token));
		System.out.println(actor.isRole(Role.Proposer));
		System.out.println(actor.isRole(Role.Acceptor));
		System.out.println(actor.isRole(Role.Learner));
		System.out.println(actor.isRole(Role.Leader));
		System.out.println(actor.isRole(Role.Coordinator));
		
	}
}
