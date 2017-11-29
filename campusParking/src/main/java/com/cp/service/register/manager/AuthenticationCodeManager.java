package com.cp.service.register.manager;

public interface AuthenticationCodeManager {

	void saveAuthenticationCode(String phoneNumber, String authenticationCode);
	
	boolean checkAuthenticationCode(String phoneNumber, String autheticationCode);
}
