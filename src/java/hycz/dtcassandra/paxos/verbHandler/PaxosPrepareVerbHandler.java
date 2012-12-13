package hycz.dtcassandra.paxos.verbHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;

import hycz.dtcassandra.paxos.PaxosInstance;
import hycz.dtcassandra.paxos.PaxosInstanceManager;
import hycz.dtcassandra.paxos.PromiseResult;
import hycz.dtcassandra.paxos.StringPaxosValue;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.message.PromiseMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.hadoop.io.file.tfile.ByteArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaxosPrepareVerbHandler implements IVerbHandler{
	private static Logger logger_ = LoggerFactory.getLogger(PaxosPrepareVerbHandler.class);

	//check whether to promise or not
	public void doVerb(Message message, String id) {
		
//		byte[] body = message.getMessageBody();
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());
	
		PrepareMessage prepareMessage;
		try {
//			try{
//				Thread.sleep(2000);
//			}catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			prepareMessage = PrepareMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
//			System.out.println("This is prepare(instanceNumber = "
//					+ prepareMessage.getInstanceNumber()
//					+ ", proposalNumber = "
//					+ prepareMessage.getProposalNumber() 
//					+ ")");
			logger_.debug("This is prepare(instanceNumber = "
					+ prepareMessage.getInstanceNumber()
					+ ", proposalNumber = "
					+ prepareMessage.getProposalNumber() + ")");

			// if instanceNum == -1, means this is a validate message
			// which requires the current instance num and current timestamp
			if (prepareMessage.getInstanceNumber() == -1){
				long currentCommitNum = PaxosInstanceManager.getCurrentCommitNum(prepareMessage.getTableName(), prepareMessage.getRange());
				long currentApplyNum = PaxosInstanceManager.getCurrentApplyNum(prepareMessage.getTableName(), prepareMessage.getRange());
				long currentTimestamp = PaxosInstanceManager.getCurrentTimestamp(prepareMessage.getTableName(), prepareMessage.getRange());
				PromiseMessage promiseMessage;
				Message reply;
				promiseMessage = new PromiseMessage(
						false,
						prepareMessage.getTableName(),
						prepareMessage.getRange(),
						currentApplyNum,
						currentCommitNum,
						null,
						currentTimestamp);
				reply = PromiseMessage.makePromiseMessage(message, promiseMessage);
				MessagingService.instance().sendReply(reply, id, message.getFrom());
				return;
			}
			
			//main logic
			if (ReplicationManager.instance().isAcceptorOrWitness(prepareMessage.getTableName(), prepareMessage.getRange())){
//				PaxosInstanceManager.tryNewInstance(prepareMessage);
//				PromiseResult result = PaxosInstanceManager.promiseInstance(prepareMessage);
				PromiseResult result = PaxosInstanceManager.tryPromiseInstance(prepareMessage);				
				
				PromiseMessage promiseMessage;
				Message reply;
				if (result.isSuccess()){
					// 查看HINT标记检查是否是发往witness的消息，如果是，则在paxos操作成功时，要额外加一个HINT写
		            byte[] hintedBytes = message.getHeader(RowMutation.HINT);
		            if (hintedBytes != null){
		                assert hintedBytes.length > 0;
		                if (ReplicationManager.instance().isWitness(prepareMessage.getTableName(), prepareMessage.getRange())){
		                	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(hintedBytes));
		                    while (dis.available() > 0){
		                        ByteBuffer addressBytes = ByteBufferUtil.readWithShortLength(dis);
		                        if (logger_.isDebugEnabled())
		                            logger_.debug("Adding hint for " + InetAddress.getByName(ByteBufferUtil.string(addressBytes)));
		                        RowMutation rm = SimpleAccess.getHintRM_updateProposalNum(
		                        		prepareMessage.getTableName(), prepareMessage.getRange(), prepareMessage.getInstanceNumber());
		                        if(rm != null){
			                        RowMutation hintedMutation = new RowMutation(Table.SYSTEM_TABLE, addressBytes);
			                        hintedMutation.addHints(rm);
			                        hintedMutation.apply();
		                        }
		                    }
		    			}
		            }
		            
		            long timestamp = SimpleAccess.getCurrentInstanceTimestamp(prepareMessage.getTableName(), prepareMessage.getRange());
					promiseMessage = new PromiseMessage(
							false,
							prepareMessage.getTableName(),
							prepareMessage.getRange(),
							prepareMessage.getInstanceNumber(),
							result.getPreviousProposalNumber(),
							result.getAcceptedValue(),
							timestamp);
					logger_.debug("promise message made: (isNack = false, tableName = "
							+ promiseMessage.getTableName()
							+ ", range = "
							+ promiseMessage.getRange()
							+ ", instanceNumber = "
							+ promiseMessage.getInstanceNumber()
							+ ", previousProposalNumber = "
							+ promiseMessage.getProposalNumber()
							+ ", value = "
							+ promiseMessage.getPaxosValue());
					reply=PromiseMessage.makePromiseMessage(message, promiseMessage);
					logger_.debug("attemping to send back to "+message.getFrom().getHostAddress());
				}
				else{
					logger_.debug("promise message made: (isNack = true, tableName = "
							+ prepareMessage.getTableName()
							+ ", range = "
							+ prepareMessage.getRange()
							+ ", instanceNumber = "
							+ prepareMessage.getInstanceNumber()
							+ ", previousProposalNumber = "
							+ result.getPreviousProposalNumber()
							+ ", value = no need to know");
	
					reply=PromiseMessage.makeNackPromiseMessage(message, prepareMessage, result.getPreviousProposalNumber());
	//				logger_.debug("promise message id: "+reply.)
					logger_.debug("attemping to send back to "+message.getFrom().getHostAddress());
				}
				MessagingService.instance().sendReply(reply, id, message.getFrom());
			}
			
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
//		} catch (NullPointerException e) {
//			e.printStackTrace();
		}
	}
}
