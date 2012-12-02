package avro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.JsonDecoder;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.util.Utf8;
import org.junit.Before;
import org.junit.Test;

public class TestInheritance {

	private Schema FBUser;
	private Schema base;
	private Schema ext1;
	private Schema ext2;

	@Before
	public void setUp() throws Exception {

		base = AvroUtils.parseSchema(new File("resources/facebookUser.avro"));
		ext1 = AvroUtils.parseSchema(new File(
				"resources/FacebookSpecialUserExtension1.avro"));
		ext2 = AvroUtils.parseSchema(new File(
				"resources/FacebookSpecialUserExtension2.avro"));
		FBUser = AvroUtils.parseSchema(new File(
				"resources/FacebooklUserInheritance.avro"));
	}

	@Test
	public void testInheritanceBinary() throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		GenericDatumWriter writer = new GenericDatumWriter(FBUser);
		Encoder encoder = new BinaryEncoder(outputStream);

		GenericRecord baseRecord = new GenericData.Record(base);
		baseRecord.put("name", new Utf8("Doctor Who"));
		baseRecord.put("num_likes", 1);
		baseRecord.put("num_photos", 0);
		baseRecord.put("num_groups", 423);
		GenericRecord FBrecord = new GenericData.Record(FBUser);
		FBrecord.put("type", "base");
		FBrecord.put("user", baseRecord);

		writer.write(FBrecord, encoder);

		baseRecord = new GenericData.Record(base);
		baseRecord.put("name", new Utf8("Doctor WhoWho"));
		baseRecord.put("num_likes", 1);
		baseRecord.put("num_photos", 0);
		baseRecord.put("num_groups", 423);
		GenericRecord extRecord = new GenericData.Record(ext1);
		extRecord.put("specialData1", 1);
		FBrecord = new GenericData.Record(FBUser);
		FBrecord.put("type", "extension1");
		FBrecord.put("user", baseRecord);
		FBrecord.put("extension", extRecord);

		writer.write(FBrecord, encoder);

		baseRecord = new GenericData.Record(base);
		baseRecord.put("name",
				new org.apache.avro.util.Utf8("Doctor WhoWhoWho"));
		baseRecord.put("num_likes", 2);
		baseRecord.put("num_photos", 0);
		baseRecord.put("num_groups", 424);
		extRecord = new GenericData.Record(ext2);
		extRecord.put("specialData2", 2);
		FBrecord = new GenericData.Record(FBUser);
		FBrecord.put("type", "extension2");
		FBrecord.put("user", baseRecord);
		FBrecord.put("extension", extRecord);

		writer.write(FBrecord, encoder);

		encoder.flush();

		byte[] data = outputStream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		Decoder decoder = DecoderFactory.defaultFactory().createBinaryDecoder(
				inputStream, null);
		GenericDatumReader reader = new GenericDatumReader(FBUser);
		while (true) {
			try {
				GenericRecord result = (GenericRecord) reader.read(null, decoder);
				System.out.println(result);
			} catch (EOFException eof) {
				break;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}