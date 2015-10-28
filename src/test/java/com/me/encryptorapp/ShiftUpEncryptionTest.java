package com.me.encryptorapp;




import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class ShiftUpEncryptionTest {

	
	@Test
	public void simpleShiftUpEncryptDecryptTest() {
		EncryptionAlgorithmTest test = new EncryptionAlgorithmTest(new ShiftUpEncryption(),"ShiftUpTest");
		test.simpleEncryptDecryptTest();
}
}