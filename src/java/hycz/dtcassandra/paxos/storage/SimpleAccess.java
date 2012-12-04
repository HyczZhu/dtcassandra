package hycz.dtcassandra.paxos.storage;

import hycz.dtcassandra.paxos.IPaxosValue;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
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
	public final static String C_CURRENT = "instanceNum";
	public final static String SC_INSTANCE_pre = "instance";
	public final static String C_STATE = "state";
	public final static String C_PROPOSALNUM = "proposalNum";
	public final static String C_ACCEPTEDVALUE = "acceptedValue";
	public final static String C_CHOSENVALUE = "chosenValue";
	public final static String C_VALUETYPE = "valueType";
	@Deprecated
	public final static String COLUMNPREFIX = "Instance";
	public final static String TESTTABLE = "TestTable";
	
	public final static int version = Gossiper.instance.getVersion(FBUtilities.getLocalAddress());
	
	static {
		tryAddNewKeyspace();
		tryAddNewColumnFamily();
		tryAddTestKeyspace();
	}
	
	public static PaxosInstance getInstance(String tableName, Range range, long instanceNumber){
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cfam = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber)));
		if (cfam == null) return null;
//		cfam = cfam.cloneMe();
		IColumn col=null;
		if ((col = cfam.getColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber))) != null) {
			if (col instanceof SuperColumn) {
				SuperColumn sc = (SuperColumn) col;
				
				if (!col.isMarkedForDelete()){
					//for test
//						IColumn c = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.COLUMNPREFIX));
//						System.out.println("get value:" + StringPaxosValue.fromBytes(c.value().array()).getValue());
//						return (SuperColumn)col;
					/////////////
					IColumn c_proposalNum = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_PROPOSALNUM));
					long proposalNum = c_proposalNum.value().getLong();
					c_proposalNum.value().position(0);
					IPaxosValue value = null;
					IColumn c_valuetype = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_VALUETYPE));
					IColumn c_value = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_ACCEPTEDVALUE));
					if (c_valuetype != null && c_value != null){
						value = PaxosValueFactory.getPaxosValue(
								c_value.value().array(), 
								new String(c_valuetype.value().array()));
					}
					
					String state = null;
					IColumn c_state = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_STATE));
					try {
						state = ByteBufferUtil.string(c_state.value());
					} catch (CharacterCodingException e) {
						e.printStackTrace();
					}
					if (state == PaxosState.Delivered){
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
					System.out.println("this column is marked for delete");
					return null;
				}					
			}
			else return null;
		}
		return null;
	}
	
	
	
	public static void newInstance(String tableName, Range range, long instanceNumber) {
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		ByteBuffer state = ByteBufferUtil.bytes(PaxosState.Pending);
		ByteBuffer proposalNum = ByteBufferUtil.bytes(new Long(-1).longValue());
		//TODO more valuetype support
		ByteBuffer valueType = ByteBufferUtil.bytes(PaxosValueFactory.VALUETYPE_ROWMUTATION);
		
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), state, System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), proposalNum, System.currentTimeMillis());
//		Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), value, System.currentTimeMillis());
		Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), valueType, System.currentTimeMillis());
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		sc.addColumn(c1);
		sc.addColumn(c2);
		sc.addColumn(c4);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
		
		// 3, update current instance num
		setCurrentInstanceNum(tableName, range, instanceNumber);
	}
	
	public static void updateState(String tableName, Range range, long instanceNumber, String state){
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
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
		DecoratedKey dk = Util.dk(tableName);
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
	
	public static void updateValue(String tableName, Range range, long instanceNumber, long proposalNum, IPaxosValue value){
		if (value == null) return;
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
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
	
	public static void closeWithValue(String tableName, Range range, long instanceNumber, long proposalNum, IPaxosValue value){
		if (value == null) return;
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		ByteBuffer valueType = ByteBufferUtil.bytes(PaxosValueFactory.getValueType(value));
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber), BytesType.instance);
		Column c1=new Column(ByteBufferUtil.bytes(C_STATE), ByteBufferUtil.bytes(PaxosState.Closed), System.currentTimeMillis());
		Column c2=new Column(ByteBufferUtil.bytes(C_PROPOSALNUM), ByteBufferUtil.bytes(proposalNum), System.currentTimeMillis());
		Column c3=new Column(ByteBufferUtil.bytes(C_ACCEPTEDVALUE), ByteBuffer.wrap(value.toBytes()), System.currentTimeMillis());
		Column c4=new Column(ByteBufferUtil.bytes(C_VALUETYPE), valueType, System.currentTimeMillis());
		sc.addColumn(c1);
		sc.addColumn(c2);
		sc.addColumn(c3);
		sc.addColumn(c4);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	public static void deliverNoOpValue(String tableName, Range range, long instanceNumber){
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
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
	
	public static void deliverValue(String tableName, Range range, long instanceNumber, IPaxosValue value){
		// 1, make a rowmutation
		DecoratedKey dk = Util.dk(tableName);
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
					IColumn c_current = sc.getSubColumn(ByteBufferUtil.bytes(SimpleAccess.C_CURRENT));
					if (c_current != null){
						return c_current.value().getLong();
					}
					return -1;
				}
				else{
					System.out.println("this column is marked for delete");
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
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamily cf = ColumnFamily.create(TABLE, CF_RANGE_pre+range);
		
		SuperColumn sc=new SuperColumn(ByteBufferUtil.bytes(SC_CURRENT), BytesType.instance);
		Column c=new Column(ByteBufferUtil.bytes(C_CURRENT), ByteBufferUtil.bytes(instanceNumber), System.currentTimeMillis());
		sc.addColumn(c);
		cf.addColumn(sc);
		rm.add(cf);
		
		// 2, apply it
		applyRM(rm);
	}
	
	//for witness hint
	public static RowMutation getHintRM_updateProposalNum(String tableName, Range range, long instanceNumber){
		DecoratedKey dk = Util.dk(tableName);
		RowMutation rm = new RowMutation(TABLE, dk.key);
		ColumnFamilyStore store = Table.open(TABLE).getColumnFamilyStore(
				CF_RANGE_pre+range);
		ColumnFamily cf = store.getColumnFamily(QueryFilter.getNamesFilter(
				Util.dk(tableName), new QueryPath(CF_RANGE_pre+range),
				ByteBufferUtil.bytes(SC_INSTANCE_pre+instanceNumber)));
		if (cf == null) return null;
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

	public static void tryAddNewKeyspace() {
		CFMetaData newCf = new CFMetaData(TABLE, CF_RANGE_pre,
				ColumnFamilyType.Super, BytesType.instance, null);
		newCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
				.mergeShardsChance(0.0);
		KSMetaData newKs = new KSMetaData(newCf.ksName, LocalStrategy.class,
				KSMetaData.optsWithRF(1));

		if (DatabaseDescriptor.getTableDefinition(newCf.ksName) == null) {
			try {
				new AddKeyspace(newKs).apply();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			logger.debug("Keyspace "+TABLE+" already exists.");
		}
		
		CFMetaData testCf = new CFMetaData(TESTTABLE, CF_RANGE_pre,
				ColumnFamilyType.Super, BytesType.instance, null);
		testCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
				.mergeShardsChance(0.0);
		KSMetaData testKs = new KSMetaData(testCf.ksName, SimpleStrategy.class,
				KSMetaData.optsWithRF(1));

		if (DatabaseDescriptor.getTableDefinition(testCf.ksName) == null) {
			try {
				new AddKeyspace(testKs).apply();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			logger.debug("Keyspace TestTable already exists.");
		}
	}

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				logger.debug("SuperColumnFamily "+CF_RANGE_pre + range +" already exists.");
			}
		}
		for (Range range : StorageService.instance.getAllRanges(StorageService.instance.getTokenMetadata().sortedTokens())){
	    	CFMetaData newCf = new CFMetaData(TESTTABLE, CF_RANGE_pre+range,
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				logger.debug("SuperColumnFamily "+CF_RANGE_pre + range +" already exists.");
			}
		}
		CFMetaData newCf = new CFMetaData(TABLE, CF_RANGE_pre,
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			logger.debug("SuperColumnFamily "+CF_RANGE_pre+" already exists.");
		}
	}
	
	public static void tryAddTestKeyspace() {		
		CFMetaData testCf = new CFMetaData(TESTTABLE, CF_RANGE_pre,
				ColumnFamilyType.Super, BytesType.instance, null);
		testCf.comment("instance slot").keyCacheSize(1.0).readRepairChance(0.0)
				.mergeShardsChance(0.0);
		KSMetaData testKs = new KSMetaData(testCf.ksName, SimpleStrategy.class,
				KSMetaData.optsWithRF(1));

		if (DatabaseDescriptor.getTableDefinition(testCf.ksName) == null) {
			try {
				new AddKeyspace(testKs).apply();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
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


