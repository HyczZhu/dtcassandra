package hycz.dtcassandra.transaction.replication;

import hycz.dtcassandra.paxos.actor.ActorRole;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.gms.FailureDetector;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;

/***
 * this class is for the replication informations of 
 * all the ranges that local endpoint is responsible for.
 * this class also means that this is a full replica for a range.
 * @author hycz
 *
 */
public class StaticReplication {
	private final String tableName;
	private final Range range;
	// tell which ActorRole local endpoint is
	private ActorRole actorRole;
	// tell which endpoint is leader
	private InetAddress leader;
	// if an acceptor is down, the value represents the witness for the down acceptor
	private Map<InetAddress, InetAddress> acceptors;
	// static learners
	private List<InetAddress> learners;
	// dynamic learners
	private List<InetAddress> readonly;
	
	public StaticReplication(String tableName, Range range){
		this.tableName = tableName;
		this.range = range;
		actorRole = new ActorRole(tableName, range);
		leader = StorageService.instance.getTokenMetadata().getEndpoint(range.right);
		if (leader.equals(FBUtilities.getLocalAddress())){
			actorRole.setLeader();
		}
		actorRole.setAcceptor();
		actorRole.setLearner();
		acceptors = new HashMap<InetAddress, InetAddress>();
		learners = StorageService.instance.getNaturalEndpoints(tableName, range.right);
//		.getRangeToAddressMap(tableName).get(range);
		for (InetAddress endpoint : learners){
			acceptors.put(endpoint, endpoint);
		}
		readonly = new ArrayList<InetAddress>();
	}
	
	public ActorRole getActorRole(){
		return actorRole;
	}
	
	public InetAddress getLeader(){
		return leader;
	}
	
	public Map<InetAddress, InetAddress> getAcceptors(){
		return acceptors;
	}
	
	public List<InetAddress> getLearners(){
		return learners;
	}
	
	public List<InetAddress> getReadonly(){
		return readonly;
	}
	
	//用(live destination, ultimate targets)来表示是否hint，一样则不是hint，不一样则后者是最终目的地
    public Multimap<InetAddress, InetAddress> getWitnessEndpoints(Collection<InetAddress> acceptors) {
        Multimap<InetAddress, InetAddress> map = HashMultimap.create(acceptors.size(), 1);

        // first, add the live endpoints
        for (InetAddress ep : acceptors)
        {
            if (FailureDetector.instance.isAlive(ep))
                map.put(ep, ep);
        }

        // if everything was alive or we're not doing HH on this keyspace, stop with just the live nodes
        if (map.size() == acceptors.size() || !StorageProxy.isHintedHandoffEnabled())
            return map;

        // assign dead endpoints to be hinted to the closest live one, or to the local node
        // (since it is trivially the closest) if none are alive.  This way, the cost of doing
        // a hint is only adding the hint header, rather than doing a full extra write, if any
        // destination nodes are alive.
        //
        // we do a 2nd pass on targets instead of using temporary storage,
        // to optimize for the common case (everything was alive).
        InetAddress localAddress = FBUtilities.getLocalAddress();
        for (InetAddress ep : acceptors)
        {
            if (map.containsKey(ep))
                continue;
            if (!StorageProxy.shouldHint(ep))
            {
//                if (logger.isDebugEnabled())
//                    logger.debug("not hinting " + ep + " which has been down " + Gossiper.instance.getEndpointDowntime(ep) + "ms");
                continue;
            }

            //开始加入hint destination
            //这里是witness destination
            //这里使用不同的策略决定witness
            InetAddress destination = map.isEmpty()
                                    ? localAddress
                                    : org.apache.cassandra.db.Table.open(tableName).getReplicationStrategy()
                                    	.snitch.getSortedListByProximity(localAddress, map.keySet()).get(0);
            map.put(destination, ep);
        }

        return map;
    }
}
