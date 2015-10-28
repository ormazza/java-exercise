package com.me.encryptorapp;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
public class RepeatEncryptionTest {

	@Test
	public void simpleShiftUpEncryptDecryptTest(){
		EncryptionAlgorithm shiftUpEncryption = new ShiftUpEncryption();
		EncryptionAlgorithmTest test = new EncryptionAlgorithmTest(new RepeatEncryption(5,shiftUpEncryption),"DoubleShiftUpTest");
		test.simpleEncryptDecryptTest();
}

}
