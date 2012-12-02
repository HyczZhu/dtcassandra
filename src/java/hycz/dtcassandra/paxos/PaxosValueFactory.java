package hycz.dtcassandra.paxos;

import java.io.IOException;

public class PaxosValueFactory {
	public static String VALUETYPE_STRING = "StringPaxosValue";
	
	public static IPaxosValue getPaxosValue(byte[] bytes, String type){
		try {
			if (type.equals(VALUETYPE_STRING)){
				return StringPaxosValue.fromBytes(bytes);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
