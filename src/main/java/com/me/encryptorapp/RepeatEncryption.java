package com.me.encryptorapp;

public class RepeatEncryption implements EncryptionAlgorithm {
	int n;
	EncryptionAlgorithm algorithm;
	public RepeatEncryption(int n , EncryptionAlgorithm algo){
	this.n=n;
	algorithm = algo;
}

	public String encrypt(String s, int[] keys) throws invalidEncryptionKeyException {
		String ans = s;
		for( int i = 0 ; i<n ; i++){
			ans = algorithm.encrypt(ans, keys);
		}
		return ans;
	}
	@Override
	public String decrypt(String s, int[] keys) throws invalidEncryptionKeyException {
		String ans = s;
		for( int i = 0 ; i<n ; i++){
			ans = algorithm.decrypt(ans, keys);
		}
		return ans;
	}
	@Override
	public int[] createKey() {
		return algorithm.createKey();
	}
	public int getKeyStength(){
		return 10;
	}
	public String getName(){
		return "Reapet " + n + " "+ algorithm.getName();
	}


}
