package com.cp.util.sms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataProcessing {
	
	private final static String SHA_256_ALGORTHM = "SHA-256";

	public static String strToHash(String str) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(SHA_256_ALGORTHM);
			 byte[] inputByteArray = str.getBytes();
		     messageDigest.update(inputByteArray);
		     byte[] resultByteArray = messageDigest.digest();
		     return byteArrayToHex(resultByteArray);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }
}
