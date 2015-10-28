package com.me.encryptorapp;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class EncryptionAlgorithmTest {
	EncryptionAlgorithm algo;
	String nameOfTest;
	public EncryptionAlgorithmTest(EncryptionAlgorithm algo , String nameOfTest) {
		this.algo = algo;
		this.nameOfTest = nameOfTest;
	}
	
	public void simpleEncryptDecryptTest()  {
		String textTest = "this is a test";
		String location =  nameOfTest ;
		try {
			FileHandler.writeFile(location + "_text.txt", textTest);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		FileEncryptor tester = new FileEncryptor(algo);
		try {
			tester.encryptFile( location + "_text.txt", location + "_text_encrypted.txt"
					, location + "_key.txt");
			tester.decryptFile(location + "_text_encrypted.txt", location + "_text_encrypted_decrypted.txt", location + "_key.txt");
			String res = FileHandler.readFile(location + "_text_decrypt_encrypted.txt");
			assertEquals(res,textTest);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
	}

}
