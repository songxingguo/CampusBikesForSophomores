package com.cp.service.login.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.authorization.manager.TokenManager;
import com.cp.dao.LoginMapper;
import com.cp.dto.LoginDTO;
import com.cp.service.login.LoginService;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource(name="loginMapper")
	private LoginMapper loginMapper;
	
	@Resource(name="redisTokenManager")
	private TokenManager tokenManager;
	
	@Override
	public Map<String, Object> loginForAdmin(LoginDTO loginDTO) {
		String userId = loginMapper.loginForAdmin(loginDTO.getCode(), loginDTO.getPassword(), 
				SystemConstants.NORMAL_USER_ROLE_ID);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(!StringUtil.isNullOrEmpty(userId)) {
			result.put("userId", userId);
			result.put("token", tokenManager.createToken(userId));
			
			return result;
		}
		
		result.put("status", false);
		
		return result;
	}

	@Override
	public Map<String, Object> loginForOrdinaryUser(LoginDTO loginDTO) {
		String userId = loginMapper.loginForOrdinaryUser(loginDTO.getCode(), loginDTO.getPassword(), 
				SystemConstants.NORMAL_USER_ROLE_ID);
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(!StringUtil.isNullOrEmpty(userId)) {
			result.put("userId", userId);
			result.put("token", tokenManager.createToken(userId));
			
			return result;
		}
		
		result.put("status", false);
		
		return result;
	}

}
