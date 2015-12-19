package com.me.encryptorapp;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encryptor {
	public static void main(String[] args) {
		//String sPath = "C:\\Users\\Or\\Documents\\workspace\\text.txt";
		System.out.println("hello type the number to choose \n1 - to encrypt \n2 - to decrypt \n3 - to encrypt folder");
		Scanner keyboard = new Scanner(System.in);
		if(keyboard.hasNextInt()){
			int function = keyboard.nextInt();

			//encrypt
			if(function==1){
				System.out.println("type the path to the source file");
				String sPath = keyboard.next();
				//Path path = Paths.get(sPath);
				String keyPath = "key.txt";
				String encryptedFilePath = sPath.replace(".", "_encrypted.");
				FileEncryptor encryptor = new FileEncryptor(new DoubleEncryption(new ShiftUpEncryption()));
				try {
					encryptor.encryptFile(sPath, encryptedFilePath, keyPath);
				} catch (Exception e) {
					System.out.println("file not found");
				}
				System.out.println("encrypted file is "+encryptedFilePath);
				System.out.println("key file is "+keyPath);
			}
			//decrypt
			else if(function==2){
				System.out.println("type the path to the ecnrypted file");
				String sPath = keyboard.next();
				System.out.println("type the path to the key file");
				String keyPath = keyboard.next();
				String decryptedFilePath = sPath.replace(".", "_decrypted.");
				FileEncryptor encryptor = new FileEncryptor(new DoubleEncryption(new ShiftUpEncryption()));
				try {
					encryptor.decryptFile(sPath, decryptedFilePath, keyPath);
				} catch (Exception e) {
					System.out.println("file/key not found");
				}
				System.out.println("decrypted file is "+decryptedFilePath);
				
			}
			else if(function ==3){
				
				IDirectoryProcessor dirProcessor  = new AsyncDirectoryProcessor(new DoubleEncryption(new ShiftUpEncryption()));
				//FileEncryptor encryptor = new FileEncryptor(new DoubleEncryption(new ShiftUpEncryption()));
				try {
					dirProcessor.encryptFolder("iamafolder");
					dirProcessor.decryptFolder("iamafolder//encrypted");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(function==4){//xml
				ReadXmlDom xml = new ReadXmlDom();
				xml.read("settings.xml");
				
			}
			else{
				System.out.println("invald input - input must be 1 or 2");

			}
		}
		else{
			System.out.println("invalid input - must be a number");
		}

	}
}
