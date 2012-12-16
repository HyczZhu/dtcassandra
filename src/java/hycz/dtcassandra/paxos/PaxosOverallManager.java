package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.callback.IPaxosResponseHandler;
import hycz.dtcassandra.paxos.callback.PaxosResponseType;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.utils.FBUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class PaxosOverallManager {
	private static Logger logger = LoggerFactory.getLogger(PaxosLeaderInstanceManager.class);
	
	private static final Map<String, Map<Range, PaxosLeaderInstanceManager>> leaderInstances;
	
	static {
		leaderInstances = new HashMap<String, Map<Range, PaxosLeaderInstanceManager>>();
        Set<String> tables = DatabaseDescriptor.getTables();
    	for(String tableName : tables){
    		if (tableName.equals("system") || tableName.equals("instanceSlot"))
    			continue;
    		leaderInstances.put(tableName, new HashMap<Range, PaxosLeaderInstanceManager>());
    		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
    			leaderInstances.get(tableName).put(range, new PaxosLeaderInstanceManager(tableName, range));
    		}
    	}
    	System.out.println("PaxosOverallManager initialized successfully");
    	//for test
//    	for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens()))
//    		leaderInstances.put("TestTable", new PaxosLeaderInstanceManager("TestTable", range));
	}
	
	public static void setup(){
	}
	
	public static PaxosLeaderInstanceManager get(String tableName, Range range){
		return leaderInstances.get(tableName).get(range);
	}
	
	
}
