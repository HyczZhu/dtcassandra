package hycz.dtcassandra.paxos.verbHandler;

import hycz.dtcassandra.paxos.callback.AcceptResponseHandler;
import hycz.dtcassandra.paxos.callback.DeliverResponseHandler;
import hycz.dtcassandra.paxos.message.AcceptedMessage;
import hycz.dtcassandra.paxos.message.DeliverResponseMessage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.cassandra.net.IMessageCallback;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaxosDeliverResponseVerbHandler implements IVerbHandler{
	private static Logger logger_ = LoggerFactory.getLogger(PaxosDeliverResponseVerbHandler.class);

	@Override
	public void doVerb(Message message, String id) {
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());

		DeliverResponseMessage deliverResponseMessage;
		try {
//			try{
//				Thread.sleep(2000);
//			}catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			deliverResponseMessage = DeliverResponseMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
			logger_.debug("This is deliverResponse(" 
					+ "instanceNumber = " + deliverResponseMessage.getInstanceNumber()
					+ ", proposalNumber = " + deliverResponseMessage.getProposalNumber()
					+ ")");
			
			//call back handle
			double age = System.currentTimeMillis() - MessagingService.instance().getRegisteredCallbackAge(id);
	        Pair<InetAddress, IMessageCallback> pair = MessagingService.instance().removeRegisteredCallback(id);
	        if (pair == null)
	        {
	            logger_.debug("Callback already removed for {}", id);
	            return;
	        }

	        IMessageCallback cb = pair.right;
	        MessagingService.instance().maybeAddLatency(cb, message.getFrom(), age);
			
	        if (cb instanceof DeliverResponseHandler){
	            if (logger_.isDebugEnabled())
	                logger_.debug("Processing response on a callback from " + id + "@" + message.getFrom());
	            ((DeliverResponseHandler) cb).response(deliverResponseMessage);
	        }
	        
	        //learn the accepted value after a quorum of accepted message arrives
	        //the first arrived accepted message creates an acceptResponseHandler, and wait for other messages
	        
			
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
		}
	}
}
