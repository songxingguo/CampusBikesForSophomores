package com.cp.controller.register;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.RegisterDTO;
import com.cp.service.register.RegisterService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class RegisterController {
	
	@Resource(name="registerServiceImpl")
	private RegisterService registerService;

	/**
	 * 发送验证码
	 * */
	@RequestMapping(value="/authenticationCode", method = RequestMethod.POST)
	public ResponseEntity<String> sendAuthenticationCode(String phoneNumber) {
		if(StringUtil.isNullOrEmpty(phoneNumber))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(registerService.sendAuthenticationCode(phoneNumber))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 注册
	 * */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(
			@Validated RegisterDTO registerDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(registerService.register(registerDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
}
