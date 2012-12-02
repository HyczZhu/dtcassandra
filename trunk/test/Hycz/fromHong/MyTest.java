package fromHong;


import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cassandra.client.RingCache;
import org.apache.cassandra.db.migration.avro.AddKeyspace;
import org.apache.cassandra.dht.RandomPartitioner;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.*;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.WrappedRunnable;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

//import org.apache.cassandra.CassandraServiceController.Failure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class MyTest {
	private static Cassandra.Client client;
	private static Connector connector;
	
    static class KeyspaceCreation
    {
        private String name;
        private int rf;
        private CfDef cfdef;
        public KeyspaceCreation(String name)
        {
            this.name = name;
            cfdef = new CfDef(name, "Standard1");
            cfdef.setComparator_type("BytesType");
            cfdef.setKey_cache_size(10000);
            cfdef.setRow_cache_size(1000);
            cfdef.setRow_cache_save_period_in_seconds(0);
            cfdef.setKey_cache_save_period_in_seconds(3600);
            cfdef.setMemtable_flush_after_mins(59);
            cfdef.setMemtable_throughput_in_mb(255);
            cfdef.setMemtable_operations_in_millions(0.29);
        }
        
        public KeyspaceCreation validator(String validator)
        {
            cfdef.setDefault_validation_class(validator);
            return this;
        }

        public KeyspaceCreation rf(int rf)
        {
            this.rf = rf;
            return this;
        }

        public void create() throws Exception
        {
            Map<String,String> stratOptions = new HashMap<String,String>();
            stratOptions.put("replication_factor", "" + rf);
            client.system_add_keyspace(new KsDef(name,
                                                 "org.apache.cassandra.locator.SimpleStrategy",
                                                 Arrays.asList(cfdef))
                                               .setStrategy_options(stratOptions)
                                               .setCf_defs(Arrays.asList(cfdef)));
       
            List<KsDef> ksDefList = client.describe_keyspaces();
            
            System.out.println(ksDefList.toString());      
        }    
    }
    
    protected static KeyspaceCreation keyspace(String name)
    {
    	return new KeyspaceCreation(name);
    }

    protected static void addKeyspace(String name, int rf) throws Exception
    {
    	keyspace(name).rf(rf).create();
    }    
    
	protected static void insert(Cassandra.Client client, ByteBuffer key, String cf,
			String name, String value, long timestamp, ConsistencyLevel cl)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, TException {
		Column col = new Column(ByteBuffer.wrap(name.getBytes())).setValue(
				ByteBuffer.wrap(value.getBytes())).setTimestamp(timestamp);
		client.insert(key, new ColumnParent(cf), col, cl);
	}  

    protected static ByteBuffer newKey()
    {
        return ByteBuffer.wrap(String.format("test.key.%d", System.currentTimeMillis()).getBytes());
    }
	
	public static void main(String[] args) throws Exception{
		
		connector = new Connector();
		client = connector.connect();
		final String keyspace = "TestInsert";
		
		client.set_keyspace("bb");
		
/*        client.system_drop_keyspace(keyspace);
		addKeyspace(keyspace, 3);
		client.set_keyspace(keyspace);
		
		
		
		//client.system_add_column_family(cfdef);
        KsDef ksDefList = client.describe_keyspace(keyspace);
        
        System.out.println(ksDefList.toString());
	
		
		ByteBuffer key = newKey();
        insert(client, key, "Standard1", "c1", "v1", 0, ConsistencyLevel.ONE);
        insert(client, key, "Standard1", "c2", "v2", 0, ConsistencyLevel.ONE);
		System.out.println("Fuck");*/
	}
}
