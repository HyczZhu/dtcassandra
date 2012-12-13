package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.actor.BasicActor;
import hycz.dtcassandra.paxos.message.PrepareMessage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOError;
import java.io.IOException;

import org.apache.cassandra.db.Table;
import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer2;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

public class StringPaxosValue extends AbstractPaxosValue{

	Table table;
	Range range;
	String value;
	private long timestamp;
	
	private static StringPaxosValueSerializer serializer = new StringPaxosValueSerializer();

	public static ICompactSerializer2<IPaxosValue> serializer(){
		return serializer;
	}
	
	//only for test
	public StringPaxosValue(String value){
		this(Table.SYSTEM_TABLE, StorageService.instance.getPrimaryRangeForEndpoint(FBUtilities.getLocalAddress()), value);
	}
	
	public StringPaxosValue(String tablename, Range range, String value) {
		table = Table.open(tablename);
		this.range = range;
		this.value = value;
		timestamp = -1;
	}
	
	public StringPaxosValue(String tablename, Range range, String value, long timestamp) {
		table = Table.open(tablename);
		this.range = range;
		this.value = value;
		this.timestamp = timestamp;
	}
	
	@Override
	public Table getTable() {
		return table;
	}

	@Override
	public String getTableName() {
		return table.name;
	}

	@Override
	public Range getRange() {
		return range;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}
	
	@Override
	public long getTimestamp(){
		return timestamp;
	}
	
	@Override
	public void apply(){
	}
	
	@Override
	public byte[] toBytes() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
        	StringPaxosValue.serializer().serialize(this, dos);
        }
        catch (IOException e)
        {
            throw new IOError(e);
        }
        return bos.toByteArray();
	}
	
	@Override
	public boolean equals(IPaxosValue value){
		return getValue().equals(value.getValue());
	}
	
	public static IPaxosValue fromBytes(byte[] bytes) throws IOException {
		ByteArrayInputStream body = new ByteArrayInputStream(bytes);
		return StringPaxosValue.serializer().deserialize(new DataInputStream(body));
	}
	
	public static StringPaxosValue makeNullValue() {
		return new StringPaxosValue(new String(""));
	}
	
	private static class StringPaxosValueSerializer implements ICompactSerializer2<IPaxosValue>
    {
		public void serialize(IPaxosValue value, DataOutput out)
				throws IOException {
			out.writeUTF(value.getTableName());
			AbstractBounds.serializer().serialize(value.getRange(), out);
			out.writeUTF((String)(value.getValue()));
			out.writeLong(value.getTimestamp());
		}

		public IPaxosValue deserialize(DataInput in) throws IOException {
			String tableName = in.readUTF();	
			Range range = (Range) AbstractBounds.serializer().deserialize(in);
			String value = in.readUTF();
			long timestamp = in.readLong();

			return new StringPaxosValue(tableName, range, value, timestamp);

        }
    }
}
