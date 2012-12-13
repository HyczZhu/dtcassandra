package hycz.dtcassandra.transaction;

import hycz.dtcassandra.paxos.MultiRMPaxosValue;
import hycz.dtcassandra.paxos.PaxosOverallManager;
import hycz.dtcassandra.paxos.RowMutationPaxosValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.thrift.ConsistencyLevel;

/***
 * 将写事务划分为多个子事务,并将各子事务发往相应的节点处理
 * prepare阶段等待各节点返回相应的instance number
 * apply阶段将结果写入系统,并让各节点apply
 * 当全部返回成功时返回事务成功
 * 
 * 所有的RowMutation的key必须属于同一个Range,即一个entity group
 * @author Hycz
 *
 */
public class WriteTransaction {
	private String tableName;
	private Range range;
	private List<RowMutation> mutations;
	
	public WriteTransaction(String tableName, Range range, List<RowMutation> mutations){
		this.tableName = tableName;
		this.range = range;
		this.mutations = mutations;
//		for (RowMutation m : mutations){
//			this.mutations.put(m, -1L);
//		}
	}
	
	/***
	 * get an empty instance, try to make concensus
	 * @return
	 */
	public boolean execute(){
		// try to get an empty instance and make concensus
		final long instanceNum = PaxosOverallManager.get(tableName, range)
			.makeConsensus(new MultiRMPaxosValue(tableName, range, mutations));
		System.out.println("Result : instanceNum of this successful Consensus= " + instanceNum);
//		if (instanceNum >= 0){
		if (instanceNum >= 0){
			while (true){
				boolean deliverSuccess = PaxosOverallManager.get(tableName, range).deliverValue(instanceNum, NWRLevel.getWriteConsistencyLevel());
				System.out.println("deliver for instance " + instanceNum + " success?= " + deliverSuccess);
				if (deliverSuccess)
					return deliverSuccess;	
			}
//			Runnable deliverAndApply = new Runnable() {
//			public void run() {
//				}
//			};
//			StageManager.getStage(Stage.PAXOS_DELIVER).execute(deliverAndApply);
//			return false;
		}
		else 
			return false;
	}
}
