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
        //�����趨��keyspace�����ƣ��͸�������������ڵ������ԣ����ܰѸ�����������Ϊ3
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
	
	//�������������ķ�ʽ����һ��������ִ�У�֮��Ŀ��Է�д
	
	public static void main(String[] args){
		SimpleClient sc=new SimpleClient();
		try {
			sc.testInsert();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("��������sb");
	}

}
