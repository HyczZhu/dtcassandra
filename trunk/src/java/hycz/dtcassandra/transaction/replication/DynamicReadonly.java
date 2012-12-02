package hycz.dtcassandra.transaction.replication;

import java.net.InetAddress;
import java.util.List;

import org.apache.cassandra.dht.Range;

/***
 * Need to know where to synchronize data.
 * @author Hycz
 *
 */
public class DynamicReadonly {
	private final String tableName;
	private final Range range;
	private List<InetAddress> learners;
	
	public DynamicReadonly(String tableName, Range range, List<InetAddress> learners){
		this.tableName = tableName;
		this.range = range;
		this.learners = learners;
	}
}
