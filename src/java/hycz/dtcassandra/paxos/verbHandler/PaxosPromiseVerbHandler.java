package hycz.dtcassandra.paxos.verbHandler;

import hycz.dtcassandra.paxos.StringPaxosValue;
import hycz.dtcassandra.paxos.callback.IPaxosResponseHandler;
import hycz.dtcassandra.paxos.callback.PrepareResponseHandler;
import hycz.dtcassandra.paxos.message.PrepareMessage;
import hycz.dtcassandra.paxos.message.PromiseMessage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.cassandra.net.IAsyncCallback;
import org.apache.cassandra.net.IMessageCallback;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaxosPromiseVerbHandler implements IVerbHandler{
	private static Logger logger_ = LoggerFactory.getLogger(PaxosPromiseVerbHandler.class);

	@Override
	public void doVerb(Message message, String id) {
		
		ByteArrayInputStream body = new ByteArrayInputStream(message.getMessageBody());

		PromiseMessage promiseMessage;
		try {
			Thread.sleep(2000);
			promiseMessage = PromiseMessage.serializer().deserialize(new DataInputStream(body), message.getVersion());
			
			logger_.debug("This is promise(instanceNumber = "+promiseMessage.getInstanceNumber()+", proposalNumber = "+promiseMessage.getProposalNumber()+", value = "+promiseMessage.getPaxosValue());

			double age = System.currentTimeMillis() - MessagingService.instance().getRegisteredCallbackAge(id);
	        Pair<InetAddress, IMessageCallback> pair = MessagingService.instance().removeRegisteredCallback(id);
	        if (pair == null)
	        {
	            logger_.debug("Callback already removed for {}", id);
	            return;
	        }

	        IMessageCallback cb = pair.right;
	        MessagingService.instance().maybeAddLatency(cb, message.getFrom(), age);
			
	        if (cb instanceof PrepareResponseHandler){
	            if (logger_.isDebugEnabled())
	                logger_.debug("Processing response on a callback from " + id + "@" + message.getFrom());
	            ((PrepareResponseHandler) cb).response(promiseMessage);
	        }
		} catch (IOException e) {
			System.out.println("an IOException is thrown.");
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
