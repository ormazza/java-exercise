package com.me.encryptorapp;

import java.io.IOException;

public class ReadDecryptWriteThread implements Runnable {
	EncryptionAlgorithm algo;
	String fileName;
	String dirLocation;
	String decryptedFolderPath;
	int[] keys;
		public ReadDecryptWriteThread(EncryptionAlgorithm algo ,  int[] keys, String fileName , String decryptedFolderPath , String dirLocation){
		this.algo = algo;
		this.fileName = fileName;
		this.decryptedFolderPath = decryptedFolderPath;
		this.dirLocation = dirLocation;
		this.keys = keys;
		}
		public void run() {
			String originalText;
			try {
				originalText = FileHandler.readFile(dirLocation+"//"+fileName);
				String decrypted = algo.decrypt(originalText, keys);
				FileHandler.writeFile(decryptedFolderPath+"//"+fileName, decrypted);
				//FileHandler.writeKeys(decryptedFolderPath+"//key.txt",keys);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (invalidEncryptionKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
