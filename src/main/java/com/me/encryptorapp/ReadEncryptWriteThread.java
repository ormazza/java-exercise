package com.me.encryptorapp;

import java.io.IOException;

public class ReadEncryptWriteThread implements Runnable {
EncryptionAlgorithm algo;
String fileName;
String dirLocation;
String encryptedFolderPath;
int[] keys;
	public ReadEncryptWriteThread(EncryptionAlgorithm algo ,  int[] keys, String fileName , String encryptedFolderPath , String dirLocation){
	this.algo = algo;
	this.fileName = fileName;
	this.encryptedFolderPath = encryptedFolderPath;
	this.dirLocation = dirLocation;
	this.keys = keys;
	}
	public void run() {
		String originalText;
		try {
			
			originalText = FileHandler.readFile(dirLocation+"//"+fileName);
			String encrypted = algo.encrypt(originalText, keys);
			FileHandler.writeFile(encryptedFolderPath+"//"+fileName, encrypted);
			
			//FileHandler.writeKeys(encryptedFolderPath+"//key.txt",keys);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (invalidEncryptionKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
