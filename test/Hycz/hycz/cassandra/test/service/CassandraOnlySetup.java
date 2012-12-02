package hycz.cassandra.test.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CassandraOnlySetup extends org.apache.cassandra.service.AbstractCassandraDaemon{
	private static Logger logger = LoggerFactory.getLogger(CassandraOnlySetup.class);
	
	@Override
	protected void startServer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stopServer() {
		// TODO Auto-generated method stub
		
	}

	public CassandraOnlySetup() {
		String pidFile = System.getProperty("cassandra-pidfile");

		try {
			setup();

			if (pidFile != null) {
				new File(pidFile).deleteOnExit();
			}

			if (System.getProperty("cassandra-foreground") == null) {
				System.out.close();
				System.err.close();
			}

			//start();
		} catch (Throwable e) {
			String msg = "Exception encountered during startup.";
			logger.error(msg, e);

			// try to warn user on stdout too, if we haven't already detached
			System.out.println(msg);
			e.printStackTrace();

			System.exit(3);
		}

	}
//
//	public static void main(String[] args) {
//		new CassandraOnlySetup().activate();
//	}
	
}
