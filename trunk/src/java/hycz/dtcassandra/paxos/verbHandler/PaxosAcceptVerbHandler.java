package hycz.dtcassandra.paxos.verbHandler;

import hycz.dtcassandra.paxos.PaxosInstanceManager;
import hycz.dtcassandra.paxos.PaxosLeaderInstanceManager;
import hycz.dtcassandra.paxos.StringPaxosValue;
import hycz.dtcassandra.paxos.actor.Acceptor;
import hycz.dtcassandra.paxos.callback.PrepareResponseHandler;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.AcceptedMessage;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.message.PromiseMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;

import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.net.IMessageCallback;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaxosAcceptVerbHandler implements IVerbHandler {

	private static Logger logger_ = LoggerFactory.getLogger(PaxosAcceptVerbHandler.class);

	//check whether to accept or not
	public void doVerb(Message message, String id) {
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());

		AcceptMessage acceptMessage;
		try {
			Thread.sleep(2000);
			//1, make an acceptMessage
			acceptMessage = AcceptMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
			System.out.println("This is accept("
					+ "instanceNumber = " + acceptMessage.getInstanceNumber()
					+ ", proposalNumber = "	+ acceptMessage.getProposalNumber()
					+ ", value = " + acceptMessage.getPaxosValue().getValue()
					+ ")");
			logger_.debug("This is accept(" 
					+ "instanceNumber = " + acceptMessage.getInstanceNumber()
					+ ", proposalNumber = " + acceptMessage.getProposalNumber() 
					+ ", value = " + acceptMessage.getPaxosValue().getValue()
					+ ")");
			
			//2, check acceptor role for this table and key
			if (ReplicationManager.instance().isAcceptor(acceptMessage.getTableName(), acceptMessage.getRange())){
				//3, if the role is acceptor, call accept method
				//   all the stabilize stuff will be done in this method
				boolean success = PaxosInstanceManager.acceptInstance(acceptMessage);
				
				//4, after accept method, no matter it's synchronized or not, 
				//   we can not send reply until we are sure that the stabilization is done
				if (success){
					// 查看HINT标记检查是否是发往witness的消息，如果是，则在paxos操作成功时，要额外加一个HINT写
		            byte[] hintedBytes = message.getHeader(RowMutation.HINT);
		            if (hintedBytes != null){
		                assert hintedBytes.length > 0;
		                if (ReplicationManager.instance().isWitness(acceptMessage.getTableName(), acceptMessage.getRange())){
		                	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(hintedBytes));
		                    while (dis.available() > 0){
		                        ByteBuffer addressBytes = ByteBufferUtil.readWithShortLength(dis);
		                        if (logger_.isDebugEnabled())
		                            logger_.debug("Adding hint for " + InetAddress.getByName(ByteBufferUtil.string(addressBytes)));
		                        RowMutation rm = SimpleAccess.getHintRM_updateProposalNum(
		                        		acceptMessage.getTableName(), acceptMessage.getRange(), acceptMessage.getInstanceNumber());
		                        if(rm != null){
			                        RowMutation hintedMutation = new RowMutation(Table.SYSTEM_TABLE, addressBytes);
			                        hintedMutation.addHints(rm);
			                        hintedMutation.apply();
		                        }
		                    }
		    			}
		            }
					
					AcceptedMessage acceptedMessage;
					Message reply;
					acceptedMessage = new AcceptedMessage(
							false,
							acceptMessage.getTableName(),
							acceptMessage.getRange(),
							acceptMessage.getInstanceNumber(),
							acceptMessage.getProposalNumber(),
							acceptMessage.getPaxosValue());
					logger_.debug("accepted message made: ("
							+ "instanceNumber = " + acceptedMessage.getInstanceNumber()
							+ ", proposalNumber = " + acceptedMessage.getProposalNumber()
							+ ", value = " + acceptedMessage.getPaxosValue().getValue()
							+ ")");
					reply=AcceptedMessage.makeAcceptedMessage(message, acceptedMessage);
					logger_.debug("attemping to send back to "+message.getFrom().getHostAddress());
					MessagingService.instance().sendReply(reply, id, message.getFrom());
				}
			}
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
