package hycz.cassandra.test.net;

import org.apache.cassandra.thrift.CassandraDaemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hycz.cassandra.test.service.CassandraOnlySetup;

public class TestMessagingService {
	private static Logger logger = LoggerFactory.getLogger(TestMessagingService.class);
    
	public static void main(String[] args){
		System.out.println("test begins");
		new CassandraOnlySetup().activate();
		System.out.println("the end");
	}

}
