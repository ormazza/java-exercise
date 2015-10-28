package com.me.encryptorapp;

import java.util.Random;

public class ShiftEncryption implements EncryptionAlgorithm {
	public enum Shift{
		UP,MULTIPLY,XOR
	}
	Shift shiftType;
	public ShiftEncryption(Shift type){
		shiftType = type;
	}
	public String encrypt(String s, int[] keys) throws invalidEncryptionKeyException {
		int key = keys[0];
		char[] charArray ;
		charArray = s.toCharArray();
		for (int i = 0 ; i<charArray.length ; i++){
			if(shiftType == Shift.UP)
				charArray[i] +=key;
			else if(shiftType == Shift.MULTIPLY){
				isKeyGood(keys);
				charArray[i] *=key;
			}
			else if(shiftType == Shift.XOR)
				charArray[i] = (char) (charArray[i] ^ key);
		}
		return new String (charArray);
	}

	public String decrypt(String s, int[] keys) {
		int key = keys[0];
		char[] charArray = new char[s.length()];
		charArray = s.toCharArray();
		for (int i = 0 ; i<charArray.length ; i++){
			if(shiftType == Shift.UP)
				charArray[i] -=key;
			else if(shiftType == Shift.MULTIPLY)
				charArray[i] /=key;
			else if(shiftType == Shift.XOR)
				charArray[i] = (char) (charArray[i] ^ key);
		}
		return new String(charArray);
	}

	public int[] createKey() {
		if (shiftType == Shift.MULTIPLY){
			Random rand = new Random();
			int[] keys = {Math.abs(rand.nextInt()/10000000)};
			return keys;
			
		}
		Random rand = new Random();
		int[] keys = {Math.abs(rand.nextInt())};
		return keys;
	}
	public void isKeyGood(int[] key) throws invalidEncryptionKeyException{
		if(shiftType == Shift.MULTIPLY && key[0]>999)
			throw new invalidEncryptionKeyException("multiply key should be smaller then 999");
	}
	public int getKeyStength(){
		if(shiftType == Shift.MULTIPLY)
			return 3;
		return 10;
	}
	public String getName(){
		if(shiftType == Shift.MULTIPLY)
			return "Shift Multiply Encryption";
		if(shiftType == Shift.UP)
			return "Shift Up Encryption";
		else
			return "Shift Xor Encryption";
	}

}
