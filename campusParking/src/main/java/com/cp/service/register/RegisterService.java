package com.cp.service.register;

import com.cp.dto.RegisterDTO;

public interface RegisterService {

	boolean sendAuthenticationCode(String phoneNumber);

	boolean register(RegisterDTO registerDTO);

}
