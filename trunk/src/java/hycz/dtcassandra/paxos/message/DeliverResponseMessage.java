package hycz.dtcassandra.paxos.message;

import hycz.dtcassandra.paxos.IPaxosValue;
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

public class DeliverResponseMessage implements MessageProducer,IPaxosMessage{
	
	private static ICompactSerializer<DeliverResponseMessage> serializer_ ;
	
	static
    {
        serializer_ = new DeliverResponseMessageSerializer();
    }

    public static ICompactSerializer<DeliverResponseMessage> serializer()
    {
        return serializer_;
    }

//    private boolean isNack;
    private String tableName;
    private Range range;
	private final long instanceNumber;
//	private long proposalNumber;
//	private boolean hasValue;
//	private IPaxosValue paxosValue;
	
	public DeliverResponseMessage(String tableName, Range range, long instanceNumber){
//		this.isNack = isNack;
		this.tableName=tableName;
		this.range=range;
		this.instanceNumber=instanceNumber;
//		this.proposalNumber=proposalNumber;
//		if (paxosValue == null) hasValue = false;
//		else hasValue = true;
//		this.paxosValue=paxosValue;
	}
	
	public static Message makeDeliverResponseMessage(Message message, DeliverResponseMessage deliverResponseMessage){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
        	DeliverResponseMessage.serializer().serialize(deliverResponseMessage, dos, message.getVersion());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return DeliverMessage.getReply(FBUtilities.getLocalAddress(), bos.toByteArray(), message.getVersion());
	}
	
//	public static Message makeNackPromiseMessage(Message message, AcceptedMessage acceptMessage, long promisedNum){
//		AcceptedMessage acceptedMessage = new AcceptedMessage(
//			true,
//			acceptMessage.getTableName(),
//			acceptMessage.getRange(),
//			acceptMessage.getInstanceNumber(),
//			promisedNum,
//			null);
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(bos);
//        try {
//			AcceptedMessage.serializer().serialize(acceptedMessage, dos, message.getVersion());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return AcceptMessage.getReply(FBUtilities.getLocalAddress(), bos.toByteArray(), message.getVersion());
//	}
	
	@Override
	public Message getMessage(Integer version) throws IOException {
				
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
        	DeliverResponseMessage.serializer().serialize(this, dos, version);
        }
        catch (IOException e)
        {
            throw new IOError(e);
        }
        return new Message(FBUtilities.getLocalAddress(), StorageService.Verb.PAXOSDELIVERRESPONSE, bos.toByteArray(), version);
	}
	
//	public boolean isNack(){
//		return isNack;
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

	public String toString() {
		return "DeliverResponseMessage(" 
			+ "tableName=" + tableName
			+ ", range=" + range
			+ ", instanceNumber=" + instanceNumber
//			+ ", proposalNumber=" + proposalNumber 
//			+ ", value=" + paxosValue.getValue()
			+ ")";
	}

	private static class DeliverResponseMessageSerializer implements ICompactSerializer<DeliverResponseMessage> {
		
		/***
		 * message struct:
		 *     boolean: isNack
		 *     String: tableName
		 *     Range: range
		 *     long: instanceNumber
		 *     long: proposalNumber
		 *     IPaxosValue : paxosValue 
		 */
		public void serialize(DeliverResponseMessage pm, DataOutputStream dos, int version) throws IOException {

//			dos.writeBoolean(pm.isNack());
			dos.writeUTF(pm.tableName);
			AbstractBounds.serializer().serialize(pm.range, dos);
			dos.writeLong(pm.getInstanceNumber());
//			dos.writeLong(pm.getProposalNumber());
//			dos.writeBoolean(pm.hasValue());
//			if (pm.hasValue()){
//				//need to change to other type
//				StringPaxosValue.serializer().serialize(pm.getPaxosValue(), dos);
//			}
		}

		public DeliverResponseMessage deserialize(DataInputStream dis, int version) throws IOException {

//			boolean isNack = dis.readBoolean();
			String tableName = dis.readUTF();
			Range range = (Range) AbstractBounds.serializer().deserialize(dis);
			long instanceNumber = dis.readLong();
//			long proposalNumber = dis.readLong();
//			boolean hasValue = dis.readBoolean();
//			IPaxosValue paxosValue = null;
//			if (hasValue)
//				paxosValue=StringPaxosValue.serializer().deserialize(dis);
			
			return new DeliverResponseMessage(tableName, range, instanceNumber);
		}
	}

	@Override
	public long getProposalNumber() {
		return -1;
	}

	@Override
	public IPaxosValue getPaxosValue() {
		return null;
	}
}
