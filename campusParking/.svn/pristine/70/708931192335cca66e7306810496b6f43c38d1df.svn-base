package com.cp.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 生成JsonWebToken
 * 参照NewCar
 * */
public class JwtUtil {

	/**
	 * 生成JsonWebToken
	 * @param id 此处默认该项为用户id
	 * @param issuer 签发者
	 * @param subject 面向用户
	 * @param tokenExpirationSeconds 过期时间
	 * @param apiKey 自定义的密匙
	 * @return String 
	 * */
	public static String createJWT(String id, String issuer, String subject, long tokenExpirationSeconds, String apiKey) {
		//签名算法
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		 
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		 
		JwtBuilder builder = Jwts.builder().setId(id)
		                                .setIssuedAt(now)
		                                .setSubject(subject)
		                                .setIssuer(issuer)
		                                .signWith(signatureAlgorithm, signingKey);
		 
		if (tokenExpirationSeconds >= 0) {
		    long expMillis = nowMillis + tokenExpirationSeconds;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		 
		return builder.compact();
	}
	
}
