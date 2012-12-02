package hycz.dtcassandra.paxos.actor;

import hycz.dtcassandra.paxos.PaxosInstance;
import hycz.dtcassandra.paxos.PaxosLeaderInstanceManager;

import java.awt.Stroke;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.db.Table;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.locator.TokenMetadata;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.hadoop.hdfs.server.common.Storage;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/***
 * very fine-grained paxos actor for replication of a token range of a table
 * 
 * table : endpoint : range : actor : paxos instance
 *     1 : n 
 *                1 : n 
 *                        1 : 1 
 *                                1 : n
 * we have many tables, 
 * a table is stored in many endpoints, 
 * and for every table, an endpoint is corresponded to multiple ranges, 
 * an actor is for such a range.
 * 
 * a simple actor represents an original actor that has not been decorated, so
 * it does not contain methods that handle concrete Paxos operations.
 * 
 * @author Hycz
 * 
 */
public class BasicActor implements Actor {
	//table~token~
	Table table;
	InetAddress endpoint;

	public BasicActor(String tableName){
		table = Table.open(tableName);
		endpoint = FBUtilities.getLocalAddress();
	}
	
	public static Token keyToToken(ByteBuffer key){
		return StorageService.instance.getPartitioner().getToken(key);
	}
	
	public static Token keyToToken(byte[] key){
		return StorageService.instance.getPartitioner().getToken(ByteBuffer.wrap(key));
	}
	
//	public static Range TokenToRange(Token token){
//		ArrayList<Token> sortedTokens = StorageService.instance.getTokenMetadata().sortedTokens();
//		int firstTokenIndex = TokenMetadata.firstTokenIndex(sortedTokens, token, false);
//		return new Range(sortedTokens.get(firstTokenIndex - 1), sortedTokens.get(firstTokenIndex));
//	}
//	
//	public static Range keyToRange(byte[] key){
//		return TokenToRange(keyToToken(key));
//	}

	@Override
	public boolean isRole(Role r) {
		if (Role.Candidate == r) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Actor getRole(Role r) {
		if (Role.Acceptor == r)
			return this;
		else
			return null;
	}

	
//	public PaxosInstance getInstance(Long instanceNumber) {
//		//1, check if the input instance is this Actor's responsibility
//		if (!checkActorResponsibility(instanceNumber)) return null;
//		
//		//2, get instance from Paxos manager
//		return PaxosManager.getInstance(instanceNumber);
//	}
	
	//TODO
	private boolean checkActorResponsibility(Long instanceNumber){
		return true;
	}

	
//	public Range getRange() {
//		return range;
//	}

	// Map<tablename,multimap<endpoint address, token range>>
	@Deprecated
	public static Map<String, Multimap<InetAddress, Range>> allAddressRanges = new HashMap<String, Multimap<InetAddress, Range>>();
	@Deprecated
	Range range;
	//other actors for this range
	@Deprecated
	Map<InetAddress, Role> otherActors;
	/***
	 * number of actors has to be controlled,
	 * so, all the BasicActor Constructors should only be called in ActorManager
	 * 
	 * @param tablename
	 * @param range
	 */
	@Deprecated
	public
	BasicActor(String tablename, Range range) {
//		table = Table.open(tablename);
//		endpoint = FBUtilities.getLocalAddress();
//		this.range = range;
//
//		//TODO this may need to be synchronized
//		Collection<Range> addressRanges;
//		if (allAddressRanges.get(tablename) == null
//				|| allAddressRanges.get(tablename).get(endpoint) == null) {
//			addressRanges = StorageService.instance.getLocalRanges(tablename);
//			Multimap<InetAddress, Range> endpointToRanges = HashMultimap
//					.create();
//			for (Range r : addressRanges) {
//				endpointToRanges.put(endpoint, r);
//			}
//			allAddressRanges.put(tablename, endpointToRanges);
//		} else {
//			addressRanges = allAddressRanges.get(tablename).get(endpoint);
//		}
	}

	@Deprecated
	BasicActor(String tablename, Token token){
//		table = Table.open(tablename);
//		endpoint = FBUtilities.getLocalAddress();
//		
//		ArrayList<Token> sortedTokens = StorageService.instance.getTokenMetadata().sortedTokens();
//		int firstTokenIndex = TokenMetadata.firstTokenIndex(sortedTokens, token, false);
//		range = new Range(sortedTokens.get(firstTokenIndex - 1), sortedTokens.get(firstTokenIndex));
	}
}
