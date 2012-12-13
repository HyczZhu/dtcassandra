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
	public static String VALUETYPE_MULTIRM = "MultiRMPaxosValue";
	public static BiMap<Integer, String> valueTypes = HashBiMap.create();
//	public static List<String> valueTypes = new ArrayList<String>();
	
	static {
		valueTypes.put(0, VALUETYPE_UNDEFINED);
		valueTypes.put(1, VALUETYPE_STRING);
		valueTypes.put(2, VALUETYPE_ROWMUTATION);
		valueTypes.put(3, VALUETYPE_MULTIRM);
	}
	
	private static PaxosValueSerializer serializer = new PaxosValueSerializer();

	public static ICompactSerializer<IPaxosValue> serializer(){
		return serializer;
	}
	
	public static IPaxosValue getPaxosValue(byte[] bytes, String type){
		try {
			if (VALUETYPE_STRING.equals(type)){
				return StringPaxosValue.fromBytes(bytes);
			}
			else if (VALUETYPE_ROWMUTATION.equals(type)){
				return RowMutationPaxosValue.fromBytes(bytes, SimpleAccess.version);
			}
			else if (VALUETYPE_MULTIRM.equals(type)){
				return MultiRMPaxosValue.fromBytes(bytes, SimpleAccess.version);
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
		else if (value instanceof MultiRMPaxosValue)
			return VALUETYPE_MULTIRM;
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
			if (valueType.equals(VALUETYPE_STRING)){
				out.writeUTF((String)(value.getValue()));
			}
			else if (valueType.equals(VALUETYPE_ROWMUTATION)){
				RowMutationPaxosValue.serializer().serialize((RowMutationPaxosValue)value, out, version);
//				RowMutation.serializer().serialize((RowMutation)(value.getValue()), out, version);
			}
			else if(valueType.equals(VALUETYPE_MULTIRM)){
				MultiRMPaxosValue.serializer().serialize((MultiRMPaxosValue)value, out, version);
			}
			else{
			}
		}

		public IPaxosValue deserialize(DataInputStream in, int version) throws IOException {
			String valueType = PaxosValueFactory.getValueType(in.readInt());
			if (valueType.equals(VALUETYPE_STRING)){
//				String value = in.readUTF();
//				return new StringPaxosValue(tableName, range,value);
				return StringPaxosValue.serializer().deserialize(in);
			}
			else if (valueType.equals(VALUETYPE_ROWMUTATION)){
//				RowMutation value = RowMutation.serializer().deserialize(in, version);
//				return new RowMutationPaxosValue(tableName, range, value);
				return RowMutationPaxosValue.serializer().deserialize(in, version);
			}
			else if (valueType.equals(VALUETYPE_MULTIRM)){
				return MultiRMPaxosValue.serializer().deserialize(in, version);
			}
			else{
				return null;
			}
        }
    }
}
