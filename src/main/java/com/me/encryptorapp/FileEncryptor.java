package com.me.encryptorapp;


import java.io.IOException;
import java.util.Observable;

public class FileEncryptor extends Observable {
	private EncryptionAlgorithm algorithm;
	public EncryptionLogger logger;
	public FileEncryptor(EncryptionAlgorithm algo){
		logger = new EncryptionLogger();
		this.addObserver(logger);
		algorithm = algo;
 }
	public void encryptFile(String originalFilePath, String outputFilePath,String keyPath) throws Exception{
		String originalText = FileHandler.readFile(originalFilePath);
		int[] keys = algorithm.createKey();
		FileHandler.writeKeys(keyPath,keys);
		EncryptionLogEventArgs args = new EncryptionLogEventArgs(originalFilePath,algorithm.getName(),true,true);
		setChanged();		
		notifyObservers(args);
		String encrypted = algorithm.encrypt(originalText, keys);
		FileHandler.writeFile(outputFilePath, encrypted);
		args = new EncryptionLogEventArgs(originalFilePath, algorithm.getName(),true,false);
		setChanged();
		notifyObservers(args);
	}
	public void decryptFile(String originalFilePath, String outputFilePath,String keyPath) throws Exception{
		String originalText = FileHandler.readFile(originalFilePath);
		int[] keys = FileHandler.readKeys(keyPath);
		setChanged();
		notifyObservers();
		String decrypted = algorithm.decrypt(originalText, keys);
		FileHandler.writeFile(outputFilePath, decrypted);
		setChanged();
		notifyObservers();
	}
	
	
}
