package hycz.dtcassandra.paxos.verbHandler;

import hycz.dtcassandra.paxos.callback.AcceptResponseHandler;
import hycz.dtcassandra.paxos.callback.PrepareResponseHandler;
import hycz.dtcassandra.paxos.message.AcceptedMessage;
import hycz.dtcassandra.paxos.message.PromiseMessage;

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

public class PaxosAcceptedVerbHandler implements IVerbHandler{

	private static Logger logger_ = LoggerFactory.getLogger(PaxosAcceptedVerbHandler.class);

	@Override
	public void doVerb(Message message, String id) {
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());

		AcceptedMessage acceptedMessage;
		try {
			Thread.sleep(2000);
			acceptedMessage = AcceptedMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
			logger_.debug("This is accepted(" 
					+ "instanceNumber = " + acceptedMessage.getInstanceNumber()
					+ ", proposalNumber = " + acceptedMessage.getProposalNumber() 
					+ ", value = " + acceptedMessage.getPaxosValue().getValue()
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
			
	        if (cb instanceof AcceptResponseHandler){
	            if (logger_.isDebugEnabled())
	                logger_.debug("Processing response on a callback from " + id + "@" + message.getFrom());
	            ((AcceptResponseHandler) cb).response(acceptedMessage);
	        }
	        
	        //learn the accepted value after a quorum of accepted message arrives
	        //the first arrived accepted message creates an acceptResponseHandler, and wait for other messages
	        
			
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
