package com.me.encryptorapp;
import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
public class EncryptionLog4JLogger {
	static final Logger logger = Logger.getLogger(EncryptionLog4JLogger.class);
	public EncryptionLog4JLogger(){
    BasicConfigurator.configure();
    
}
public  void WriteLog(String s){
	
	logger.info(s);
	
}
public void WriteErorLog(String s){
	logger.error(s);
}
}