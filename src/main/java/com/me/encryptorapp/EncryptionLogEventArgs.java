package com.me.encryptorapp;

public class EncryptionLogEventArgs {
	String fileName;
	String encryptionName;
	boolean encrypt; // true=encrypt , false=decrypt
	boolean start; // true=start , false=finish
	public EncryptionLogEventArgs(String fileName , String encryptionName , boolean encrypt , boolean start){
		this.fileName = fileName;
		this.encryptionName = encryptionName;
		this.encrypt = encrypt;
		this.start = start;
		
	}
}
