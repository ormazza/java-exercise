package com.me.encryptorapp;

import  com.me.encryptorapp.ShiftEncryption.Shift;

public class ShiftUpEncryption implements EncryptionAlgorithm {
	private ShiftEncryption algo;
	public ShiftUpEncryption(){
		algo = new ShiftEncryption(Shift.UP);
	}
	public  String encrypt(String s, int[] keys) throws invalidEncryptionKeyException{
		return algo.encrypt(s, keys);
	}
	public  String decrypt (String s, int[] keys){
		return algo.decrypt(s, keys);
	}
	public int[] createKey(){
		return algo.createKey();
	}
	public int getKeyStength() {
		return algo.getKeyStength();
	}
	public String getName(){
		return algo.getName();
	}
}


