package hycz.dtcassandra.paxos;

import hycz.dtcassandra.paxos.storage.SimpleAccess;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class PaxosValueFactory {
	public static String VALUETYPE_UNDEFINED = "undefined";
	public static String VALUETYPE_STRING = "StringPaxosValue";
	public static String VALUETYPE_ROWMUTATION = "RowMutationPaxosValue";
	public static BiMap<Integer, String> valueTypes = HashBiMap.create();
//	public static List<String> valueTypes = new ArrayList<String>();
	
	static {
		valueTypes.put(0, VALUETYPE_UNDEFINED);
		valueTypes.put(1, VALUETYPE_STRING);
		valueTypes.put(2, VALUETYPE_ROWMUTATION);
	}
	
	private static PaxosValueSerializer serializer = new PaxosValueSerializer();

	public static ICompactSerializer<IPaxosValue> serializer(){
		return serializer;
	}
	
	public static IPaxosValue getPaxosValue(byte[] bytes, String type){
		try {
			if (type.equals(VALUETYPE_STRING)){
				return StringPaxosValue.fromBytes(bytes);
			}
			else if (type.equals(VALUETYPE_ROWMUTATION)){
				return RowMutationPaxosValue.fromBytes(bytes, SimpleAccess.version);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getValueType(IPaxosValue value){
		if (value instanceof StringPaxosValue)
			return VALUETYPE_STRING;
		else if (value instanceof RowMutationPaxosValue)
			return VALUETYPE_ROWMUTATION;
		else
			return VALUETYPE_UNDEFINED;
	}
	
	public static String getValueType(Integer num){
		return valueTypes.get(num);
	}
	
	public static Integer getValueTypeNum(IPaxosValue value){
		return valueTypes.inverse().get(getValueType(value));
	}
	
	public static Integer getValueTypeNum(String valueType){
		return valueTypes.inverse().get(valueType);
	}
	
	private static class PaxosValueSerializer implements ICompactSerializer<IPaxosValue>
    {
		/***
		 * valueType : int
		 * tableName : String
		 * range : Range
		 * value : call different serializer
		 */
		public void serialize(IPaxosValue value, DataOutputStream out, int version)
				throws IOException {
			String valueType = PaxosValueFactory.getValueType(value);
			out.writeInt(PaxosValueFactory.getValueTypeNum(valueType));
			out.writeUTF(value.getTableName());
			AbstractBounds.serializer().serialize(value.getRange(), out);
			if (valueType.equals(VALUETYPE_STRING)){
				out.writeUTF((String)(value.getValue()));
			}
			else if (valueType.equals(VALUETYPE_ROWMUTATION)){
				RowMutation.serializer().serialize((RowMutation)(value.getValue()), out, version);
			}
			else{
			}
		}

		public IPaxosValue deserialize(DataInputStream in, int version) throws IOException {
			String valueType = PaxosValueFactory.getValueType(in.readInt());
			String tableName = in.readUTF();	
			Range range = (Range) AbstractBounds.serializer().deserialize(in);
			if (valueType.equals(VALUETYPE_STRING)){
				String value = in.readUTF();
				return new StringPaxosValue(tableName, range,value);
			}
			else if (valueType.equals(VALUETYPE_ROWMUTATION)){
				RowMutation value = RowMutation.serializer().deserialize(in, version);
				return new RowMutationPaxosValue(tableName, range, value);
			}
			else{
				return null;
			}
        }
    }
}
