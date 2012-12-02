package hycz.cassandra.testBase;

import hycz.cassandra.testBase.TestBase.Get;

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.List;

import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.ColumnOrSuperColumn;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleClient extends TestBaseWithoutWhirr{
	private static final Logger logger = LoggerFactory.getLogger(SimpleClient.class);
	
	public void testInsert() throws Exception
    {
		
        List<InetAddress> hosts = controller.getHosts();
        final String keyspace = "TestInsert";
        //这里设定了keyspace的名称，和副本数量，如果在单机测试，则不能把副本数量设置为3
        addKeyspace(keyspace, 1);
        Cassandra.Client client = controller.createClient(hosts.get(0));
        try{
        	client.set_keyspace(keyspace);

	        ByteBuffer key = newKey();
	
	        insert(client, key, "Standard1", "c1", "v1", 0, ConsistencyLevel.ONE);
	        insert(client, key, "Standard1", "c2", "v2", 0, ConsistencyLevel.ONE);
	
	        // block until the column is available
	        new Get(client, "Standard1", key).name("c1").value("v1").perform(ConsistencyLevel.ONE);
	        new Get(client, "Standard1", key).name("c2").value("v2").perform(ConsistencyLevel.ONE);
	
	        List<ColumnOrSuperColumn> coscs = get_slice(client, key, "Standard1", ConsistencyLevel.ONE);
	        assertColumnEqual("c1", "v1", 0, coscs.get(0).column);
	        assertColumnEqual("c2", "v2", 0, coscs.get(1).column);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			client.send_system_drop_keyspace(keyspace);
		}
    }
	
	//基本就是这样的方式进行一个用例的执行，之后的可以仿写
	
	public static void main(String[] args){
		SimpleClient sc=new SimpleClient();
		try {
			sc.testInsert();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("包晨诚是sb");
	}

}
