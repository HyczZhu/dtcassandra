package hycz.dtcassandra.paxos.message;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.PaxosValueFactory;
import hycz.dtcassandra.paxos.StringPaxosValue;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;

import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessageProducer;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

//Client   Proposer    Acceptor     Learner
//|         |          |  |  |       |  |
//X-------->|          |  |  |       |  |  Request
//|         X--------->|->|->|       |  |  Prepare(N)
//|         |<---------X--X--X       |  |  Promise(N,{Va,Vb,Vc})
//|         X--------->|->|->|       |  |  Accept!(N,Vn)
//|         |<---------X--X--X------>|->|  Accepted(N,Vn)
//|<---------------------------------X--X  Response
//|         |          |  |  |       |  |
public class AcceptedMessage implements MessageProducer,IPaxosMessage{

	private static ICompactSerializer<AcceptedMessage> serializer_ ;
	
	static
    {
        serializer_ = new AcceptedMessageSerializer();
    }

    public static ICompactSerializer<AcceptedMessage> serializer()
    {
        return serializer_;
    }

    private boolean isNack;
    private String tableName;
    private Range range;
	private final long instanceNumber;
	private long proposalNumber;
	private boolean hasValue;
	private IPaxosValue paxosValue;
	
	public AcceptedMessage(boolean isNack, String tableName, Range range, long instanceNumber, long proposalNumber, IPaxosValue paxosValue){
		this.isNack = isNack;
		this.tableName=tableName;
		this.range=range;
		this.instanceNumber=instanceNumber;
		this.proposalNumber=proposalNumber;
		if (paxosValue == null) hasValue = false;
		else hasValue = true;
		this.paxosValue=paxosValue;
	}
	
	public static Message makeAcceptedMessage(Message message, AcceptedMessage acceptedMessage){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
			AcceptedMessage.serializer().serialize(acceptedMessage, dos, message.getVersion());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return AcceptMessage.getReply(FBUtilities.getLocalAddress(), bos.toByteArray(), message.getVersion());
	}
	
	public static Message makeNackAcceptMessage(Message message, AcceptMessage acceptMessage, long promisedNum){
		AcceptedMessage acceptedMessage = new AcceptedMessage(
			true,
			acceptMessage.getTableName(),
			acceptMessage.getRange(),
			acceptMessage.getInstanceNumber(),
			promisedNum,
			null);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
			AcceptedMessage.serializer().serialize(acceptedMessage, dos, message.getVersion());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return AcceptMessage.getReply(FBUtilities.getLocalAddress(), bos.toByteArray(), message.getVersion());
	}
	
	@Override
	public Message getMessage(Integer version) throws IOException {
				
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
        	AcceptedMessage.serializer().serialize(this, dos, version);
        }
        catch (IOException e)
        {
            throw new IOError(e);
        }
        return new Message(FBUtilities.getLocalAddress(), StorageService.Verb.PAXOSACCEPTED, bos.toByteArray(), version);
	}
	
	public boolean isNack(){
		return isNack;
	}
	
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
	
	public boolean hasValue(){
		return hasValue;
	}
	
	@Override
	public IPaxosValue getPaxosValue(){
		return paxosValue;
	}

	public String toString() {
		return "AcceptedMessage(" 
			+ "tableName=" + tableName
			+ ", range=" + range
			+ ", instanceNumber=" + instanceNumber
			+ ", proposalNumber=" + proposalNumber 
			+ ", value=" + paxosValue.getValue()
			+ ")";
	}

	private static class AcceptedMessageSerializer implements ICompactSerializer<AcceptedMessage> {
		
		/***
		 * message struct:
		 *     boolean: isNack
		 *     String: tableName
		 *     Range: range
		 *     long: instanceNumber
		 *     long: proposalNumber
		 *     IPaxosValue : paxosValue 
		 */
		public void serialize(AcceptedMessage pm, DataOutputStream dos, int version) throws IOException {

			dos.writeBoolean(pm.isNack());
			dos.writeUTF(pm.tableName);
			AbstractBounds.serializer().serialize(pm.range, dos);
			dos.writeLong(pm.getInstanceNumber());
			dos.writeLong(pm.getProposalNumber());
			dos.writeBoolean(pm.hasValue());
			if (pm.hasValue()){
				//need to change to other type
//				StringPaxosValue.serializer().serialize(pm.getPaxosValue(), dos);
				PaxosValueFactory.serializer().serialize(pm.getPaxosValue(), dos, version);
			}
		}

		public AcceptedMessage deserialize(DataInputStream dis, int version) throws IOException {

			boolean isNack = dis.readBoolean();
			String tableName = dis.readUTF();
			Range range = (Range) AbstractBounds.serializer().deserialize(dis);
			long instanceNumber = dis.readLong();
			long proposalNumber = dis.readLong();
			boolean hasValue = dis.readBoolean();
			IPaxosValue paxosValue = null;
			if (hasValue)
//				paxosValue=StringPaxosValue.serializer().deserialize(dis);
				paxosValue = PaxosValueFactory.serializer().deserialize(dis, version);
			
			return new AcceptedMessage(isNack, tableName, range, instanceNumber, proposalNumber,paxosValue);
		}
	}

	
}
