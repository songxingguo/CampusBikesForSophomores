package com.cp.util;

import java.util.Random;

public class StringUtil {
	
	private static final int DEFAULT_MAX_NUM = 100;
	
	private static Random random = new Random();
	

	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.equals(""))
			return true;
		
		return false;
	}
	
	public static String createTimestamp() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(System.nanoTime());
		sb.append(random.nextInt(DEFAULT_MAX_NUM));
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(createTimestamp());
	}
}
