package com.me.encryptorapp;




import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class ShiftMultiplyEncryptionTest {

	@Test
	public void simpleShiftMultiplyEncryptDecryptTest(){
		EncryptionAlgorithm shiftMultiplyEncryption = new ShiftMultiplyEncryption();
		EncryptionAlgorithmTest test = new EncryptionAlgorithmTest(shiftMultiplyEncryption,"shiftMultiplyTest");
		test.simpleEncryptDecryptTest();
}
}
