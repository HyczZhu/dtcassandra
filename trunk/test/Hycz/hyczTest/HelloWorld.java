package hyczTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] arg){
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.info("Hello World");
		logger.debug("This is a debug message");
	}
}
