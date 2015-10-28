package com.me.encryptorapp;



import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class XorEncryptionTest {

	@Test
	public void simpleShiftUpEncryptDecryptTest(){
		EncryptionAlgorithmTest test = new EncryptionAlgorithmTest(new XorEncryption(),"XorTest");
		test.simpleEncryptDecryptTest();
}
}
