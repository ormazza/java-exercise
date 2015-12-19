package com.me.encryptorapp;

public class EncryptionLogEventArgs {
	String fileName;
	String encryptionName;
	boolean encrypt; // true=encrypt , false=decrypt
	boolean start; // true=start , false=finish
	long time;
	public EncryptionLogEventArgs(String fileName , String encryptionName , boolean encrypt , boolean start, long time){
		this.fileName = fileName;
		this.encryptionName = encryptionName;
		this.encrypt = encrypt;
		this.start = start;
		this.time = time;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass() != getClass())
			return false;
		EncryptionLogEventArgs other = (EncryptionLogEventArgs)obj;
		if(fileName != other.fileName)
			return false;
		if(encryptionName !=other.encryptionName)
			return false;
		if(encrypt != other.encrypt)
			return false;
		if(start != other.start)
			return false;
		if(time != other.time)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.fileName != null ? this.fileName.hashCode() : 0);
	    hash = 53 * hash + (this.encryptionName != null ? this.encryptionName.hashCode() : 0);
	    hash = 53 * hash + (this.encrypt ? 0 : 1);
	    hash = 53 * hash + (this.start ? 0 : 1);
	    hash = 53 * hash + (int)(this.time ^ (this.time >>> 32));
	    return hash;
	}
}