package com.me.encryptorapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(encoded)).toString();
    }
    
	static void writeFile(String path,String text) throws FileNotFoundException, UnsupportedEncodingException{
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			writer.print(text);
			writer.close();		
	}

	static void writeKeys(String keyPath, int[] keys) throws FileNotFoundException, UnsupportedEncodingException {
		String ans="";
		for(int i=0 ; i<keys.length ; i++){
			ans+=String.valueOf(keys[i]);
			if(i!=keys.length-1)
				ans+=" ";
		}
		writeFile(keyPath, ans);
	}
	static int[] readKeys(String keyPath) throws Exception{
		String ans = readFile(keyPath);
		int index = ans.indexOf(" ");
		if(index!=-1){
			String first = ans.substring(0, index);
			String second = ans.substring(index+1);
			int[] keys =  new int[2];
			try{
			keys[0] = Integer.parseInt(first);
			keys[1] = Integer.parseInt(second);
			}
			catch(Exception e){
				throw new invalidEncryptionKeyException("key have to be numbers");
			}
			return keys;
		}
		else{
			int[] keys =  new int[1];
			try{
				keys[0] = Integer.parseInt(ans);
			}
			catch(Exception e){
				throw new invalidEncryptionKeyException("key have to be numbers");
				
			}
			return keys; 
		}}
}