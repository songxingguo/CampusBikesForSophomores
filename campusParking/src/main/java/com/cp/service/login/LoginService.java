package com.cp.service.login;

import java.util.Map;

import com.cp.dto.LoginDTO;

public interface LoginService {

	Map<String, Object> loginForAdmin(LoginDTO loginDTO);

	Map<String, Object> loginForOrdinaryUser(LoginDTO loginDTO);

}
