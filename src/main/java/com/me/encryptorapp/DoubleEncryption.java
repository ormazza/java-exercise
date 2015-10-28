package com.me.encryptorapp;


public class DoubleEncryption implements EncryptionAlgorithm {

	EncryptionAlgorithm algorithm;
	public DoubleEncryption(EncryptionAlgorithm algo){
		algorithm = algo;
	}
	
	public String encrypt(String s, int[] keys) throws invalidEncryptionKeyException {
		if(keys.length<2)
			throw new invalidEncryptionKeyException("need to get 2 numbers with space between them");
		int[] first = {keys[0]};
		int[] second = {keys[1]};
		String tmp = algorithm.encrypt(s, first);
		return algorithm.encrypt(tmp, second);
	}


	public String decrypt(String s, int[] keys) throws invalidEncryptionKeyException {
		int[] first = {keys[0]};
		int[] second = {keys[1]};
		String tmp = algorithm.decrypt(s, first);
		return algorithm.decrypt(tmp, second);
	}


	public int[] createKey() {
		int[] firstKey = algorithm.createKey();
		int[] secondKey = algorithm.createKey();
		int [] ans = {firstKey[0],secondKey[0]};
		return ans;
	}
	public int getKeyStength() {
		return algorithm.getKeyStength()*2;
	}
	
	public String getName(){
		return "Double "  + algorithm.getName();
	}
}
