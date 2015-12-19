package com.me.encryptorapp;
import java.util.Observable;

import java.util.Observer;


public class EncryptionLogger implements Observer {
	static final 	EncryptionLog4JLogger logger = new EncryptionLog4JLogger();
	public void update(Observable o, Object arg) {
		EncryptionLogEventArgs args = (EncryptionLogEventArgs) arg;
		//System.out.println(args.encryptionName);
		String res = "";
		if(args.encrypt == true)
			res+="the encryption for ";
		else
			res+="the decryption for ";
		res+=args.fileName+" with algorithm "+args.encryptionName;
		if(args.start == true)
			res+=" started";
		else
			res+=" took "+args.time+" millisecond";
		logger.WriteLog(res);
	}

}
