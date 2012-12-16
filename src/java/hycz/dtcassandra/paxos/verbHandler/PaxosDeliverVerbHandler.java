package hycz.dtcassandra.paxos.verbHandler;

import hycz.dtcassandra.paxos.PaxosInstanceManager;
import hycz.dtcassandra.paxos.message.AcceptMessage;
import hycz.dtcassandra.paxos.message.AcceptedMessage;
import hycz.dtcassandra.paxos.message.DeliverMessage;
import hycz.dtcassandra.paxos.message.DeliverResponseMessage;
import hycz.dtcassandra.paxos.storage.SimpleAccess;
import hycz.dtcassandra.transaction.replication.ReplicationManager;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;

import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaxosDeliverVerbHandler implements IVerbHandler{
	private static Logger logger_ = LoggerFactory.getLogger(PaxosDeliverVerbHandler.class);
	
	public void doVerb(Message message, String id) {
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());

		DeliverMessage deliverMessage;
		try {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			//1, make an deliverMessage
			deliverMessage = DeliverMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
//			System.out.println("This is deliver("
//					+ "instanceNumber = " + deliverMessage.getInstanceNumber()
//					+ ", proposalNumber = "	+ deliverMessage.getProposalNumber()
//					+ ", value = " + (deliverMessage.getPaxosValue()==null?null:deliverMessage.getPaxosValue().getValue())
//					+ ")");
			logger_.debug("This is deliver(" 
					+ "instanceNumber = " + deliverMessage.getInstanceNumber()
					+ ", proposalNumber = " + deliverMessage.getProposalNumber() 
					+ ", value = " + (deliverMessage.getPaxosValue()==null?null:deliverMessage.getPaxosValue().getValue())
					+ ")");
			
			if (deliverMessage.getInstanceNumber() < PaxosInstanceManager.getMinInstanceNum(deliverMessage.getTableName(), deliverMessage.getRange()))
				return;
			//2, check learner role for this table and key
			if (ReplicationManager.instance().isAcceptor(deliverMessage.getTableName(), deliverMessage.getRange())){
				//3, if the role is learner, call deliver method
				//   all the stabilize stuff will be done in this method
				boolean success = PaxosInstanceManager.deliverInstance(deliverMessage);
				if (success){
					DeliverResponseMessage deliverResponseMessage;
					Message reply;
					deliverResponseMessage = new DeliverResponseMessage(
							deliverMessage.getTableName(),
							deliverMessage.getRange(),
							deliverMessage.getInstanceNumber());
					logger_.debug("deliver response message made: ("
							+ "tableName = " + deliverResponseMessage.getTableName()
							+ "range = " + deliverResponseMessage.getRange()
							+ ",instanceNumber = " + deliverResponseMessage.getInstanceNumber()
							+ ")");
					reply = DeliverResponseMessage.makeDeliverResponseMessage(message, deliverResponseMessage);
					logger_.debug("attemping to send back to "+message.getFrom().getHostAddress());
					MessagingService.instance().sendReply(reply, id, message.getFrom());
					
					if (ReplicationManager.instance().isLearner(deliverMessage.getTableName(), deliverMessage.getRange())){	
						PaxosInstanceManager.applyInstance(deliverMessage);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
		}
	}
}
