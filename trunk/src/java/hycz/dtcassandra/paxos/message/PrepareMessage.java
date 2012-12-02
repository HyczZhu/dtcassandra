package hycz.dtcassandra.paxos.message;

import hycz.dtcassandra.paxos.IPaxosValue;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer;
import org.apache.cassandra.net.CompactEndpointSerializationHelper;
import org.apache.cassandra.net.Header;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessageProducer;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.streaming.OperationType;
import org.apache.cassandra.streaming.PendingFile;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.commons.lang.text.StrBuilder;

//Client   Proposer      Acceptor     Learner
//|         |          |  |  |       |  |
//X-------->|          |  |  |       |  |  Request
//|         X--------->|->|->|       |  |  Prepare(N)
//|         |<---------X--X--X       |  |  Promise(N,{Va,Vb,Vc})
//|         X--------->|->|->|       |  |  Accept!(N,Vn)
//|         |<---------X--X--X------>|->|  Accepted(N,Vn)
//|<---------------------------------X--X  Response
//|         |          |  |  |       |  |
public class PrepareMessage implements MessageProducer,IPaxosMessage {

	private static ICompactSerializer<PrepareMessage> serializer_ ;
	
    static
    {
        serializer_ = new PrepareMessageSerializer();
    }

    public static ICompactSerializer<PrepareMessage> serializer()
    {
        return serializer_;
    }

    private String tableName;
    private Range range;
	private final long instanceNumber;
	private long proposalNumber;
	
	public PrepareMessage(String tableName, Range range, long instanceNumber, long proposalNumber){
		this.tableName = tableName;
		this.range = range;
		this.instanceNumber=instanceNumber;
		this.proposalNumber=proposalNumber;
	}
	
	@Override
	public Message getMessage(Integer version) throws IOException {
				
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
            PrepareMessage.serializer().serialize(this, dos, version);
        }
        catch (IOException e)
        {
            throw new IOError(e);
        }
        return new Message(FBUtilities.getLocalAddress(), StorageService.Verb.PAXOSPREPARE, bos.toByteArray(), version);
	}
	
	public static Message getReply(InetAddress from, byte[] body, int version)
    {
        return new Message(from, StorageService.Verb.PAXOSPROMISE, body, version);
    }
	
//	public boolean increaseProposeNumber(){
//		try{
////			proposalNumber.getAndAdd(paxosValue.getTable().getReplicationStrategy().getReplicationFactor());
//			proposalNumber.incrementAndGet();
//			return true;
//		}catch (Exception e){
//			return false;
//		}
//	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public Range getRange() {
		return range;
	}
	
	@Override
	public long getInstanceNumber(){
		return instanceNumber;
	}
	
	@Override
	public long getProposalNumber(){
		return proposalNumber;
	}
	
	@Override
	public IPaxosValue getPaxosValue() {
		return null;
	}

	public String toString() {
		return "PrepareMessage("
			+"tableName="+tableName+", "
			+"range="+range+", "
			+"instanceNumber="+instanceNumber+", " 
			+"proposalNumber="+proposalNumber+")";
	}

	private static class PrepareMessageSerializer implements ICompactSerializer<PrepareMessage> {
		
		/***
		 * message struct:
		 *     String: tableName
		 *     Range: range
		 *     long: instanceNumber
		 *     long: proposalNumber
		 */
		public void serialize(PrepareMessage pm, DataOutputStream dos, int version) throws IOException {
			
			dos.writeUTF(pm.tableName);
			AbstractBounds.serializer().serialize(pm.range, dos);
			dos.writeLong(pm.instanceNumber);
			dos.writeLong(pm.proposalNumber);
		}

		public PrepareMessage deserialize(DataInputStream dis, int version) throws IOException {
			String tableName = dis.readUTF();
			Range range = (Range) AbstractBounds.serializer().deserialize(dis);
			long instanceNumber = dis.readLong();
			long proposalNumber = dis.readLong();
			
			return new PrepareMessage(tableName, range, instanceNumber, proposalNumber);
		}
	}
}
