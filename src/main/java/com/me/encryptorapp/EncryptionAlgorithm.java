package com.me.encryptorapp;

public interface EncryptionAlgorithm {
	public String encrypt(String s, int[] keys) throws invalidEncryptionKeyException;
	public String decrypt(String s, int[] keys)  throws invalidEncryptionKeyException;
	public int[] createKey();
	public int getKeyStength();
	public String getName();
}
