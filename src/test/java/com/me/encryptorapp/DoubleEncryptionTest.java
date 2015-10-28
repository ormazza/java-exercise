package com.me.encryptorapp;





import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class DoubleEncryptionTest {

	@Test
	public void simpleShiftUpEncryptDecryptTest(){
		EncryptionAlgorithm shiftUpEncryption = new ShiftUpEncryption();
		EncryptionAlgorithmTest test = new EncryptionAlgorithmTest(new DoubleEncryption(shiftUpEncryption),"DoubleShiftUpTest");
		test.simpleEncryptDecryptTest();
}

}
