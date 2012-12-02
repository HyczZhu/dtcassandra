package hycz.dtcassandra.paxos.actor;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

import com.google.common.collect.Multimap;

//TODO use this class to manage all the <table, Range> map related stuff 
public class GlobalActorRoleManager {
	//public static Map<String, Multimap<InetAddress, Range>> allTableRanges = new HashMap<String, Multimap<InetAddress, Range>>();

//	public Map<String, Map<Range, Set<InetAddress>>> acceptors
	
//	public InetAddress getLeaderForRange(String tableName, Range range){
//		if (LocalActorRoleManager.instance().isLeader(tableName, range)){
//			return FBUtilities.getLocalAddress();
//		}
//		
//	}
	
	public static List<InetAddress> getEndpointsForRange(String tableName, Range range){
		return StorageService.instance.getRangeToAddressMap(tableName).get(range);
	}
	
	private static class RangeRole{
		String tableName;
		Range range;
		InetAddress leader;
		List<InetAddress> acceptors;
		Map<InetAddress, InetAddress> witnesses;
		Map<InetAddress, InetAddress> learners;
//		Map<Range, Set<InetAddress>> acceptors;
//		Map<Range, Set<InetAddress>> learners;
	}
}
