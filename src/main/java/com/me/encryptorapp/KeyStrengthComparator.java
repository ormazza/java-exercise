package com.me.encryptorapp;

import java.util.Comparator;

public class KeyStrengthComparator implements Comparator<EncryptionAlgorithm>{


	public int compare(EncryptionAlgorithm o1, EncryptionAlgorithm o2) {
		return o1.getKeyStength()-o2.getKeyStength();
	}

}
