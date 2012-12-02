package hycz.cassandra.testBase;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.cassandra.thrift.Cassandra;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.whirr.service.ClusterSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleController {
	private static final Logger LOG =
        LoggerFactory.getLogger(SimpleController.class);

    protected static int CLIENT_PORT    = 9160;
    protected static int JMX_PORT       = 7199;
    
    private static final SimpleController INSTANCE =
        new SimpleController();
    
    public static SimpleController getInstance(){
        return INSTANCE;
    }
    
    private CompositeConfiguration config;
//    private ClusterSpec         clusterSpec;
    private List<InetAddress>   hosts;
    
    void initialize(){
    	//get config from properties file
    	config = new CompositeConfiguration();    	
    	try {
			config.addConfiguration(
					new PropertiesConfiguration("cassandra-test-default.properties"));
		} catch (ConfigurationException e) {e.printStackTrace();}
		
    	//get cassandra hosts
    	String[] list=config.getStringArray("hosts");
    	hosts=new ArrayList<InetAddress>();
    	try {
    		for(String s:list){
    			hosts.add(InetAddress.getByName(s));
    		}
    	} catch (UnknownHostException e) {e.printStackTrace();}
    }
    
    public SimpleController(){
    	initialize();
    }
    
    //TODO close transport manually or automatically
    public Cassandra.Client createClient(InetAddress addr) throws TException
    {
        TTransport transport    = new TSocket(
                                    addr.getHostAddress(),
                                    CLIENT_PORT,
                                    200000);
        transport               = new TFramedTransport(transport);
        TProtocol  protocol     = new TBinaryProtocol(transport);

        Cassandra.Client client = new Cassandra.Client(protocol);
        transport.open();

        return client;
    }
    
    public CompositeConfiguration getConfig() {
		return config;
	}
//	public ClusterSpec getClusterSpec() {
//		return clusterSpec;
//	}
    public List<InetAddress> getHosts(){    	
    	return hosts;
    }
    
    //TODO realize ensureClusterRunning(). For now only assume the cluster is already running
    public synchronized boolean ensureClusterRunning() throws Exception
    {
//        if (running)
//        {
            LOG.info("Cluster already running.");
            return false;
//        }
//        else
//        {
//            startup();
//            return true;
//        }
    }
    
    public InetAddress getPublicHost(InetAddress privateHost){
    	//TODO getPublicHost
//        for (Instance instance : cluster.getInstances())
//            if (privateHost.equals(instance.getPrivateAddress()))
//                return instance.getPublicAddress();
//        throw new RuntimeException("No public host for private host " + privateHost);
    	return null;
    }
}
