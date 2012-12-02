package io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Serializable;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class TestIO {
	private static class SimpleObject implements Serializable{
		int a;
		int b;
		long c;
		String s;
		
		SimpleObject(int a,int b,long c,String s){
			this.a=a;
			this.b=b;
			this.c=c;
			this.s=s;
		}
	}
	public static void main(String[] args){
		
		
		try {
			File f = new File("F:\\testio");
			f.createNewFile();
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			oos.writeObject(new SimpleObject(1, 2, 3, "abc"));
			SimpleObject so=(SimpleObject)ois.readObject();
			System.out.println(so.a+" "+so.b+" "+so.c+" "+so.s);
//			int tempbyte;
//			for (int i=65;i<90;i++){
//				fos.write((char)i);
//			}
////			while ((tempbyte=fis.read())!=-1){
////				System.out.println(tempbyte);
////			}
//			Reader isr = new InputStreamReader(fis);
//			char c;
//			
//			RandomAccessFile raf = new RandomAccessFile(f,"rw");
//			long length = raf.length();
//			raf.seek(length);
//			raf.writeByte(999);
//			while((tempbyte=fis.read())!= -1){
//				System.out.println(tempbyte);
//			}
			fis.close();
			fos.close();
			
			File f2 = new File("F:\\testio2");
			f.createNewFile();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}
	}
	

}
