package com.cp.util;

import java.util.Random;

public class CodeGenerator {

	private static final String INIT_CODE = "0001";
	
	private static String INIT_BICYCLE_NO = "0001";
	
	private static final int INIT_LENGTH = 4;
	
	private static final Random random = new Random();
	
	private static final int MAX_NICKNAME_SUFFIX = 10000;
	
	private static final int NICKNAME_PRIFIX_LENGTH = 5;
	
	private static final String CONNECTOR = "_";
	
	private static String letteres = "abcdefghijklmnopqrstuvwxyz";
	
	private static int letterNum = 26;
	
	/**
	 * 生成没有父节点的code值
	 * @param code 和该节点同级的最大的code值
	 * @return String
	 * */
	public static String generateCodeWithoutParentCode(String code) {
		if(StringUtil.isNullOrEmpty(code))
			return INIT_CODE;
		
		String order = String.valueOf(Integer.valueOf(code) + 1);
		
		return code.substring(0, INIT_LENGTH - order.length()).concat(order);
	}
	
	/**
	 * 生成有父节点的code值
	 * @param parentCode 父节点的code值
	 * @param code 和该节点同级的最大的code值
	 * @return String
	 * */
	public static String generateCodeWithParentCode(String parentCode, String code) {
		if(StringUtil.isNullOrEmpty(parentCode))
			return generateCodeWithoutParentCode(code);
		
		return parentCode.concat(generateCodeWithoutParentCode(code));
	}
	
	/**
	 * 生成用户昵称
	 * */
	public static String generateNickname() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(generateLetters());
		sb.append(CONNECTOR);
		sb.append(random.nextInt(MAX_NICKNAME_SUFFIX));
		
		return sb.toString();
	}
	
	/**
	 * 随机生成字符串
	 * */
	public static String generateLetters() {
		return generateLetters(NICKNAME_PRIFIX_LENGTH);
	}
	
	public static String generateLetters(int strLength) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < strLength; i++) {
			sb.append(letteres.charAt(random.nextInt(letterNum)));
		}
		
		return sb.toString();
	}
	
	/**
	 * 生成自行车编号
	 * */
	public static String generateBicycleNo() {
		StringBuffer sb = new StringBuffer();
		
		sb.append(generateLetters());
		sb.append(random.nextInt(MAX_NICKNAME_SUFFIX));
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(generateCodeWithParentCode("0001","0009"));
		System.out.println(generateNickname());
	}

	/**
	 * 生成验证码
	 * */
	public static String generateAuthenticationCode() {
		
		return String.valueOf(random.nextInt(10000));
	}
}
