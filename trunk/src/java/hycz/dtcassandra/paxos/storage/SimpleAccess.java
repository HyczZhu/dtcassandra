package hycz.dtcassandra.paxos.storage;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.MultiRMPaxosValue;
import hycz.dtcassandra.paxos.PaxosInstance;
import hycz.dtcassandra.paxos.PaxosState;
import hycz.dtcassandra.paxos.PaxosValueFactory;
import hycz.dtcassandra.paxos.StringPaxosValue;
import hycz.dtcassandra.paxos.message.IPaxosMessage;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.apache.cassandra.Util;
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
import org.apache.cassandra.db.ReadResponse;
import org.apache.cassandra.db.ReadVerbHandler;
import org.apache.cassandra.db.Row;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.SliceByNamesReadCommand;
import org.apache.cassandra.db.SliceFromReadCommand;
import org.apache.cassandra.db.SuperColumn;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.db.filter.QueryFilter;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.marshal.BytesType;
import org.apache.cassandra.db.migration.AddColumnFamily;
import org.apache.cassandra.db.migration.AddKeyspace;
import org.apache.cassandra.db.migration.Migration;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.gms.Gossiper;
import org.apache.cassandra.locator.LocalStrategy;
import org.apache.cassandra.locator.SimpleStrategy;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.DigestMismatchException;
import org.apache.cassandra.service.ReadCallback;
import org.apache.cassandra.service.RepairCallback;
import org.apache.cassandra.service.RowDigestResolver;
import org.apache.cassandra.service.RowRepairResolver;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.NotFoundException;
import org.apache.cassandra.thrift.TimedOutException;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.WrappedRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleAccess {
	private static Logger logger = LoggerFactory.getLogger(SimpleAccess.class);

	public final static String TABLE = "instanceSlot";
	public final static String CF_RANGE_pre = "range";
	public final static String SC_CURRENT = "current";
	public final static String C_CRT_INSTANCENUM = "instanceNum";
	public final static String C_CRT_TIMESTAMP = "timestamp";
	public final static String C_CRT_COMMIT = "commitNum";
	public final static String C_CRT_APPLY = "applyNum";
	public final static String C_CRT_ACCEPTED = "acceptedNum";
	public final static String C_MIN_INSTANCENUM = "minInstanceNum";
	public final static String SC_INSTANCE_pre = "instance";
	public final static String C_STATE = "state";
	public final static String C_PROPOSALNUM = "proposalNum";
	public final static String C_ACCEPTEDVALUE = "acceptedValue";
	public final static String C_CHOSENVALUE = "chosenValue";
	public final static String C_VALUETYPE = "valueType";
	public final static String C_TIMESTAMP = "timestamp";
	@Deprecated
	public final static String COLUMNPREFIX = "Instance";
	public final static String TESTTABLE = "TestTable";
	
	public final static int version = Gossiper.instance.getVersion(FBUtilities.getLocalAddress());
	
	static {
		tryAddPaxosUtilKeyspace();
//		tryAddNewColumnFamily();
//		tryAddTestKeyspace();
	}
	
	public static PaxosInstance getInstance(String tableName, Range range, long instanceNumber){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
//		TreeSet<ByteBuffer> scs = new TreeSet<ByteBuffer>();
//		scs.add(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber));
//		scs.add(ByteBufferUtil.bytes(SC_CURRENT));

		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber)));
		if (cfam == null) return null;
//		cfam = cfam.cloneMe();
		IColumn col=null;
//		long timestamp = -1L;
//		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null){
//			if (col instanceof SuperColumn) {
//				SuperColumn sc = (SuperColumn) col;
//				//get timestamp of this instance
//				IColumn c_timestamp = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_TIMESTAMP));
//				c_timestamp.value().position(0);
//				timestamp = c_timestamp.value().getLong();
//				c_timestamp.value().position(0);
//			}
//		}
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					//for test
//						IColumn c = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.COLUMNPREFIX));
//						System.out.println("get value:" + StringPaxosValue.fromBytes(c.value().array()).getValue());
//						return (SuperColumn)col;
					//get proposal num
					IColumn c_proposalNum = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_PROPOSALNUM));
					long proposalNum = ByteBufferUtil.toLong(c_proposalNum.value());
//					c_proposalNum.value().position(0);
					
					//get paxos value
					IPaxosValue value = null;
					IColumn c_valuetype = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_VALUETYPE));
					IColumn c_value = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_ACCEPTEDVALUE));
					if (c_valuetype != null && c_value != null){
//						try {
//							System.out.println();
//							System.out.println(MultiRMPaxosValue.fromBytes(c_value.value().array(), version).getValue());
//							System.out.println(new String(c_valuetype.value().array()));
//							System.out.println();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
						value = PaxosValueFactory.getPaxosValue(
								c_value.value().array(), 
								new String(c_valuetype.value().array()));
					}
					//get state
					String state = null;
					IColumn c_state = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_STATE));
					try {
						state = ByteBufferUtil.string(c_state.value());
					} catch (CharacterCodingException e) {
						e.printStackTrace();
					}
					if (PaxosState.Delivered.equals(state) || PaxosState.Applied.equals(state)){
						//get chosen value
						IPaxosValue chosenValue = null;
						IColumn c_chosenValue = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CHOSENVALUE));
						if (c_valuetype != null && c_chosenValue != null){
							chosenValue = PaxosValueFactory.getPaxosValue(
									c_chosenValue.value().array(), 
									new String(c_valuetype.value().array()));
						}
						return new PaxosInstance(instanceNumber, proposalNum, value, state, chosenValue);
					}
					else{
						return new PaxosInstance(instanceNumber, proposalNum, value, state);
					}
					
				}
				else{
					System.out.println("getInstance: this column is marked for delete");
					System.out.println("trying to get instance " + instanceNumber+", while the min instanceNum = "+ getMinInstanceNum(tableName, range));
					return null;
				}					
			}
			else return null;
		}
		return null;
	}
	
	
	
	public static void newInstance(String tableName, Range range, long instanceNumber) {
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		ByteBuffer state = ByteBufferUtil.bytes(PaxosState.Pending);
		ByteBuffer proposalNum = ByteBufferUtil.bytes(new Long(-1).longValue());
		// set default value type to 
		ByteBuffer valueType = ByteBufferUtil.bytes(PaxosValueFactory.VALUETYPE_MULTIRM);
		
//		long timestamp = System.currentTimeMillis();
//		while (timestamp < getCurrentInstanceTimestamp(tableName, range)){
//			++timestamp;
//		}
//		ByteBuffer timestamp_bytes = ByteBufferUtil.bytes(-1L);
		
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), state, System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), proposalNum, System.currentTimeMillis());
//		Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), value, System.currentTimeMillis());
		Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), valueType, System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c1);
		sc.addColumn(c2);
		sc.addColumn(c4);
		cf.addColumn(sc);
//		Column c6=new Column(ByteBufferUtil.bytes(C_TIMESTAMP), timestamp_bytes, System.currentTimeMillis());
//		SuperColumn sc2=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
//		sc2.addColumn(c6);
//		cf.addColumn(sc2);

		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
		
		// 3, update current instance num
		setCurrentInstanceNum(tableName, range, instanceNumber);
	}
	
	public static void deleteInstance(String tableName, Range range, long instanceNumber) {
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		QueryPath path = new QueryPath(CF_RANGE_pre+range, ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), null);

		rm.delete(path, System.currentTimeMillis());

		// 2, apply it
		applyRM(rm);
	}
	
	public static void updateState(String tableName, Range range, long instanceNumber, String state){
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(state), System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c1);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static void updateProposalNum(String tableName, Range range, long instanceNumber, long proposalNum){
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c2);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	@Deprecated
	public static void updateValue(String tableName, Range range, long instanceNumber, long proposalNum, IPaxosValue value){
		if (value == null) return;
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		ByteBuffer valueType = ByteBufferUtil.bytes(PaxosValueFactory.getValueType(value));
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());
		Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), valueType, System.currentTimeMillis());
		sc.addColumn(c2);
		sc.addColumn(c3);
		sc.addColumn(c4);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	/***
	 * accept a value, and change the instance state to Accepted
	 * @param tableName
	 * @param range
	 * @param instanceNumber
	 * @param proposalNum
	 * @param value
	 */
	public static void acceptValue(String tableName, Range range, long instanceNumber, long proposalNum, IPaxosValue value){
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		ByteBuffer valueType = ByteBufferUtil.bytes(PaxosValueFactory.getValueType(value));
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(PaxosState.Accepted), System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		sc.addColumn(c1);
		sc.addColumn(c2);
		if (value != null){
			Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());
			Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), valueType, System.currentTimeMillis());
			sc.addColumn(c3);
			sc.addColumn(c4);
		}
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	/***
	 * deliver an no-op value, and change the instance state to Hole
	 * @param tableName
	 * @param range
	 * @param instanceNumber
	 */
	public static void deliverNoOpValue(String tableName, Range range, long instanceNumber){
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(PaxosState.Hole), System.currentTimeMillis());
		
		sc.addColumn(c1);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	/***
	 * deliver a value, and change the instance state to Delivered
	 * @param tableName
	 * @param range
	 * @param instanceNumber
	 * @param value
	 */
	public static void deliverValue(String tableName, Range range, long instanceNumber, IPaxosValue value){
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(PaxosState.Delivered), System.currentTimeMillis());
		Column c5=new Column(ByteBufferUtil.bytes(C_CHOSENVALUE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());	
		sc.addColumn(c1);
		sc.addColumn(c5);
		cf.addColumn(sc);
		
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
		
	}
	
	//一些本地副本公共值
	//1, 当前instance num
	//2, 当前instance timestamp
	//3, 当前最大已commit的instance num
	//4, 当前最大已apply的instance num
	//5, 当前最大已accept的instance num
	//6, 当前存在的最小instance num
	public static long getCurrentInstanceNum(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CRT_INSTANCENUM));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getCurrentInstanceNum: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}
	public static void setCurrentInstanceNum(String tableName, Range range, long instanceNumber){
		long existed = getCurrentInstanceNum(tableName, range);
		if (existed >= instanceNumber)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CRT_INSTANCENUM), ByteBufferUtil.bytes(instanceNumber), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static long getCurrentInstanceTimestamp(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CRT_TIMESTAMP));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getCurrentInstanceTimestamp: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}	
	public static void setCurrentInstanceTimestamp(String tableName, Range range, long timestamp){
		long existed = getCurrentInstanceTimestamp(tableName, range);
		if (existed >= timestamp)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CRT_TIMESTAMP), ByteBufferUtil.bytes(timestamp), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static long getCurrentCommitNum(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CRT_COMMIT));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getCurrentCommitNum: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}
	public static void setCurrentCommitNum(String tableName, Range range, long commitNum){
		long existed = getCurrentCommitNum(tableName, range);
		if (existed >= commitNum)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CRT_COMMIT), ByteBufferUtil.bytes(commitNum), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static long getCurrentApplyNum(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CRT_APPLY));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}
						catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getCurrentApplyNum: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}
	/***
	 * apply num can only be called when read recover
	 * @param tableName
	 * @param range
	 * @param applyNumber
	 */
	public static void setCurrentApplyNum(String tableName, Range range, long applyNumber){
		long existed = getCurrentApplyNum(tableName, range);
		if (existed >= applyNumber)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CRT_APPLY), ByteBufferUtil.bytes(applyNumber), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static long getCurrentAcceptedNum(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CRT_ACCEPTED));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getCurrentAcceptedNum: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}
	public static void setCurrentAcceptedNum(String tableName, Range range, long instanceNumber){
		long existed = getCurrentAcceptedNum(tableName, range);
		if (existed >= instanceNumber)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CRT_ACCEPTED), ByteBufferUtil.bytes(instanceNumber), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static long getMinInstanceNum(String tableName, Range range){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_CURRENT)));
		if (cfam == null) return -1;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_CURRENT))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_MIN_INSTANCENUM));
					if (c_current != null){
						try{
							return ByteBufferUtil.toLong(c_current.value());
						}catch(Exception e){
							return -1;
						}
					}
					return -1;
				}
				else{
					System.out.println("getMinInstanceNum: this column is marked for delete");
					return -1;
				}					
			}
			else return -1;
		}
		return -1;
	}
	public static void setMinInstanceNum(String tableName, Range range, long instanceNumber){
		long existed = getMinInstanceNum(tableName, range);
		if (existed >= instanceNumber)
			return;
		
		// 1, make a rowmutation
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_MIN_INSTANCENUM), ByteBufferUtil.bytes(instanceNumber), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	//for witness hint
	public static RowMutation getHintRM_updateProposalNum(String tableName, Range range, long instanceNumber){
		// 1, get whole super column for a instance
		DecoratedKey<?> dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cf = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber)));
		if (cf == null) return null;
		// 2, add it to an empty rm
		rm.add(cf);
		return rm;
	}
	
//	/**
//	 * 
//	 * @param tableName
//	 * @param instanceNumber
//	 * @return -1 if success, 0 or positive long if already promised to a proposal num
//	 */
//	//TODO state support
//	//TODO concurrent support
//	public static long tryUpdateProposalNum(String tableName, long instanceNumber, long proposalNum){
//		assert proposalNum >= 0;
//		SuperColumn result = getInstance(tableName, instanceNumber);
//		// new instance
//		if (result == null) {
//			updateInstance(tableName, instanceNumber, PaxosState.P1Pending, proposalNum, null);
//			return -1;
//		}
//		// instance is created
//		else {
//			IColumn p = result.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_PROPOSALNUM));
//			// this column should exist
//			if (p == null){
//				updateInstance(tableName, instanceNumber, PaxosState.P1Pending, proposalNum, null);
//			}
//			else {
//				long promisedNum = p.value().getLong();
//				IColumn v = result.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_ACCEPTEDVALUE));
//				if (v == null) {
//					if (promisedNum < proposalNum){
//						updateInstance(tableName, instanceNumber, PaxosState.P1Pending, proposalNum, null);
//						return -1;
//					}
//					else{
//						return promisedNum;
//					}
//				}
//			}
//		}
//	}
	
	@Deprecated
	private static void updateInstance(String tableName, long instanceNumber,
			String state, long proposalNum){
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre);
		
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(state), System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c1);
		sc.addColumn(c2);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	@Deprecated
	private static void updateInstance(String tableName, long instanceNumber,
			String state, long proposalNum, IPaxosValue value){
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre);
		
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(state), System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c1);
		sc.addColumn(c2);

		if (value != null){
			Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());
			sc.addColumn(c3);
			if (value instanceof StringPaxosValue){
				Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());
				sc.addColumn(c4);
			}
		}
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static SuperColumn getSuperColumn(String keyspace, String key,
			String columnfamily, String supercolumn) {
		System.out.println(Util.dk(key));
		
		ColumnFamilyStore store = Table.open(keyspace).getColumnFamilyStore(
				columnfamily);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(key), new QueryPath(columnfamily),
				ByteBufferUtil.bytes(supercolumn)));
		if (cfam == null) return null;
		IColumn col=null;
		if (cfam.getColumn(ByteBufferUtil.bytes(supercolumn)) != null) {
			col = cfam.getColumn(ByteBufferUtil.bytes(supercolumn));
			try {
				if (col instanceof SuperColumn) {
					SuperColumn sc = (SuperColumn) col;
					IColumn c = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.COLUMNPREFIX));
//					System.out.println(c.value());
//					System.out.println(c.value().array());
//					System.out.println(ByteBufferUtil.bytesToHex(c.value()));
					if (!col.isMarkedForDelete())
						System.out.println("get value:"
								+ StringPaxosValue.fromBytes(c.value().array())
										.getValue());
					else
						System.out.println("this column is marked for delete");
					return (SuperColumn)col;
				}
				else return null;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (SuperColumn) col;
	}
	
	public static SuperColumn internal_get(String keyspace, String key,
			String columnFamilyName, String superColumnName, ConsistencyLevel consistency_level)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException, CharacterCodingException {
		Table table = Table.open(keyspace);
		Row r0 = null;
		try {
			r0 = table.getRow(QueryFilter.getNamesFilter(
					Util.dk(key),
					new QueryPath(columnFamilyName), 
					ByteBufferUtil.bytes(superColumnName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(r0);
		
		SuperColumn sc = null;
		if (r0.cf.getColumnCount() > 0)
			sc = (SuperColumn) r0.cf.getColumn(ByteBufferUtil.bytes(superColumnName));
		return sc;
		
		// do read
//		Map<DecoratedKey, ColumnFamily> cfamilies = readColumnFamily(
//				Arrays.asList(command), consistency_level);
//
//		if (cfamilies == null)
//			System.out.println("read result = null");
//		ColumnFamily cf1 = cfamilies.get(key);
//		System.out.println("size = " + cf1.getColumnCount());
//		Iterator<Entry<DecoratedKey, ColumnFamily>> it = cfamilies.entrySet()
//				.iterator();
//		Entry<DecoratedKey, ColumnFamily> e;
//		while ((e = it.next()) != null) {
//			System.out.println(e.getKey() + "  " + e.getValue());
//		}
//		
//
//		// get result
//		ColumnFamily cf = cfamilies.get(StorageService.getPartitioner()
//				.decorateKey(command.key));
//
//		if (cf == null || cf.getColumnsMap().size() == 0)
//			throw new NotFoundException();
//		IColumn sc = cf.getColumn(querypath.superColumnName);
//		if (sc != null && sc instanceof SuperColumn)
//			return (SuperColumn) sc;
//		else
//			return null;
	}

	static class LocalReadRunnable extends WrappedRunnable
    {
        private final ReadCommand command;
        private final ReadCallback<Row> handler;
        private final long start = System.currentTimeMillis();

        LocalReadRunnable(ReadCommand command, ReadCallback<Row> handler)
        {
            this.command = command;
            this.handler = handler;
        }

        protected void runMayThrow() throws IOException
        {
            if (logger.isDebugEnabled())
                logger.debug("LocalReadRunnable reading " + command);

            Table table = Table.open(command.table);
            ReadResponse result = ReadVerbHandler.getResponse(command, command.getRow(table));
            MessagingService.instance().addLatency(FBUtilities.getLocalAddress(), System.currentTimeMillis() - start);
            handler.response(result);
        }
    }
	
	public static Map<DecoratedKey, ColumnFamily> readColumnFamily(
			List<ReadCommand> commands, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		// TODO - Support multiple column families per row, right now row only
		// contains 1 column family
		Map<DecoratedKey, ColumnFamily> columnFamilyKeyMap = new HashMap<DecoratedKey, ColumnFamily>();

		if (consistency_level == ConsistencyLevel.ANY) {
			throw new InvalidRequestException(
					"Consistency level any may not be applied to read operations");
		}

		List<Row> rows;
		try {
			rows = StorageProxy.read(commands, consistency_level);
		} catch (TimeoutException e) {
			throw new TimedOutException();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (Row row : rows) {
			System.out.println(row.key);
			System.out.println(row.cf.getColumnNames().size());
			columnFamilyKeyMap.put(row.key, row.cf);
		}
		return columnFamilyKeyMap;
	}
//	

	public static void insertInstance(long instanceNumber,
			IPaxosValue paxosValue) {
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk("testInsertInstanceKey");
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre);

		byte[] b = paxosValue.toBytes();
		ByteBuffer bb = ByteBuffer.wrap(b);
		ByteBuffer state = ByteBufferUtil.bytes("begin");
		ByteBuffer proposalNum = ByteBufferUtil.bytes(-1L);
		Column c0=new Column(ByteBufferUtil.bytes(COLUMNPREFIX), bb, System.currentTimeMillis());
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), state, System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), proposalNum, System.currentTimeMillis());
//		Column c2=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), bb, System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c0);
		sc.addColumn(c1);
		sc.addColumn(c2);
		cf.addColumn(sc);
//		cf.addColumn(new Column(ByteBufferUtil.bytes(COLUMNPREFIX
//				+ instanceNumber), bb, System.currentTimeMillis()));

		rm.add(cf);
//		showDetails(rm);
		
		// 2, apply it
		applyRM(rm);
	}

	

	public static void deleteInstance(long instanceNumber) {
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk("testInsertInstanceKey");
		RowMutation rm = new RowMutation(TABLE, dk.key);
		QueryPath path = new QueryPath(CF_RANGE_pre, ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber),
				ByteBufferUtil.bytes(COLUMNPREFIX));

		rm.delete(path, 5L);

		// 2, apply it
		try {
			StorageProxy.mutate(Arrays.asList(rm), ConsistencyLevel.ONE);
		} catch (UnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO
	public static RowMutation makeRM(IPaxosMessage m) {
		long instanceNumber = m.getInstanceNumber();
		long proposalNumber = m.getProposalNumber();
		IPaxosValue paxosValue = m.getPaxosValue();
		Range range = paxosValue.getRange();
		String tableName = paxosValue.getTableName();
		
		DecoratedKey dk = Util.dk("testInsertInstanceKey");
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre);

		byte[] b = paxosValue.toBytes();
		ByteBuffer bb = ByteBuffer.wrap(b);
		cf.addColumn(new Column(ByteBufferUtil.bytes(COLUMNPREFIX
				+ instanceNumber), bb, 2L));

		rm.add(cf);
		return rm;
	}

	public static void applyRM(RowMutation rm) {
		try {
			StorageProxy.mutate(Arrays.asList(rm), ConsistencyLevel.ONE);
		} catch (UnavailableException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	 // helper method to apply migration on the migration stage. typical migration failures will throw an 
    // InvalidRequestException. atypical failures will throw a RuntimeException.
    private static void applyMigrationOnStage(final Migration m)
    {
        Future f = StageManager.getStage(Stage.MIGRATION).submit(new Callable()
        {
            public Object call() throws Exception
            {
                m.apply();
                m.announce();
                return null;
            }
        });
        try
        {
            f.get();
        }
        catch (InterruptedException e)
        {
            throw new AssertionError(e);
        }
        catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }
    }

	public static void tryAddPaxosUtilKeyspace() {
		CFMetaData defaultCf = new CFMetaData(TABLE, CF_RANGE_pre,
				ColumnFamilyType.Super, BytesType.instance, null);
		defaultCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
				.mergeShardsChance(0.0);
		KSMetaData newKs = new KSMetaData(defaultCf.ksName, LocalStrategy.class,
				KSMetaData.optsWithRF(1));

		if (DatabaseDescriptor.getTableDefinition(defaultCf.ksName) == null) {
			try {
				new AddKeyspace(newKs).apply();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("Keyspace "+TABLE+" already exists.");
		}
		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
	    	CFMetaData newCf = new CFMetaData(TABLE, CF_RANGE_pre+range,
					ColumnFamilyType.Super, BytesType.instance, null);
			newCf.comment("instance slot for a range").keyCacheSize(1.0).readRepairChance(0.0)
					.mergeShardsChance(0.0);
	
			if (!DatabaseDescriptor.getTableDefinition(newKs.name).cfMetaData()
					.containsKey(newCf.cfName)) {
				try {
					new AddColumnFamily(newCf).apply();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ConfigurationException e) {
					e.printStackTrace();
				}
			} else {
				logger.debug("SuperColumnFamily "+CF_RANGE_pre + range +" already exists.");
			}
		}
		
//		CFMetaData testCf = new CFMetaData(TESTTABLE, CF_RANGE_pre,
//				ColumnFamilyType.Super, BytesType.instance, null);
//		testCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
//				.mergeShardsChance(0.0);
//		KSMetaData testKs = new KSMetaData(testCf.ksName, SimpleStrategy.class,
//				KSMetaData.optsWithRF(1));
//
//		if (DatabaseDescriptor.getTableDefinition(testCf.ksName) == null) {
//			try {
//				new AddKeyspace(testKs).apply();
//			} catch (ConfigurationException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			logger.debug("Keyspace TestTable already exists.");
//		}
	}

	@Deprecated
	public static void tryAddNewColumnFamily() {
		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
	    	CFMetaData newCf = new CFMetaData(TABLE, CF_RANGE_pre+range,
					ColumnFamilyType.Super, BytesType.instance, null);
			newCf.comment("instance slot for a range").keyCacheSize(1.0).readRepairChance(0.0)
					.mergeShardsChance(0.0);
			KSMetaData newKs = new KSMetaData(newCf.ksName, LocalStrategy.class,
					KSMetaData.optsWithRF(1));
	
			if (!DatabaseDescriptor.getTableDefinition(newKs.name).cfMetaData()
					.containsKey(newCf.cfName)) {
				try {
					new AddColumnFamily(newCf).apply();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ConfigurationException e) {
					e.printStackTrace();
				}
			} else {
				logger.debug("SuperColumnFamily "+CF_RANGE_pre + range +" already exists.");
			}
		}
//		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
//	    	CFMetaData newCf = new CFMetaData(TESTTABLE, CF_RANGE_pre+range,
//					ColumnFamilyType.Super, BytesType.instance, null);
//			newCf.comment("instance slot for a range").keyCacheSize(1.0).readRepairChance(0.0)
//					.mergeShardsChance(0.0);
//			KSMetaData newKs = new KSMetaData(newCf.ksName, LocalStrategy.class,
//					KSMetaData.optsWithRF(1));
//	
//			if (!DatabaseDescriptor.getTableDefinition(newKs.name).cfMetaData()
//					.containsKey(newCf.cfName)) {
//				try {
//					new AddColumnFamily(newCf).apply();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (ConfigurationException e) {
//					e.printStackTrace();
//				}
//			} else {
//				logger.debug("SuperColumnFamily "+CF_RANGE_pre + range +" already exists.");
//			}
//		}
//		CFMetaData newCf = new CFMetaData(TABLE, CF_RANGE_pre,
//				ColumnFamilyType.Super, BytesType.instance, null);
//		newCf.comment("instance slot for a range").keyCacheSize(1.0).readRepairChance(0.0)
//				.mergeShardsChance(0.0);
//		KSMetaData newKs = new KSMetaData(newCf.ksName, LocalStrategy.class,
//				KSMetaData.optsWithRF(1));
//
//		if (!DatabaseDescriptor.getTableDefinition(newKs.name).cfMetaData()
//				.containsKey(newCf.cfName)) {
//			try {
//				new AddColumnFamily(newCf).apply();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (ConfigurationException e) {
//				e.printStackTrace();
//			}
//		} else {
//			logger.debug("SuperColumnFamily "+CF_RANGE_pre+" already exists.");
//		}
	}
	
	public static void tryAddTestKeyspace(int replicaFactor) {		
		CFMetaData testCf = new CFMetaData(TESTTABLE, CF_RANGE_pre,
				ColumnFamilyType.Super, BytesType.instance, null);
		testCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
				.mergeShardsChance(0.0);
		
		KSMetaData testKs = new KSMetaData(TESTTABLE, SimpleStrategy.class,
				KSMetaData.optsWithRF(replicaFactor), testCf);

		if (DatabaseDescriptor.getTableDefinition(testCf.ksName) == null) {
			try {
//				new AddKeyspace(testKs).apply();
				applyMigrationOnStage(new AddKeyspace(testKs));
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("Keyspace TestTable already exists.");
		}

		if (!DatabaseDescriptor.getTableDefinition(testKs.name).cfMetaData()
				.containsKey(testCf.cfName)) {
			try {
				new AddColumnFamily(testCf).apply();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("SuperColumnFamily "+CF_RANGE_pre+" already exists.");
		}
	}
	
	private static void showDetails(RowMutation rm) {
		for (ColumnFamily cf : rm.getColumnFamilies()) {
			for (IColumn c : cf.getColumnsMap().values()) {
				System.out.println(c.value());
				System.out.println(ByteBufferUtil.bytesToHex(c.value()));
			}
		}
	}
}


