package com.me.encryptorapp;


import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class FileEncryptor extends Observable {
	private EncryptionAlgorithm algorithm;
	public EncryptionLogger logger;
	public FileEncryptor(EncryptionAlgorithm algo){
		logger = new EncryptionLogger();
		this.addObserver(logger);
		algorithm = algo;
 }
	public void encryptFolder(String originalFolderPath) throws Exception{
		int[] keys = algorithm.createKey();
		String encryptedFolderPath = FileHandler.makeFolder(originalFolderPath,"encrypted");
		List<String> filesInFolder = FileHandler.getTextFilesInFolder(originalFolderPath);
		for(int i=0 ; i<filesInFolder.size() ; i++){
			String originalText = FileHandler.readFile(originalFolderPath+"//"+filesInFolder.get(i));
			String encrypted = algorithm.encrypt(originalText, keys);
			FileHandler.writeFile(encryptedFolderPath+"//"+filesInFolder.get(i), encrypted);
		}
		FileHandler.writeKeys(encryptedFolderPath+"//key.txt",keys);
		
	}
	public void encryptFile(String originalFilePath, String outputFilePath,String keyPath) throws Exception{
		EncryptionLogEventArgs args = new EncryptionLogEventArgs(originalFilePath,algorithm.getName(),true,true,0);
		setChanged();		
		notifyObservers(args);
		long lStartTime = System.nanoTime();
		
		String originalText = FileHandler.readFile(originalFilePath);
		int[] keys = algorithm.createKey();
		FileHandler.writeKeys(keyPath,keys);
		String encrypted = algorithm.encrypt(originalText, keys);
		FileHandler.writeFile(outputFilePath, encrypted);
		
		long lEndTime = System.nanoTime();
		long difference = lEndTime - lStartTime;
		args = new EncryptionLogEventArgs(originalFilePath, algorithm.getName(),true,false,difference/1000000);
		setChanged();
		notifyObservers(args);
	}
	public void decryptFile(String originalFilePath, String outputFilePath,String keyPath) throws Exception{
		EncryptionLogEventArgs args = new EncryptionLogEventArgs(originalFilePath,algorithm.getName(),false,true,0);
		setChanged();		
		notifyObservers(args);
		long lStartTime = System.nanoTime();
		
		String originalText = FileHandler.readFile(originalFilePath);
		int[] keys = FileHandler.readKeys(keyPath);
		String decrypted = algorithm.decrypt(originalText, keys);
		FileHandler.writeFile(outputFilePath, decrypted);
		
		long lEndTime = System.nanoTime();
		long difference = lEndTime - lStartTime;
		args = new EncryptionLogEventArgs(originalFilePath, algorithm.getName(),false,false,difference/1000000);
		setChanged();
		notifyObservers(args);
	}
	
	
}
