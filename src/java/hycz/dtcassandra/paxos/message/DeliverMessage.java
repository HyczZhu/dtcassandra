package hycz.dtcassandra.paxos.message;

import hycz.dtcassandra.paxos.IPaxosValue;
import hycz.dtcassandra.paxos.StringPaxosValue;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.io.ICompactSerializer;
import org.apache.cassandra.net.Message;
import org.apache.cassandra.net.MessageProducer;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.FBUtilities;

public class DeliverMessage implements MessageProducer,IPaxosMessage {

	private static ICompactSerializer<DeliverMessage> serializer_ ;
	
    static
    {
        serializer_ = new DeliverMessageSerializer();
    }

    public static ICompactSerializer<DeliverMessage> serializer()
    {
        return serializer_;
    }
    
    private String tableName;
    private Range range;
	private final long instanceNumber;
	private long proposalNumber;
	private boolean hasValue;
	private IPaxosValue paxosValue;
	
	public DeliverMessage(String tableName, Range range, long instanceNumber, long proposalNumber, IPaxosValue paxosValue){
		this.tableName=tableName;
		this.range=range;
		this.instanceNumber=instanceNumber;
		this.proposalNumber=proposalNumber;
		if (paxosValue == null) hasValue = false;
		else hasValue = true;
		this.paxosValue=paxosValue;
	}
	
	public static Message getReply(InetAddress from, byte[] body, int version)
    {
        return new Message(from, StorageService.Verb.PAXOSDELIVERRESPONSE, body, version);
    }
	
	@Override
	public Message getMessage(Integer version) throws IOException {
				
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try
        {
        	DeliverMessage.serializer().serialize(this, dos, version);
        }
        catch (IOException e)
        {
            throw new IOError(e);
        }
        return new Message(FBUtilities.getLocalAddress(), StorageService.Verb.PAXOSDELIVER, bos.toByteArray(), version);
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
		return "DeliverMessage("
				+ "tableName=" + tableName
				+ ", range=" + range
				+ ", instanceNumber=" + instanceNumber
				+ ", proposalNumber=" + proposalNumber 
				+ ", value=" + paxosValue.getValue()
				+ ")";
	}
	
	private static class DeliverMessageSerializer implements ICompactSerializer<DeliverMessage> {
		
		/***
		 * message struct:
		 *     String: tableName
		 *     Range: range
		 *     long: instanceNumber
		 *     long: proposalNumber
		 *     IPaxosValue : paxosValue 
		 */
		public void serialize(DeliverMessage pm, DataOutputStream dos, int version) throws IOException {
			
			dos.writeUTF(pm.tableName);
			AbstractBounds.serializer().serialize(pm.range, dos);
			dos.writeLong(pm.getInstanceNumber());
			dos.writeLong(pm.getProposalNumber());
			dos.writeBoolean(pm.hasValue());
			if (pm.hasValue()){
				//need to change to other type
				StringPaxosValue.serializer().serialize(pm.getPaxosValue(), dos);
			}
		}

		public DeliverMessage deserialize(DataInputStream dis, int version) throws IOException {
			
			String tableName = dis.readUTF();
			Range range = (Range) AbstractBounds.serializer().deserialize(dis);
			long instanceNumber = dis.readLong();
			long proposalNumber = dis.readLong();
			boolean hasValue = dis.readBoolean();
			IPaxosValue paxosValue = null;
			if (hasValue)
				paxosValue=StringPaxosValue.serializer().deserialize(dis);
			
			return new DeliverMessage(tableName, range, instanceNumber, proposalNumber,paxosValue);
		}
	}


}
