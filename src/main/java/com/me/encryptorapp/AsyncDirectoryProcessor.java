package com.me.encryptorapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AsyncDirectoryProcessor implements IDirectoryProcessor {
	private EncryptionAlgorithm algo;
	public AsyncDirectoryProcessor(EncryptionAlgorithm algorithm){
		algo = algorithm;
	}

	public void encryptFolder(String dirLocation) {
		int[] keys = algo.createKey();

		String encryptedFolderPath = FileHandler.makeFolder(dirLocation,"encrypted");
		try {
			FileHandler.writeKeys(encryptedFolderPath+"//key.txt",keys);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		List<String> filesInFolder = FileHandler.getTextFilesInFolder(dirLocation);
		for(int i=0 ; i<filesInFolder.size() ; i++){
			ReadEncryptWriteThread runnable = new ReadEncryptWriteThread(algo,keys, filesInFolder.get(i) ,encryptedFolderPath, dirLocation);
			Thread thread = new Thread(runnable);
			thread.start();



		}

	}

	public void decryptFolder(String dirLocation) {
		int[] keys = {0,0};
		try {
			keys = FileHandler.readKeys(dirLocation+"//key.txt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String decryptedFolderPath = FileHandler.makeFolder(dirLocation,"decrypted");
		List<String> filesInFolder = FileHandler.getTextFilesInFolder(dirLocation);
		for(int i=0 ; i<filesInFolder.size() ; i++){
			ReadDecryptWriteThread runnable = new ReadDecryptWriteThread(algo, keys, filesInFolder.get(i), decryptedFolderPath, dirLocation);
			Thread thread = new Thread(runnable);
			thread.start();


		}
		
	}
}
