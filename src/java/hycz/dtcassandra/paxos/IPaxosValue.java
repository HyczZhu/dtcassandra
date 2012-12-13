package hycz.dtcassandra.paxos;

import java.io.IOException;

import org.apache.cassandra.db.Table;
import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer2;

//TODO generalize paxos value
public interface IPaxosValue {
	
	//this 3 method are for the table-Range-Actor mechanism
	Table getTable();
	String getTableName();
	Range getRange();
	Object getValue();
	void setTimestamp(long timestamp);
	long getTimestamp();
	
	void apply() throws IOException;
	
	byte[] toBytes();
//	IPaxosValue fromBytes(byte[] bytes) throws IOException;
	
	boolean equals(IPaxosValue value);

}
