package hycz.dtcassandra.test;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestReadUTF {
	
	public static void main(String[] args){
		String s="system";
		try {
			DataOutputStream dos=new DataOutputStream(new FileOutputStream("f:\\TestReadUTF.txt"));
			DataInputStream dis=new DataInputStream(new FileInputStream("f:\\TestReadUTF.txt"));
			dos.writeUTF(s);
			String readString=dis.readUTF();
			System.out.println(readString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
