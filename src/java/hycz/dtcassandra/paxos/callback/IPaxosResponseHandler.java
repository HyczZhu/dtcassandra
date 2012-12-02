package hycz.dtcassandra.paxos.callback;

import java.util.concurrent.TimeoutException;

import org.apache.cassandra.net.IAsyncCallback;
import org.apache.cassandra.thrift.UnavailableException;

public interface IPaxosResponseHandler extends IAsyncCallback{
	public PaxosResponseType get();
    //public void assureSufficientLiveNodes() throws UnavailableException;
}
