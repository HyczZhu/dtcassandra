package hycz.dtcassandra.transaction.replication;

import hycz.dtcassandra.paxos.actor.Acceptor;
import hycz.dtcassandra.paxos.actor.Actor;
import hycz.dtcassandra.paxos.actor.ActorRole;
import hycz.dtcassandra.paxos.actor.BasicActor;
import hycz.dtcassandra.paxos.actor.Role;

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.locator.TokenMetadata;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.hadoop.hdfs.server.common.Storage;

public class ReplicationManager {
	public final HashMap<String, HashMap<Range, StaticReplication>> staticReplication;
	public final HashMap<String, HashMap<Range, DynamicWitness>> dynamicWitness;
	public final HashMap<String, HashMap<Range, DynamicReadonly>> dynamicReadonly;
	
	public List<Range> allRanges;
	
	//singleton
	private static class AMHandle
    {
        public static final ReplicationManager instance = new ReplicationManager();
    }
    public static ReplicationManager instance()
    {
        return AMHandle.instance;
    }
    
    private ReplicationManager(){
    	dynamicWitness = new HashMap<String, HashMap<Range, DynamicWitness>>();
    	dynamicReadonly = new HashMap<String, HashMap<Range, DynamicReadonly>>();
    	staticReplication = new HashMap<String, HashMap<Range, StaticReplication>>();
    	//add all ranges local endpoint is responsible for
    	Set<String> tables = DatabaseDescriptor.getTables();
    	for(String tableName : tables){
    		HashMap<Range, StaticReplication> replica = new HashMap<Range, StaticReplication>();
    		for (Range range : StorageService.instance.getLocalRanges(tableName)){
    			replica.put(range, new StaticReplication(tableName, range));
    		}
    		staticReplication.put(tableName, replica);
    		dynamicWitness.put(tableName, new HashMap<Range, DynamicWitness>());
    		dynamicReadonly.put(tableName, new HashMap<Range, DynamicReadonly>());
    	}
    	
    	allRanges = StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens());
    }
    
    public Range getRange(Token token) throws RangeNotFoundException{
    	for (Range r : allRanges){
    		if (r.contains(token))
    			return r;
    	}
    	throw new RangeNotFoundException("no range found for token " + token);
    }
    
    // tell which ActorRole local endpoint is
    public ActorRole getActorRole(String tableName, Range range){
    	try {
    		return staticReplication.get(tableName).get(range).getActorRole();
    	}
    	catch (NullPointerException e){
    		return null;
    	}
    }

    // tell which endpoint is leader
    public InetAddress getReplicationLeader(String tableName, Range range){
    	try{
    		return staticReplication.get(tableName).get(range).getLeader();
    	}
    	catch (NullPointerException e){
    		return null;
    	}
    }
    
    public Map<InetAddress, InetAddress> getReplicationAcceptors(String tableName, Range range){
    	try{
    		return staticReplication.get(tableName).get(range).getAcceptors();
    	}
    	catch (NullPointerException e){
    		return null;
    	}
	}
	
	public List<InetAddress> getReplicationLearners(String tableName, Range range){
		try{
    		return staticReplication.get(tableName).get(range).getLearners();
    	}
    	catch (NullPointerException e){
    		return null;
    	}
	}
	
	public List<InetAddress> getReplicationReadonly(String tableName, Range range){
		try{
    		return staticReplication.get(tableName).get(range).getReadonly();
    	}
    	catch (NullPointerException e){
    		return null;
    	}
	}    
    
    public boolean isLeader(String tableName, Range range){
    	if (checkRange(tableName,range)){
    		return staticReplication.get(tableName).get(range).getActorRole().isLeader();
    	}
    	return false;
    }
    
    public boolean setLeader(String tableName, Range range){
    	if (checkRange(tableName,range)){
    		staticReplication.get(tableName).get(range).getActorRole().setLeader();
    		return true;
    	}
    	return false;
    }
    
    public boolean resetLeader(String tableName, Range range){
    	if (checkRange(tableName,range)){
    		staticReplication.get(tableName).get(range).getActorRole().resetLeader();
    		return true;
    	}
    	return false;
    }
    
    public boolean isProposer(String tableName, ByteBuffer key){
    	if (checkRange(tableName,key)){
    		Token token = getToken(key);
    		for (Range range : StorageService.instance.getLocalRanges(tableName)){
    			if (range.contains(token)){
    				return staticReplication.get(tableName).get(range).getActorRole().isProposer();
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    public boolean isAcceptor(String tableName, ByteBuffer key){
    	if (checkRange(tableName,key)){
    		Token token = getToken(key);
    		for (Range range : StorageService.instance.getLocalRanges(tableName)){
    			if (range.contains(token)){
    				return staticReplication.get(tableName).get(range).getActorRole().isAcceptor();
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    public boolean isAcceptor(String tableName, Range range){
//    	if (checkRange(tableName,range)){
//    		return staticReplication.get(tableName).get(range).getActorRole().isAcceptor();
//    	}
//    	return false;
    	try {
    		return staticReplication.get(tableName).get(range).getActorRole().isAcceptor();
    	}catch(NullPointerException e){
    		return false;
    	}
    }
    public boolean isWitness(String tableName, Range range){
    	try {
    		return (dynamicWitness.get(tableName).get(range) != null);
    	}catch(NullPointerException e){
    		return false;
    	}
    }
    
    public boolean isAcceptorOrWitness(String tableName, Range range){
    	return isAcceptor(tableName, range) || isWitness(tableName, range);
    }
    
    public boolean isLearner(String tableName, Range range){
    	try {
    		return staticReplication.get(tableName).get(range).getActorRole().isLearner();
    	}catch(NullPointerException e1){
    		try {
    			return (dynamicReadonly.get(tableName).get(range) != null);
    		}catch(NullPointerException e2){
    			return false;
    		}
    	}
    }
    
    @Deprecated
    public boolean setAcceptor(String tableName, ByteBuffer key){
    	if (checkRange(tableName,key)){
    		Token token = getToken(key);
    		for (Range range : StorageService.instance.getLocalRanges(tableName)){
    			if (range.contains(token)){
    				staticReplication.get(tableName).get(range).getActorRole().setAcceptor();
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    @Deprecated
    public boolean setAcceptor(String tableName, Range range){
    	if (checkRange(tableName,range)){
    		staticReplication.get(tableName).get(range).getActorRole().setAcceptor();
			return true;
    	}
    	return false;
    }
    
    @Deprecated
    public boolean resetAcceptor(String tableName, ByteBuffer key){
    	if (checkRange(tableName,key)){
    		Token token = getToken(key);
    		for (Range range : StorageService.instance.getLocalRanges(tableName)){
    			if (range.contains(token)){
    				staticReplication.get(tableName).get(range).getActorRole().resetAcceptor();
    				return true;
    			}
    		}
    		return false;
    	}
    	return false;
    }
    
    public boolean checkRange(String tableName, ByteBuffer key){
    	//Token keyToken = TokenMetadata.firstToken(getTokenMetadata().sortedTokens(), getPartitioner().getToken(key));
    	List<InetAddress> hosts = StorageService.instance.getNaturalEndpoints(tableName, key);
    	if (hosts.contains(FBUtilities.getLocalAddress()))
    		return true;
    	else
    		return false;
    }
    
    public boolean checkRange(String tableName, Range range){
    	//Token keyToken = TokenMetadata.firstToken(getTokenMetadata().sortedTokens(), getPartitioner().getToken(key));
    	Collection<Range> ranges = StorageService.instance.getLocalRanges(tableName);
    	if (ranges.contains(range))
    		return true;
    	else
    		return false;
    }
    
    public static Token getToken(ByteBuffer key) {
    	return getPartitioner().getToken(key);
    }
    
    public static IPartitioner getPartitioner() {
        return StorageService.getPartitioner();
    }
    
    public TokenMetadata getTokenMetadata()
    {
        return StorageService.instance.getTokenMetadata();
    }
    
    //map<tablename,map<range,actor>>
	@Deprecated
	public static final HashMap<String, HashMap<Range, Actor>> oldactors=new HashMap<String, HashMap<Range,Actor>>();
	//map<tablename,actor>
	@Deprecated
	public static final HashMap<String, Actor> actors = new HashMap<String, Actor>();
	
    @Deprecated
	public static Actor getActor(String tablename){		
		//after we get all Range to Actor maps for this table,
		//we get the specific actor and return.
		Actor actor;
		if ((actor=actors.get(tablename))==null){
			synchronized (ReplicationManager.class){
				if ((actor=actors.get(tablename))==null){
					actor = new BasicActor(tablename);
					actors.put(tablename, actor);
					return actor;
				}
				else 
					return actor;
			}
		} else {
			return actor;
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @return if the actor doesn't fit the role, make it and update actors, then return
	 */
    @Deprecated
	public static Actor makeAcceptor(String tablename){
		Actor actor;
		actor = getActor(tablename);
		if (actor.isRole(Role.Acceptor))
			return actor.getRole(Role.Acceptor);
		else{
			synchronized (ReplicationManager.class) {
				actor = getActor(tablename);
				if (!actor.isRole(Role.Acceptor)) {
					actor = new Acceptor(actor);
					updateAcceptor(tablename, actor);
					return actor;
				} else
					return actor.getRole(Role.Acceptor);
			}
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @return if the actor doesn't fit the role, return null 
	 */
    @Deprecated
	public static Actor getAcceptor(String tablename){
		Actor actor;
		actor = getActor(tablename);
		if (actor.isRole(Role.Acceptor))
			return actor.getRole(Role.Acceptor);
		else{
			return null;
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @return if the actor doesn't fit the role, return null 
	 */
    @Deprecated
	public static Actor getProposer(String tablename){
		Actor actor;
		actor = getActor(tablename);
		if (actor.isRole(Role.Proposer))
			return actor.getRole(Role.Proposer);
		else{
			return null;
		}
	}
	
    @Deprecated
	public static void updateAcceptor(String tablename, Actor actor){
		updateActorForRole(tablename, actor, Role.Acceptor);
	}

    @Deprecated
	private static void updateActorForRole(String tablename, Actor actor, Role role){
		if (actor == null || !actor.isRole(role))
			return;
		else{
			if (actors.get(tablename) != null)
				actors.put(tablename, actor);
		}
	}
	
	@Deprecated
	public static Actor getActor(String tablename, Range range){
		HashMap<Range, Actor> tableActors=oldactors.get(tablename);
		//if we cannot get actors, we create new Range to Actor maps, 
		//and put these maps into actors.
		if (tableActors==null){
			synchronized (ReplicationManager.class){
				tableActors=oldactors.get(tablename);
				if (tableActors==null){
						tableActors=new HashMap<Range,Actor>();
						oldactors.put(tablename, tableActors);
				}
			}
		}
		
		//after we get all Range to Actor maps for this table,
		//we get the specific actor and return.
		Actor actor;
		if ((actor=tableActors.get(range))==null){
			synchronized (ReplicationManager.class){
				if ((actor=tableActors.get(range))==null){
					actor = new BasicActor(tablename, range);
					tableActors.put(range, actor);
					return actor;
				}
				else 
					return actor;
			}
		} else {
			return actor;
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @param range
	 * @return if the actor doesn't fit the role, make it and update actors, then return
	 */
	@Deprecated
	public static Actor makeAcceptor(String tablename, Range range){
		Actor actor;
		actor = getActor(tablename,range);
		if (actor.isRole(Role.Acceptor))
			return actor.getRole(Role.Acceptor);
		else{
			synchronized (ReplicationManager.class) {
				if (!actor.isRole(Role.Acceptor)) {
					actor = new Acceptor(actor);
					updateAcceptor(tablename, range, actor);
					return actor;
				} else
					return actor.getRole(Role.Acceptor);
			}
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @param range
	 * @return if the actor doesn't fit the role, return null 
	 */
	@Deprecated
	public static Actor getAcceptor(String tablename, Range range){
		Actor actor;
		actor = getActor(tablename,range);
		if (actor.isRole(Role.Acceptor))
			return actor.getRole(Role.Acceptor);
		else{
			return null;
		}
	}
	
	/***
	 * 
	 * @param tablename
	 * @param range
	 * @return if the actor doesn't fit the role, return null 
	 */
	@Deprecated
	public static Actor getProposer(String tablename, Range range){
		Actor actor;
		actor = getActor(tablename,range);
		if (actor.isRole(Role.Proposer))
			return actor.getRole(Role.Proposer);
		else{
			return null;
		}
	}
	
	@Deprecated
	public static void updateAcceptor(String tablename, Range range, Actor actor){
		updateActorForRole(tablename, range, actor, Role.Acceptor);
	}

	@Deprecated
	private static void updateActorForRole(String tablename, Range range, Actor actor, Role role){
		if (!actor.isRole(role))
			return;
		else{
			HashMap<Range, Actor> tableActors=oldactors.get(tablename);
			if (tableActors != null)
				tableActors.put(range, actor);
		}
	}
}
