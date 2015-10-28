package com.me.encryptorapp;
import java.util.Observable;
import java.util.Observer;


public class EncryptionLogger implements Observer {

	public void update(Observable o, Object arg) {
		EncryptionLogEventArgs args = (EncryptionLogEventArgs) arg;
		//System.out.println(args.encryptionName);
		//System.out.println(args.fileName);
		
	}

}
