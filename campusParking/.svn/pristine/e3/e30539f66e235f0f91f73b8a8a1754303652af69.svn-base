package com.cp.authorization.manager;

/**
 * 大部分参考ScienJus的博客和GitHub
 * bloc http://www.scienjus.com/restful-token-authorization/
 * GitHub https://github.com/ScienJus/spring-restful-authorization
 * */
public interface TokenManager {

	/**
	 * 给指定用户生成token
	 * @param userId 指定用户的id
	 * @return 生成的token值
	 * */
	String createToken(String userId);
	
	/**
	 * 删除指定用户关联的token
	 * @param userId 指定用户的id
	 * */
	void deleteToken(String userId);
	
	/**
	 * 检查token值是否有效
	 * @return 是否有效
	 * */
	boolean checkToken(String token);
	
	/**
	 * 根据token值获取key
	 * @return key
	 * */
	String getKey(String value);
}
