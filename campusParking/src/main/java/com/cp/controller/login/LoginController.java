package com.cp.controller.login;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.LoginDTO;
import com.cp.service.login.LoginService;
import com.cp.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	@RequestMapping(value="/loginForAdmin", method = RequestMethod.GET)
	public ResponseEntity<String> loginForAdmin(
			@Validated LoginDTO loginDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		Map<String, Object> result = loginService.loginForAdmin(loginDTO);
		
		return ResponseUtil.getResEntityForGetAndJson(result);
	}
	
	@RequestMapping(value="/loginForOrdinaryUser", method = RequestMethod.GET)
	public ResponseEntity<String> loginForOrdinaryUser(
			@Validated LoginDTO loginDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		Map<String, Object> result = loginService.loginForOrdinaryUser(loginDTO);
		
		return ResponseUtil.getResEntityForGetAndJson(result);
	}
}
