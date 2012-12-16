package hycz.dtcassandra.test;

import static org.apache.cassandra.Util.column;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

import org.apache.cassandra.Util;
import org.apache.cassandra.client.TestRingCache;
import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.config.KSMetaData;
import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.ColumnFamily;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.ColumnFamilyType;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.db.Row;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.SliceByNamesReadCommand;
import org.apache.cassandra.db.SliceFromReadCommand;
import org.apache.cassandra.db.SuperColumn;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.db.filter.QueryFilter;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.marshal.BytesType;
import org.apache.cassandra.db.marshal.UTF8Type;
import org.apache.cassandra.db.migration.AddColumnFamily;
import org.apache.cassandra.db.migration.AddKeyspace;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.locator.LocalStrategy;
import org.apache.cassandra.locator.TokenMetadata;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.thrift.*;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Bytes;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.PaxosInstance;
import hycz.dtcassandra.paxos.PaxosInstanceManager;
import hycz.dtcassandra.paxos.PaxosLeaderInstance;
import hycz.dtcassandra.paxos.PaxosLeaderInstanceManager;
import hycz.dtcassandra.paxos.PaxosOverallManager;
import hycz.dtcassandra.paxos.PaxosState;
import hycz.dtcassandra.paxos.PaxosValueFactory;
import hycz.dtcassandra.paxos.RowMutationPaxosValue;
import hycz.dtcassandra.paxos.StringPaxosValue;
import hycz.dtcassandra.paxos.actor.Actor;
import hycz.dtcassandra.paxos.actor.ActorRole;
import hycz.dtcassandra.paxos.actor.GlobalActorRoleManager;
import hycz.dtcassandra.paxos.callback.IPaxosResponseHandler;
import hycz.dtcassandra.paxos.callback.PaxosResponseType;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;
import hycz.dtcassandra.transaction.CurrentRead;
import hycz.dtcassandra.transaction.NWRLevel;
import hycz.dtcassandra.transaction.WriteTransaction;
import hycz.dtcassandra.transaction.replication.RangeNotFoundException;
import hycz.dtcassandra.transaction.replication.ReplicationManager;
import hycz.dtcassandra.transaction.replication.StaticReplication;

import java.util.List;
import java.io.UnsupportedEncodingException;

import jline.ConsoleReader;

import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.TException;
import org.apache.cassandra.service.*;
import org.apache.commons.lang.StringUtils;

public class Patch {
	private static Logger logger = LoggerFactory.getLogger(Patch.class);

	public static boolean doPatch() {

		for (int i=0;i<10;++i){
			System.out.println("!!!!");
		}
		
//		tryGetLocal();

		
		try {		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		    String s;
		    System.out.println("input begin");
			while (true){
				s = br.readLine();
				Scanner scn = new Scanner(s);
				scn.useDelimiter("\\s+");
				// command
				try{
					if (scn.hasNext()){
						String command = scn.next();
						
						if (command.equals("write")){
							int n = 100;
							boolean front = false;
							while (scn.hasNext()){
								String arg_key = scn.next("-\\w+");
								if (arg_key.equals("-n")){
									n = scn.nextInt();
									System.out.println("input num = "+n);
								}
								else if (arg_key.equals("-f")){
									front = true;
									System.out.println("set output front");
								}
								else {
									System.out.println("invalid command arg, ignore");
									break;
								}
							}
							write(n, front);
						}
						else if (command.equals("read")){
							int n = 100;
							boolean front = false;
							while (scn.hasNext()){
								String arg_key = scn.next("-\\w+");
								if (arg_key.equals("-n")){
									n = scn.nextInt();
									System.out.println("input num = "+n);
								}
								else if (arg_key.equals("-f")){
									front = true;
									System.out.println("set output front");
								}
								else {
									System.out.println("invalid command arg, ignore");
									break;
								}
							}
							currentread(n, front);
						}
						else if (command.equals("setNWR")){
							int n=1,w=1,r=1;
							while (scn.hasNext()){
								String arg_key = scn.next("-\\w+");
								if (arg_key.equals("-nwr")){
									n = scn.nextInt();
									w = scn.nextInt();
									r = scn.nextInt();
									System.out.println("n="+n+" w="+w+" r="+r);
								}
							}
							NWRLevel.setNWR(n, w, r);
						}
						else if (command.equals("setup")){
							int rf = 1;
							while (scn.hasNext()){
								String arg_key = scn.next("-\\w+");
								if (arg_key.equals("-rf")){
									rf = scn.nextInt();
									System.out.println("replica factor = " + rf);
								}
							}
							setup(rf);
						}
						else if (command.equals("go")){
							System.out.println("gogogo");
							doPatch_internal();
						}
						else if (command.equals("help")){
							while (scn.hasNext()){
								String arg_key = scn.next("-\\w+");
								if (arg_key.equals("-n")){
									int arg_value = scn.nextInt();
									System.out.println("input num = "+arg_value);
								}
								else if (arg_key.equals("-f")){
									System.out.println("set output front");
								}
								else {
									System.out.println("invalid command arg, ignore");
									break;
								}
							}
						}
						else if (command.equals("exit")){
							System.out.println("exiting");
							break;
						}
					}
				} catch (InputMismatchException e){
					System.out.println("invalid command");
					continue;
				} catch(NoSuchElementException e){
					System.out.println("invalid command");
					continue;
				} catch(Exception e){
					System.out.println("needs to setup the test keyspace");
					e.printStackTrace();
				}
			}
			System.out.println("input end");
		} catch (IOException e) { 
			System.out.println("io exception");
		    e.printStackTrace();  
		} finally{
			System.out.println("finally");
		}
		System.out.println("before return");
		return true;
	}
	
	public static void setup(int replicaFactor){
//		try{
		SimpleAccess.tryAddPaxosUtilKeyspace();
		SimpleAccess.tryAddTestKeyspace(replicaFactor);
		PaxosOverallManager.setup();
		PaxosInstanceManager.setup();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	public static boolean doPatch_internal() {
		logger.debug("this is patch added by Hycz.");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
//	    String s;
//		try {
//			while (true){
//				s = br.readLine();
//				if (s.equals("go")){
//			    	System.out.println("gogogo");
//					break;
//			    }
//				else if (s.equals("quit")){
//					System.out.println("quit");
//					return false;
//				}
//			}
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
	    
//		SimpleAccess.tryAddPaxosUtilKeyspace();
//		SimpleAccess.tryAddNewColumnFamily();
//		SimpleAccess.tryAddTestKeyspace();
		

		long start = System.currentTimeMillis();
		int n = 10;
		/***
		 * fake Paxos entrance 1
		 */
		for (int i = 0; i < n; ++i) {
//			testCase();
//			testCase2();
//			testCase3();
//			testCase6();
			testWriteTransaction();
//			testCurrentRead();
		}
		long end = System.currentTimeMillis();
		double writeLatency = ((double)(end-start))/n;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < n; ++i) {
			testCurrentRead();
		}
		end = System.currentTimeMillis();
		double currentReadLatency = ((double)(end-start))/n;
		
		System.out.println("write: " + writeLatency + " ms per testcase");
		System.out.println("read : " + currentReadLatency + " ms per testcase");

		return true;
	}
	
	public static void write(int n, boolean front){
//		SimpleAccess.tryAddPaxosUtilKeyspace();
//		SimpleAccess.tryAddNewColumnFamily();
//		SimpleAccess.tryAddTestKeyspace();

		long start = System.currentTimeMillis();
		/***
		 * fake Paxos entrance 1
		 */
		for (int i = 0; i < n; ++i) {
			testWriteTransaction();
		}
		long end = System.currentTimeMillis();
		double writeLatency = ((double)(end-start))/n;
		
		System.out.println("write: " + writeLatency + " ms per testcase");
	}
	
	public static void currentread(int n, boolean front){
//		SimpleAccess.tryAddPaxosUtilKeyspace();
//		SimpleAccess.tryAddNewColumnFamily();
//		SimpleAccess.tryAddTestKeyspace();

		long start = System.currentTimeMillis();
		/***
		 * fake Paxos entrance 1
		 */
		for (int i = 0; i < n; ++i) {
			testCurrentRead();
		}
		long end = System.currentTimeMillis();
		double currentReadLatency = ((double)(end-start))/n;
		
		System.out.println("read : " + currentReadLatency + " ms per testcase");
	}
	
	public static void leaderSample(String tableName, Range range, IPaxosValue value) {
		//1, check if this node should send the first message, just for test
		
		// String toaddress = new String("localhost");
		// String toaddress = new String("dtc00");
		String toaddress = new String("dtc01");
		String fromaddress = new String("dtc00");
		InetAddress to;
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			to = InetAddress.getByName(toaddress);
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			Collection<InetAddress> acceptorEndpoints = new ArrayList<InetAddress>();
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(2, 1);;
			
			//2, make a PaxosInstance object
			PaxosLeaderInstance instance = PaxosOverallManager.get(tableName, range).getAndCreateLeaderInstance();
//			ReplicationManager.instance().setAcceptor(tableName, range);
			
			//3, set prepare callback
			List<InetAddress> hosts = new GlobalActorRoleManager().getEndpointsForRange(tableName, range);
			//acceptorEndpoints.add(to);
			//acceptorEndpoints.add(localhost);
			acceptorEndpoints.addAll(hosts);
			//witnessAcceptorEndpoints.put(to, to);
			//witnessAcceptorEndpoints.put(localhost, localhost);
			for (InetAddress host : hosts){
				witnessAcceptorEndpoints.put(host, host);
			}
			
			IPaxosResponseHandler prepareResponseHandler = 
				instance.createPrepareResponseHandler(
						acceptorEndpoints, 
						witnessAcceptorEndpoints, 
						ConsistencyLevel.ALL);
			
			//4, send message
			for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints.asMap().entrySet()){
				InetAddress destination = entry.getKey();
	            Collection<InetAddress> targets = entry.getValue();
	            
//	            if (targets.size() == 1 && targets.iterator().next().equals(destination))
//	            {
//	                // unhinted writes
//	                if (destination.equals(FBUtilities.getLocalAddress()))
//	                {
//	                	System.out.println("don't send prepare message to local");
//	    				logger.debug("don't send prepare message to local");
//	    				// MessagingService.instance().sendOneWay(
//	    				// preparemessage.getMessage(MessagingService.version_),
//	    				// to);
//	                }
//	            }
//	            else
//	            {
//					for (InetAddress target : targets) {
//						if (!target.equals(destination)) {
//							logger.debug("A Hint appears: (destination = "
//									+ destination.getHostAddress()
//									+ ", target = " + target.getHostAddress()
//									+ ")");
//							// addHintHeader(hintedMessage, target);
//							// if (logger.isDebugEnabled())
//							// logger.debug("insert writing key " +
//							// ByteBufferUtil.bytesToHex(rm.key()) + " to " +
//							// destination + " for " + target);
//						}
//						if (targets.contains(destination)) {
							logger.debug("sending the prepare message to " + destination.getHostAddress());
							PrepareMessage preparemessage = new PrepareMessage(
									tableName, range, instance.getInstanceNumber(), instance.getProposalNumber());

							MessagingService
									.instance()
									.sendRR(preparemessage
											.getMessage(MessagingService.version_),
											destination, prepareResponseHandler);
//						}
//						// MessagingService.instance().sendOneWay(
//						// preparemessage.getMessage(MessagingService.version_),
//						// to);
//					}					
//	            }
			}
			System.out.println("send over");
			
			//5, wait for prepare response
			PaxosResponseType prepareResult=prepareResponseHandler.get();
			
			if (prepareResult==PaxosResponseType.Quorum){
				logger.debug("prepare result: Quorum");
				
				//6, set accept callback
				IPaxosResponseHandler acceptResponseHandler = 
					instance.createAcceptResponseHandler(
							acceptorEndpoints, 
							witnessAcceptorEndpoints, 
							ConsistencyLevel.ALL);
				//7, find out which value to accept
				instance.moveToAcceptPhase(value);
				//change role
				ReplicationManager.instance().setAcceptor(instance.getPaxosValue().getTableName(), instance.getPaxosValue().getRange());
//				logger.debug("instance "+instance.instanceNumber +" 's value is set to "+instance.paxosValue.getValue());
				//already done in responseHandler.get()
				
				//8, send message
				for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints
						.asMap().entrySet()) {
					InetAddress destination = entry.getKey();
					Collection<InetAddress> targets = entry.getValue();

					logger.debug("sending the accept message to "
							+ destination.getHostAddress());
					AcceptMessage acceptMessage = new AcceptMessage(tableName, range, instance.getInstanceNumber(), instance.getProposalNumber(), instance.getPaxosValue());
					System.out.println(acceptMessage);
					

					MessagingService
							.instance()
							.sendRR(acceptMessage
									.getMessage(MessagingService.version_),
									destination, acceptResponseHandler);
				}
				
				//9, wait for accept response
				PaxosResponseType acceptResult=acceptResponseHandler.get();
				if (acceptResult == PaxosResponseType.Quorum){
					logger.debug("accept result: Quorum");
				}
				else if (acceptResult == PaxosResponseType.Timeout)
					logger.debug("accept result: Timeout");
			}
			else if (prepareResult==PaxosResponseType.Nack)
				logger.debug("prepare result: Nack");
			else if (prepareResult==PaxosResponseType.Timeout)
				logger.debug("prepare result: Timeout");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void testCase(){
		//1, check if this node should send the first message, just for test
		
		// String toaddress = new String("localhost");
		// String toaddress = new String("dtc00");
		String toaddress = new String("dtc01");
		String fromaddress = new String("dtc00");
		InetAddress to;
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			to = InetAddress.getByName(toaddress);
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			Collection<InetAddress> acceptorEndpoints = new ArrayList<InetAddress>();
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(2, 1);;
			
			//2, make a PaxosInstance object
			String tableName = SimpleAccess.TESTTABLE;
			Range range = StorageService.instance.getLocalPrimaryRange();
			PaxosLeaderInstance instance = PaxosOverallManager.get(tableName, range).getAndCreateLeaderInstance();
//			ReplicationManager.instance().setAcceptor(tableName, range);
			
			//3, set prepare callback
			//acceptorEndpoints.add(to);
			acceptorEndpoints.add(localhost);
			//witnessAcceptorEndpoints.put(to, to);
			witnessAcceptorEndpoints.put(localhost, localhost);
			
			IPaxosResponseHandler prepareResponseHandler = 
				instance.createPrepareResponseHandler(
						acceptorEndpoints, 
						witnessAcceptorEndpoints, 
						ConsistencyLevel.ALL);
			
			//4, send message
			for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints.asMap().entrySet()){
				InetAddress destination = entry.getKey();
	            Collection<InetAddress> targets = entry.getValue();
	            
//	            if (targets.size() == 1 && targets.iterator().next().equals(destination))
//	            {
//	                // unhinted writes
//	                if (destination.equals(FBUtilities.getLocalAddress()))
//	                {
//	                	System.out.println("don't send prepare message to local");
//	    				logger.debug("don't send prepare message to local");
//	    				// MessagingService.instance().sendOneWay(
//	    				// preparemessage.getMessage(MessagingService.version_),
//	    				// to);
//	                }
//	            }
//	            else
//	            {
//					for (InetAddress target : targets) {
//						if (!target.equals(destination)) {
//							logger.debug("A Hint appears: (destination = "
//									+ destination.getHostAddress()
//									+ ", target = " + target.getHostAddress()
//									+ ")");
//							// addHintHeader(hintedMessage, target);
//							// if (logger.isDebugEnabled())
//							// logger.debug("insert writing key " +
//							// ByteBufferUtil.bytesToHex(rm.key()) + " to " +
//							// destination + " for " + target);
//						}
//						if (targets.contains(destination)) {
							logger.debug("sending the prepare message to " + destination.getHostAddress());
							PrepareMessage preparemessage = new PrepareMessage(
									tableName, range, instance.getInstanceNumber(), instance.getProposalNumber());

							MessagingService
									.instance()
									.sendRR(preparemessage
											.getMessage(MessagingService.version_),
											destination, prepareResponseHandler);
//						}
//						// MessagingService.instance().sendOneWay(
//						// preparemessage.getMessage(MessagingService.version_),
//						// to);
//					}					
//	            }
			}
			System.out.println("send over");
			
			//5, wait for prepare response
			PaxosResponseType prepareResult=prepareResponseHandler.get();
			
			if (prepareResult==PaxosResponseType.Quorum){
				logger.debug("prepare result: Quorum");
				
				//6, set accept callback
				IPaxosResponseHandler acceptResponseHandler = 
					instance.createAcceptResponseHandler(
							acceptorEndpoints, 
							witnessAcceptorEndpoints, 
							ConsistencyLevel.ALL);
				//7, find out which value to accept
				instance.moveToAcceptPhase(new StringPaxosValue(new String("test Value")));
				//change role
				ReplicationManager.instance().setAcceptor(instance.getPaxosValue().getTableName(), instance.getPaxosValue().getRange());
//				logger.debug("instance "+instance.instanceNumber +" 's value is set to "+instance.paxosValue.getValue());
				//already done in responseHandler.get()
				
				//8, send message
				for (Map.Entry<InetAddress, Collection<InetAddress>> entry : witnessAcceptorEndpoints
						.asMap().entrySet()) {
					InetAddress destination = entry.getKey();
					Collection<InetAddress> targets = entry.getValue();

					logger.debug("sending the accept message to "
							+ destination.getHostAddress());
					AcceptMessage acceptMessage = new AcceptMessage(tableName, range, instance.getInstanceNumber(), instance.getProposalNumber(), instance.getPaxosValue());
					System.out.println(acceptMessage);
					

					MessagingService
							.instance()
							.sendRR(acceptMessage
									.getMessage(MessagingService.version_),
									destination, acceptResponseHandler);
				}
				
				//9, wait for accept response
				PaxosResponseType acceptResult=acceptResponseHandler.get();
				if (acceptResult == PaxosResponseType.Quorum){
					logger.debug("accept result: Quorum");
				}
				else if (acceptResult == PaxosResponseType.Timeout)
					logger.debug("accept result: Timeout");
			}
			else if (prepareResult==PaxosResponseType.Nack)
				logger.debug("prepare result: Nack");
			else if (prepareResult==PaxosResponseType.Timeout)
				logger.debug("prepare result: Timeout");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void testCase2(){
		//1, check if this node should send the first message, just for test
		
		// String toaddress = new String("localhost");
		// String toaddress = new String("dtc00");
		String toaddress = new String("dtc01");
		String fromaddress = new String("dtc00");
		InetAddress to;
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			to = InetAddress.getByName(toaddress);
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			Collection<InetAddress> acceptorEndpoints = new ArrayList<InetAddress>();
			Multimap<InetAddress, InetAddress> witnessAcceptorEndpoints = HashMultimap.create(2, 1);;
			
			//2, make a PaxosInstance object
			String tableName = SimpleAccess.TESTTABLE;
			Range range = StorageService.instance.getLocalPrimaryRange();
			PaxosLeaderInstance instance = PaxosOverallManager.get(tableName, range).getAndCreateLeaderInstance();
//			ReplicationManager.instance().setAcceptor(tableName, range);
			
			//3, set prepare callback
			//acceptorEndpoints.add(to);
			acceptorEndpoints.add(localhost);
			//witnessAcceptorEndpoints.put(to, to);
			witnessAcceptorEndpoints.put(localhost, localhost);
			
			//5, wait for prepare response
			PaxosResponseType prepareResult=instance.executePhaseOne();
			
			if (prepareResult==PaxosResponseType.Quorum){
				logger.debug("prepare result: Quorum");
				
				//9, wait for accept response
				PaxosResponseType acceptResult=instance.executePhaseTwo(new StringPaxosValue(new String("test Value2")));
				if (acceptResult == PaxosResponseType.Quorum){
					logger.debug("accept result: Quorum");
				}
				else if (acceptResult == PaxosResponseType.Timeout)
					logger.debug("accept result: Timeout");
			}
			else if (prepareResult==PaxosResponseType.Nack)
				logger.debug("prepare result: Nack");
			else if (prepareResult==PaxosResponseType.Timeout)
				logger.debug("prepare result: Timeout");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}
	}
	
	// try to make consensus at a StringPaxosValue and deliver it
	public static void testCase3(){
		String fromaddress = new String("dtc00");
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			
			String tableName = SimpleAccess.TESTTABLE;
			Range range = StorageService.instance.getLocalPrimaryRange();
			long instanceNum = PaxosOverallManager.get(tableName, range).makeConsensus(new StringPaxosValue(new String("test Value3")));
			System.out.println("result = " + instanceNum);
			boolean deliverSuccess = PaxosOverallManager.get(tableName, range).deliverValue(instanceNum, ConsistencyLevel.ANY);
			System.out.println("deliver success = " + deliverSuccess);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// try to make consensus at a RowMutationPaxosValue and deliver it
	public static void testCase4(){
		String fromaddress = new String("dtc00");
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			
			String tableName = SimpleAccess.TESTTABLE;
			String key = "RowMutationKey0000001";
			String columnfamilyName = SimpleAccess.CF_RANGE_pre;
			String supercolumnName = "testSuperColumn01";
			String columnName = "testColumn";
			String value = "testValue";
			
			DecoratedKey dk = Util.dk(key);
			RowMutation rm
			= new RowMutation(tableName, dk.key);
			ColumnFamily cf = ColumnFamily.create(tableName, SimpleAccess.CF_RANGE_pre);
			SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(supercolumnName), BytesType.instance);
			Column c=new Column(ByteBufferUtil.bytes(columnName), ByteBufferUtil.bytes(value), System.currentTimeMillis());
			sc.addColumn(c);
			cf.addColumn(sc);
			rm.add(cf);
			
			Token t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
			Range range = ReplicationManager.instance().getRange(t);
			
			long instanceNum = PaxosOverallManager.get(tableName, range)
				.makeConsensus(new RowMutationPaxosValue(tableName, range, rm));
			System.out.println("result = " + instanceNum);
			boolean deliverSuccess = PaxosOverallManager.get(tableName, range).deliverValue(instanceNum, ConsistencyLevel.ANY);
			System.out.println("deliver success = " + deliverSuccess);
		} 
		catch(NullPointerException e){
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (RangeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testCase5(){
		String fromaddress = new String("dtc00");
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress="
					+ localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			
			String tableName = SimpleAccess.TESTTABLE;
			String key = "RowMutationKey0000001";
			String columnfamilyName = SimpleAccess.CF_RANGE_pre;
			String supercolumnName = "testSuperColumn01";
			String columnName = "testColumn";
			String value = "testValue";
			
			DecoratedKey dk = Util.dk(key);
			RowMutation rm = new RowMutation(tableName, dk.key);
			ColumnFamily cf = ColumnFamily.create(tableName, SimpleAccess.CF_RANGE_pre);
			SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(supercolumnName), BytesType.instance);
			Column c=new Column(ByteBufferUtil.bytes(columnName), ByteBufferUtil.bytes(value), System.currentTimeMillis());
			sc.addColumn(c);
			cf.addColumn(sc);
			rm.add(cf);
			
			Token t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
			Range range = ReplicationManager.instance().getRange(t);

			WriteTransaction wt = new WriteTransaction(tableName, range, Arrays.asList(rm));
			wt.execute();
			
			CurrentRead cr = new CurrentRead(tableName, key, columnfamilyName, supercolumnName, columnName);
			List<Row> rows = cr.execute();
			for (Row row : rows){
				System.out.println(
						"curren read result : " +
						ByteBufferUtil.string(
								row.cf.getColumn(ByteBufferUtil.bytes(supercolumnName)).getSubColumn(ByteBufferUtil.bytes(columnName)).value()
								)
						);
			}
		} 
		catch(NullPointerException e){
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (RangeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testCase6(){
		System.out.println();
		String fromaddress = new String("dtc00");
		InetAddress localhost;
		InetAddress from;
		try {
			localhost = FBUtilities.getLocalAddress();
			from = InetAddress.getByName(fromaddress);
			System.out.println("LocalAddress=" + localhost.getHostAddress());
			System.out.println("From=" + from.getHostAddress());
			if (!from.equals(FBUtilities.getLocalAddress())) return;
			
			String tableName = SimpleAccess.TESTTABLE;
			String key = "RowMutationKey0000001";
			String columnfamilyName = SimpleAccess.CF_RANGE_pre;
			final String columnName = "testColumn";
			final long timestamp = System.currentTimeMillis();
			String value = "testValue" + timestamp;
			
			final DecoratedKey dk = Util.dk(key);
			RowMutation rm = new RowMutation(tableName, dk.key);
			ColumnFamily cf = ColumnFamily.create(tableName, SimpleAccess.CF_RANGE_pre);
			Column c=new Column(ByteBufferUtil.bytes(columnName), ByteBufferUtil.bytes(value), System.currentTimeMillis());
			cf.addColumn(c);
			rm.add(cf);
			
			Token t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
			Range range = ReplicationManager.instance().getRange(t);

			WriteTransaction wt = new WriteTransaction(tableName, range, Arrays.asList(rm));
			wt.execute();
			
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
			
			Runnable commandRead = new Runnable(){
				public void run(){
					ReadCommand command = 
			        	new SliceFromReadCommand(
			        			SimpleAccess.TESTTABLE, 
			        			dk.key, 
			        			new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes(columnName)), 
			        			ByteBufferUtil.bytes(System.currentTimeMillis()), 
			        			ByteBufferUtil.bytes(0L),
			        			true,
			        			1);
					System.out.println("trying to get column for timestamp = " + timestamp);
			        Row testrow;
					try {
						testrow = command.getRow(Table.open(SimpleAccess.TESTTABLE));
						IColumn sc = testrow.cf.getColumn(ByteBufferUtil.bytes(columnName));
						for (IColumn col : ((SuperColumn)sc).getSortedColumns()){
							System.out.println(ByteBufferUtil.toLong(col.name()) + " : " + ByteBufferUtil.string(col.value()));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};			
//			StageManager.getStage(Stage.PAXOS_DELIVER).execute(commandRead);
			
			CurrentRead cr = new CurrentRead(tableName, key, columnfamilyName, columnName);
			List<Row> rows = cr.execute();
			for (Row row : rows){
				try {
					System.out.println(
							"curren read result : " +
							(row.cf==null ? null :
							ByteBufferUtil.string(
									row.cf.getColumn(ByteBufferUtil.bytes(columnName)).getSubColumns().iterator().next().value()
									)
							)
							);
				} catch (CharacterCodingException e) {
					e.printStackTrace();
				}
			}
			

		} 
		catch(NullPointerException e){
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
//		} catch (CharacterCodingException e) {
//			e.printStackTrace();
		} catch (RangeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testWriteTransaction(){
		System.out.println();
		String fromaddress = new String("dtc00");
//		InetAddress localhost;
//		InetAddress from;
		try {
//			localhost = FBUtilities.getLocalAddress();
//			from = InetAddress.getByName(fromaddress);
//			if (!from.equals(FBUtilities.getLocalAddress())) return;
			
			Range localRange = ReplicationManager.instance().getRange(StorageService.instance.getLocalToken());
			
			String tableName = SimpleAccess.TESTTABLE;
			Integer random = (int)(Math.random()*100);
			String key = "RowMutationKey"+random;
			Token t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
			Range range = ReplicationManager.instance().getRange(t);
			while (!localRange.equals(range)){
				random = (int)(Math.random()*100000);
				key = "RowMutationKey"+random;
				t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
				range = ReplicationManager.instance().getRange(t);
			}
			
			String columnfamilyName = SimpleAccess.CF_RANGE_pre;
			final String columnName = "testColumn";
			final long timestamp = System.currentTimeMillis();
			String value = "testValue" + timestamp;
			
			final DecoratedKey dk = Util.dk(key);
			RowMutation rm = new RowMutation(tableName, dk.key);
			ColumnFamily cf = ColumnFamily.create(tableName, SimpleAccess.CF_RANGE_pre);
			Column c=new Column(ByteBufferUtil.bytes(columnName), ByteBufferUtil.bytes(value), System.currentTimeMillis());
			cf.addColumn(c);
			rm.add(cf);
			
			long start = System.currentTimeMillis();
			WriteTransaction wt = new WriteTransaction(tableName, range, Arrays.asList(rm));
			wt.execute();
			long end = System.currentTimeMillis();
			System.out.println((end - start) +"ms");
			
		} 
		catch(NullPointerException e){
			e.printStackTrace();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (CharacterCodingException e) {
//			e.printStackTrace();
		} catch (RangeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testCurrentRead(){
		System.out.println();
		String fromaddress = new String("dtc00");
		try {
			Range localRange = ReplicationManager.instance().getRange(StorageService.instance.getLocalToken());

			String tableName = SimpleAccess.TESTTABLE;
			Integer random = (int)(Math.random()*100);
			String key = "RowMutationKey"+random;
			Token t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
			Range range = ReplicationManager.instance().getRange(t);
			while (!localRange.equals(range)){
				random = (int)(Math.random()*100000);
				key = "RowMutationKey"+random;
				t = StorageService.getPartitioner().getToken(ByteBufferUtil.bytes(key));
				range = ReplicationManager.instance().getRange(t);
			}
			
			String columnfamilyName = SimpleAccess.CF_RANGE_pre;
			final String columnName = "testColumn";
			final long timestamp = System.currentTimeMillis();
			String value = "testValue" + timestamp;
			
			final DecoratedKey dk = Util.dk(key);
			RowMutation rm = new RowMutation(tableName, dk.key);
			ColumnFamily cf = ColumnFamily.create(tableName, SimpleAccess.CF_RANGE_pre);
			Column c=new Column(ByteBufferUtil.bytes(columnName), ByteBufferUtil.bytes(value), System.currentTimeMillis());
			cf.addColumn(c);
			rm.add(cf);
			
			CurrentRead cr = new CurrentRead(tableName, key, columnfamilyName, columnName);
			List<Row> rows = cr.execute();
			for (Row row : rows){
				try {
					System.out.println(
							"curren read result : " +
							(row.cf==null ? null :
							ByteBufferUtil.string(
									row.cf.getColumn(ByteBufferUtil.bytes(columnName)).getSubColumns().iterator().next().value()
									)
							)
							);
				} catch (CharacterCodingException e) {
					e.printStackTrace();
				}
			}
			

		} 
		catch(NullPointerException e){
			e.printStackTrace();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (CharacterCodingException e) {
//			e.printStackTrace();
		} catch (RangeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testSliceQuery(){
		Table table = Table.open(SimpleAccess.TESTTABLE);
        RowMutation rm;
        DecoratedKey dk = Util.dk("test_slice_key1");

        // add data
        rm = new RowMutation(SimpleAccess.TESTTABLE, dk.key);
        rm.add(new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC"), ByteBufferUtil.bytes("column0000")), ByteBufferUtil.bytes("column0000"), 0);
        rm.add(new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC"), ByteBufferUtil.bytes("column1111")), ByteBufferUtil.bytes("column1111"), 0);
        rm.add(new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC"), ByteBufferUtil.bytes("column2222")), ByteBufferUtil.bytes("column2222"), 0);
        rm.add(new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC"), ByteBufferUtil.bytes("column3333")), ByteBufferUtil.bytes("column3333"), 0);
        rm.add(new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC"), ByteBufferUtil.bytes("column4444")), ByteBufferUtil.bytes("column4444"), 0);
        try {
			rm.apply();
		} catch (IOException e) {
			e.printStackTrace();
		}

        ReadCommand command = 
        	new SliceFromReadCommand(
        			SimpleAccess.TESTTABLE, 
        			dk.key, 
        			new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC")), 
        			ByteBufferUtil.bytes("column0000"), 
        			ByteBufferUtil.bytes("column5555"),
        			false,
        			3);
        Row row;
		try {
			row = command.getRow(table);
			IColumn sc = row.cf.getColumn(ByteBufferUtil.bytes("sliceSC"));
			IColumn col0 = ((SuperColumn)sc).getSortedColumns().iterator().next();
			System.out.println(ByteBufferUtil.string(col0.name()) + " : " + ByteBufferUtil.string(col0.value()));
			for (IColumn col : ((SuperColumn)sc).getSortedColumns()){
				System.out.println(ByteBufferUtil.string(col.name()) + " : " + ByteBufferUtil.string(col.value()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		command = 
        	new SliceFromReadCommand(
        			SimpleAccess.TESTTABLE, 
        			dk.key, 
        			new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC")), 
        			ByteBufferUtil.bytes("column5555"),
        			ByteBufferUtil.bytes("column0000"), 
        			true,
        			3);
        try {
			row = command.getRow(table);
			IColumn sc = row.cf.getColumn(ByteBufferUtil.bytes("sliceSC"));
			int count = ((SuperColumn)sc).getSortedColumns().size();
			IColumn col0 = (IColumn) (((SuperColumn)sc).getSortedColumns().toArray())[count-1];
			System.out.println(ByteBufferUtil.string(col0.name()) + " : " + ByteBufferUtil.string(col0.value()));
			for (IColumn col : ((SuperColumn)sc).getSortedColumns()){
				System.out.println(ByteBufferUtil.string(col.name()) + " : " + ByteBufferUtil.string(col.value()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		command = 
        	new SliceFromReadCommand(
        			SimpleAccess.TESTTABLE, 
        			dk.key, 
        			new QueryPath(SimpleAccess.CF_RANGE_pre, ByteBufferUtil.bytes("sliceSC")), 
        			ByteBufferUtil.bytes("column6666"),
        			ByteBufferUtil.bytes("column0000"), 
        			true,
        			1);
        try {
			row = command.getRow(table);
			IColumn sc = row.cf.getColumn(ByteBufferUtil.bytes("sliceSC"));
			int count = ((SuperColumn)sc).getSortedColumns().size();
			IColumn col0 = (IColumn) (((SuperColumn)sc).getSortedColumns().toArray())[count-1];
			System.out.println(ByteBufferUtil.string(col0.name()) + " : " + ByteBufferUtil.string(col0.value()));
			for (IColumn col : ((SuperColumn)sc).getSortedColumns()){
				System.out.println(ByteBufferUtil.string(col.name()) + " : " + ByteBufferUtil.string(col.value()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testRowMutation(){
		DecoratedKey dk = Util.dk("sdfsfsfdsfsfd");
		RowMutation rm = new RowMutation(SimpleAccess.TESTTABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(SimpleAccess.TESTTABLE, SimpleAccess.CF_RANGE_pre);
		
//		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c1=new Column(ByteBufferUtil.bytes(SimpleAccess.C_STATE), ByteBufferUtil.bytes(PaxosState.Delivered), System.currentTimeMillis());
		Column c5=new Column(ByteBufferUtil.bytes(SimpleAccess.C_CHOSENVALUE), ByteBufferUtil.bytes("ddfdf"), System.currentTimeMillis());	
//		sc.addColumn(c1);
//		sc.addColumn(c5);
		cf.addColumn(c1);
		cf.addColumn(c5);
		
		rm.add(cf);
		System.out.println(rm);
		
		RowMutation rm2 = new RowMutation(SimpleAccess.TESTTABLE, dk.key);
		ColumnFamily cf2 = ColumnFamily.create(SimpleAccess.TESTTABLE, SimpleAccess.CF_RANGE_pre);
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SimpleAccess.SC_INSTANCE_pre), BytesType.instance);
		sc.addColumn(c1);
		sc.addColumn(c5);
		cf2.addColumn(sc);
		rm2.add(cf2);
		System.out.println(rm2);
	}
	
	public static void testInstanceManager(){
		String tableName = SimpleAccess.TESTTABLE;
		Range range = StorageService.instance.getLocalPrimaryRange();
		long instanceNum = 3;
		System.out.println("tryNewInstance : " + PaxosInstanceManager.tryNewInstance(tableName, range, instanceNum));
		System.out.println("tryNewInstance : " + PaxosInstanceManager.tryNewInstance(tableName, range, instanceNum));
		PaxosInstance instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		System.out.println(instance);
		PaxosInstanceManager.promiseInstance(tableName, range, instanceNum, 3);
		System.out.println(instance);
		PaxosInstanceManager.acceptInstance(tableName, range, instanceNum, 5, new StringPaxosValue("first"));
		System.out.println(instance);
		PaxosInstanceManager.promiseInstance(tableName, range, instanceNum, 3);
		System.out.println(instance);
		PaxosInstanceManager.promiseInstance(tableName, range, instanceNum, 6);
		System.out.println(instance);
		PaxosInstanceManager.acceptInstance(tableName, range, instanceNum, 5, new StringPaxosValue("second"));
		System.out.println(instance);
		PaxosInstanceManager.acceptInstance(tableName, range, instanceNum, 8, new StringPaxosValue("third"));
		System.out.println(instance);
		instance = PaxosInstanceManager.getInstance(tableName, range, instanceNum);
		System.out.println(instance);
	}
	
	public static void testActorManager(){
		String tableName = SimpleAccess.TABLE;
		ByteBuffer key = ByteBufferUtil.bytes("testInsertInstanceKey");
		System.out.println(ReplicationManager.instance().checkRange(tableName, key));
		for (HashMap<Range, StaticReplication> staticReplicationMap : ReplicationManager.instance().staticReplication.values()){
			for (StaticReplication staticReplication : staticReplicationMap.values()){
				staticReplication.getActorRole().print();
			}
		}
		System.out.println("isAcceptor? " + ReplicationManager.instance().isAcceptor(tableName, key));
		ReplicationManager.instance().setAcceptor(tableName, key);
		System.out.println("isAcceptor? " + ReplicationManager.instance().isAcceptor(tableName, key));
	}
	
	public static void test_getInstance() {
		for (int i=5;i<6;i++){
			org.apache.cassandra.db.SuperColumn sc =SimpleAccess.getSuperColumn(SimpleAccess.TABLE, "testInsertInstanceKey",
					SimpleAccess.CF_RANGE_pre, SimpleAccess.SC_INSTANCE_pre+i);
			if (sc == null) continue;
			Collection<IColumn> columns = sc.getSortedColumns();
			ArrayList<IColumn> cs = new ArrayList(columns);
			for (int j=0;j<cs.size();j++){ 
				org.apache.cassandra.db.Column c = (org.apache.cassandra.db.Column)(cs.get(0));
				ByteBuffer name = c.name();
				System.out.println("value of " + ByteBufferUtil.bytesToHex(name) + " = " + ByteBufferUtil.bytesToHex(c.value()));
				try {
					System.out.println("value of " + ByteBufferUtil.string(name) + " = " + StringPaxosValue.fromBytes(c.value().array()).getValue());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void test_internal_get() {
		for (int i = 5; i < 10; i++) {
			org.apache.cassandra.db.SuperColumn sc;
			try {
				sc = SimpleAccess.internal_get(
						SimpleAccess.TABLE,
						"testInsertInstanceKey",
						SimpleAccess.CF_RANGE_pre, 
						SimpleAccess.SC_INSTANCE_pre+i,
						ConsistencyLevel.ONE);
				if (sc == null) continue;
				Collection<IColumn> columns = sc.getSortedColumns();
				ArrayList<IColumn> cs = new ArrayList<IColumn>(columns);
				for (int j=0;j<cs.size();j++){ 
					org.apache.cassandra.db.Column c = (org.apache.cassandra.db.Column)(cs.get(0));
					ByteBuffer name = c.name();
					try {
						System.out.println("value of " + ByteBufferUtil.string(name) + " = " + StringPaxosValue.fromBytes(c.value().array()).getValue());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (CharacterCodingException e) {
				e.printStackTrace();
			} catch (InvalidRequestException e) {
				e.printStackTrace();
			} catch (NotFoundException e) {
				e.printStackTrace();
			} catch (UnavailableException e) {
				e.printStackTrace();
			} catch (TimedOutException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void tryGetLocal() {
		org.apache.cassandra.db.SuperColumn sc;
		String columnName = SimpleAccess.SC_INSTANCE_pre + 5;		
		ByteBuffer scName = ByteBufferUtil.bytes(SimpleAccess.SC_INSTANCE_pre + 5);

		Table table = Table.open(SimpleAccess.TABLE);
		Row r0 = null;
		try {
			r0 = table.getRow(
					QueryFilter.getNamesFilter(
							Util.dk("testInsertInstanceKey"), 
							new QueryPath(SimpleAccess.CF_RANGE_pre), 
							ByteBufferUtil.bytes(columnName)));
			sc = (SuperColumn) r0.cf.getColumn(scName);
			
			Collection<IColumn> columns = sc.getSortedColumns();
			ArrayList<IColumn> cs = new ArrayList<IColumn>(columns);
			for (int j=0;j<cs.size();j++){ 
				org.apache.cassandra.db.Column c = (org.apache.cassandra.db.Column)(cs.get(j));
				ByteBuffer name = c.name();
				ByteBuffer value = c.value();//以instance写入的value不能直接转成字符，要用字节流转一下
					
				System.out.println("value of " + ByteBufferUtil.bytesToHex(name) + " = " + ByteBufferUtil.bytesToHex(value));
				System.out.println("value of " + ByteBufferUtil.string(name) + " = " + StringPaxosValue.fromBytes(value.array())
						.getValue());
				
			}

			System.out.println(r0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tryInsertLocal2() {
		DecoratedKey dk = Util.dk("key0");
		RowMutation rm = new RowMutation("Keyspace1", dk.key);
		ColumnFamily cf = ColumnFamily.create("Keyspace1", "Standard1");
		cf.addColumn(column("col1", "val1", 1L));
		cf.addColumn(column("col2", "val2", 1L));
		cf.addColumn(column("col3", "val3", 1L));

		rm.add(cf);
		try {
			rm.apply();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tryInsertLocal() {
		DecoratedKey dk = Util.dk("key0");
		CFMetaData newCf = new CFMetaData("instanceSlot", "Slot",
				ColumnFamilyType.Standard, UTF8Type.instance, null);
		RowMutation rm = new RowMutation(newCf.ksName, dk.key);
		rm.add(new QueryPath(newCf.cfName, null, ByteBufferUtil.bytes("col0")),
				ByteBufferUtil.bytes("value0"), 1L);
		try {
			rm.apply();
			System.out.println("insert local");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ColumnFamilyStore store = Table.open(newCf.ksName)
				.getColumnFamilyStore(newCf.cfName);
		assert store != null;
		try {
			store.forceBlockingFlush();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				dk, new QueryPath(newCf.cfName), ByteBufferUtil.bytes("col0")));
		if (cfam.getColumn(ByteBufferUtil.bytes("col0")) != null) {
			IColumn col = cfam.getColumn(ByteBufferUtil.bytes("col0"));
			if (ByteBufferUtil.bytes("value0").equals(col.value()))
				System.out.println("get value:"
						+ UTF8Type.instance.getString(col.value()));
		}
	}
	
	public static void test_deleteInstance() {
		for (int i = 5; i < 10; i++)
			SimpleAccess.deleteInstance(i);
		
		ColumnFamilyStore store = Table.open(SimpleAccess.TABLE).getColumnFamilyStore(
				SimpleAccess.CF_RANGE_pre);
		long insNum = 5;
		String column = SimpleAccess.COLUMNPREFIX + insNum;
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(Util
				.dk("testInsertInstanceKey"), new QueryPath(
				SimpleAccess.CF_RANGE_pre), ByteBufferUtil.bytes(column)));
		if (cfam.getColumn(ByteBufferUtil.bytes(column)) == null) {
			System.out.println("value deleted");
		} else {
			IColumn col = cfam.getColumn(ByteBufferUtil.bytes(column));
			try {
				System.out.println(col.value());
				System.out.println(col.value().array());
				System.out.println(ByteBufferUtil.bytesToHex(col.value()));
				System.out.println("get value:"
						+ StringPaxosValue.fromBytes(col.value().array())
								.getValue());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void other(){
		//testActorManager;
//		testActorManager();
//		testRowMutation();
//		testSliceQuery();
		
		// test insert local
//		long insNum = 5;
//		for (int i=5;i<10;i++)
//			SimpleAccess.insertInstance(i, new StringPaxosValue(
//				"testInsertInstance"+i));
		
		//test_getInstance();
		//test_internal_get();
		//testInstanceManager();
		
		// test get
//		ColumnFamilyStore store = Table.open(SimpleAccess.TABLE)
//				.getColumnFamilyStore(SimpleAccess.CF_RANGE_pre);
//		assert store != null;
//		try {
//			store.forceBlockingFlush();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		String column = SimpleAccess.SC_INSTANCE_pre+insNum ;
//		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
//				Util.dk("testInsertInstanceKey"), new QueryPath(
//						SimpleAccess.CF_RANGE_pre), ByteBufferUtil
//						.bytes(column)));
//		if (cfam != null && cfam.getColumn(ByteBufferUtil.bytes(column)) != null) {
//			IColumn col = cfam.getColumn(ByteBufferUtil.bytes(column));
//			try {
//				if (col instanceof org.apache.cassandra.db.SuperColumn){
//					org.apache.cassandra.db.SuperColumn sc = (org.apache.cassandra.db.SuperColumn) col;
//					org.apache.cassandra.db.IColumn c=sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.COLUMNPREFIX));
//					System.out.println(c.value());
//					System.out.println(c.value().array());
//					System.out.println(ByteBufferUtil.bytesToHex(c.value()));
//					if (!col.isMarkedForDelete())
//						System.out.println("get value:"
//								+ StringPaxosValue.fromBytes(c.value().array())
//										.getValue());
//					else
//						System.out.println("this column is marked for delete");
//				}
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		//test deleteInstance
//		for (int i=5;i<10;i++)
//		 SimpleAccess.deleteInstance(i);
		// store = Table.open(SimpleWriter.TABLE).getColumnFamilyStore(
		// SimpleWriter.COLUMNFAMILY);
		// column = SimpleWriter.COLUMNPREFIX + insNum;
		// cfam = store.getColumnFamily(QueryFilter.getNamesFilter(Util
		// .dk("testInsertInstanceKey"), new QueryPath(
		// SimpleWriter.COLUMNFAMILY), ByteBufferUtil.bytes(column)));
		// if (cfam.getColumn(ByteBufferUtil.bytes(column)) == null) {
		// System.out.println("value deleted");
		// }else{
		// IColumn col = cfam.getColumn(ByteBufferUtil.bytes(column));
		// try {
		// System.out.println(col.value());
		// System.out.println(col.value().array());
		// System.out.println(ByteBufferUtil.bytesToHex(col.value()));
		// System.out.println("get value:"
		// + StringPaxosValue.fromBytes(col.value().array())
		// .getValue());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// tryInsertLocal();

		// try {
		// usingThriftClient();
		// } catch (InvalidRequestException e) {
		// e.printStackTrace();
		// } catch (TException e) {
		// e.printStackTrace();
		// } catch (UnavailableException e) {
		// e.printStackTrace();
		// } catch (TimedOutException e) {
		// e.printStackTrace();
		// } catch (NotFoundException e) {
		// e.printStackTrace();
		// }
	}

	public static void usingThriftClient() throws InvalidRequestException,
			TException, UnavailableException, TimedOutException,
			NotFoundException {
		TSocket socket = new TSocket(FBUtilities.getLocalAddress()
				.getHostName(), 9160);
		System.out.println(" connected to "
				+ FBUtilities.getLocalAddress().getHostName() + ":" + 9160
				+ ".");
		TBinaryProtocol binaryProtocol = new TBinaryProtocol(
				new TFramedTransport(socket));
		Cassandra.Client cassandraClient = new Cassandra.Client(binaryProtocol);
		socket.open();

		int minRow;
		int maxRow;
		String rowPrefix, keyspace = "instanceSlot";

		minRow = 1;
		maxRow = 10;
		rowPrefix = "";

		// TestRingCache tester = new TestRingCache(keyspace);

		for (int nRows = minRow; nRows < maxRow; nRows++) {
			ByteBuffer row = ByteBufferUtil.bytes((rowPrefix + nRows));
			ColumnPath col = new ColumnPath("InstanceSlot").setSuper_column(
					(ByteBuffer) null).setColumn("col1".getBytes());
			ColumnParent parent = new ColumnParent("InstanceSlot")
					.setSuper_column((ByteBuffer) null);

			// Collection<InetAddress> endpoints =
			// tester.ringCache.getEndpoint(row);
			// InetAddress firstEndpoint = endpoints.iterator().next();
			// System.out.printf("hosts with key %s : %s; choose %s%n",
			// new String(row.array()), StringUtils.join(endpoints, ","),
			// firstEndpoint);

			// now, read the row back directly from the host owning the row
			// locally
			// tester.setup(firstEndpoint.getHostAddress(),
			// DatabaseDescriptor.getRpcPort());
			cassandraClient.set_keyspace(keyspace);
			// KsDef ksdef = cassandraClient.describe_keyspace(keyspace);
			// System.out.println(ksdef);
			
			cassandraClient.insert(
					row,
					parent,
					new org.apache.cassandra.thrift.Column(ByteBufferUtil.bytes("col1")).setValue(
							ByteBufferUtil.bytes("val1")).setTimestamp(1),
					ConsistencyLevel.ONE);
			org.apache.cassandra.thrift.Column column = cassandraClient.get(row, col, ConsistencyLevel.ONE).column;
			System.out
					.println("read row " + new String(row.array()) + " "
							+ new String(column.name.array()) + ":"
							+ new String(column.value.array()) + ":"
							+ column.timestamp);
		}
		socket.close();
	}

	public static void main___(String[] args) {
		try {
			doPatch();
			// Enumeration<NetworkInterface> netInterfaces = null;
			// netInterfaces = NetworkInterface.getNetworkInterfaces();
			// Enumeration<InetAddress> ips;
			// while (netInterfaces.hasMoreElements()) {
			// NetworkInterface ni = netInterfaces.nextElement();
			// //System.out.println("DisplayName:" + ni.getDisplayName());
			// //System.out.println("Name:" + ni.getName());
			// ips = ni.getInetAddresses();
			// while (ips.hasMoreElements()) {
			// // System.out.println("IP:" +
			// ips.nextElement().getHostAddress());
			//
			// String toaddress = new String("115.156.232.48");
			// String ip = ips.nextElement().getHostAddress();
			// if (ip.equals(toaddress)) {
			// System.out.println("hostaddress=" + ip);
			// }
			// }
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
