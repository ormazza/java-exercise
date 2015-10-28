package com.me.encryptorapp;

import  com.me.encryptorapp.ShiftEncryption.Shift;

public class ShiftMultiplyEncryption implements EncryptionAlgorithm {
	private ShiftEncryption algo;
	public ShiftMultiplyEncryption(){
		algo = new ShiftEncryption(Shift.MULTIPLY);
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
