package com.plox.esportsystem.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentication {
	
	public String hash(String password) 
	{
			MessageDigest messagedigest;
			StringBuilder stringbuilder = new StringBuilder(32);
			try {
				messagedigest = MessageDigest.getInstance("MD5");
				messagedigest.update(password.getBytes());
			    byte [] digest = messagedigest.digest();
			    
			    for (int i = 0; i < digest.length; i++) 
			    {
			    	stringbuilder.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
			    }
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return stringbuilder.toString();     
	}
}