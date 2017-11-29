package com.cp.service.register.manager.impl;

import com.cp.service.register.manager.AuthenticationCodeManager;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class AuthenticationCodeManagerImpl implements AuthenticationCodeManager{

	protected JedisPool jedisPool;
	
	/**
	 * 验证码有效时间
	 * */
	private int effectiveTime;
	
	@Override
	public void saveAuthenticationCode(String phoneNumber, String authenticationCode) {
		Jedis jedis = jedisPool.getResource();
		jedis.setex(phoneNumber, effectiveTime, authenticationCode);
	}

	@Override
	public boolean checkAuthenticationCode(String phoneNumber, String autheticationCode) {
		Jedis jedis = jedisPool.getResource();
		String realAutheticationCode = jedis.get(phoneNumber);
		
		boolean result = realAutheticationCode.equals(autheticationCode);
		
		if(result)
			jedis.del(phoneNumber);
		
		return result;
	}
	
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	public void setEffectiveTime(int effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

}
