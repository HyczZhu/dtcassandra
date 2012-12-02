package hycz.dtcassandra.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCase {
	public static void main(String arg[]){
		try {  

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  

		    String s = br.readLine(); 
		    
		    System.out.println(s);

		} catch (IOException e) {  

		    e.printStackTrace();  

		} 
	}
}
