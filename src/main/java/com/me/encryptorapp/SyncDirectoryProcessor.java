package com.me.encryptorapp;

import java.io.IOException;
import java.util.List;

public class SyncDirectoryProcessor implements IDirectoryProcessor {
	private EncryptionAlgorithm algo;
	public SyncDirectoryProcessor(EncryptionAlgorithm algorithm){
		algo = algorithm;
	}

	public void encryptFolder(String dirLocation) {
		int[] keys = algo.createKey();
		String encryptedFolderPath = FileHandler.makeFolder(dirLocation,"encrypted");
		List<String> filesInFolder = FileHandler.getTextFilesInFolder(dirLocation);
		for(int i=0 ; i<filesInFolder.size() ; i++){
			String originalText;
			try {
				originalText = FileHandler.readFile(dirLocation+"//"+filesInFolder.get(i));
				String encrypted = algo.encrypt(originalText, keys);
				FileHandler.writeFile(encryptedFolderPath+"//"+filesInFolder.get(i), encrypted);
				FileHandler.writeKeys(encryptedFolderPath+"//key.txt",keys);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (invalidEncryptionKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void decryptFolder(String dirLocation){
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
			String originalText;
			try {
				originalText = FileHandler.readFile(dirLocation+"//"+filesInFolder.get(i));
				String decrypted = algo.decrypt(originalText, keys);
				FileHandler.writeFile(decryptedFolderPath+"//"+filesInFolder.get(i), decrypted);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (invalidEncryptionKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
