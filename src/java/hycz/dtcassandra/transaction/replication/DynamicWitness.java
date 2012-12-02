package hycz.dtcassandra.transaction.replication;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.dht.Range;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

/***
 * Only need to know if this is an acceptor for some range
 * and the which endpoint this witness is build for.
 * When destroy, need to transport the Paxos data to 
 * the recovered endpoint.
 * @author Hycz
 *
 */
public class DynamicWitness {
	private final String tableName;
	private final Range range;

	private InetAddress witness;
	private List<InetAddress> readable;
	
	public DynamicWitness(String tableName, Range range, InetAddress acceptor, List<InetAddress> readable){
		assert readable!= null; 
		this.tableName = tableName;
		this.range = range;
		this.witness = acceptor;
		this.readable = readable;
	}
}
