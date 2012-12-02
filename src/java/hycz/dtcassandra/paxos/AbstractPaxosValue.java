package hycz.dtcassandra.paxos;

public abstract class AbstractPaxosValue implements IPaxosValue{

	public static Object makeNullValue(){
		return null;
	}
}
