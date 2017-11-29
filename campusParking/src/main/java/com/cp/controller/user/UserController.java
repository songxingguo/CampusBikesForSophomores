package com.cp.controller.user;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.UserDTO;
import com.cp.dto.search.UserSearchDTO;
import com.cp.service.user.UserService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@RestController
@RequestMapping("/api/userManage")
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	/**
	 * 新增用户
	 * */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(
			@Validated UserDTO userDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(userService.addUser(userDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改用户
	 * */
	@RequestMapping(value="/user", method=RequestMethod.PUT)
	public ResponseEntity<String> updateUser(
			@Validated UserDTO userDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(userService.updateUser(userDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查看用户
	 * */
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<String> getUser(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(userService.getUser(id));
	}
	
	/**
	 * 删除用户
	 * */
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<String> deleteUsers(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(userService.deleteUsers(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 获取用户列表
	 * */
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<String> getUsers(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult lsErrors,
			UserSearchDTO usDTO) {
		if(lsErrors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(userService.getUsers(loginInfoDTO, limitShowDTO, usDTO));
	}
	
	/**
	 * 得到用户
	 * */
	@RequestMapping(value="/users/count", method=RequestMethod.GET)
	public ResponseEntity<String> getUsersCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			UserSearchDTO usDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject result = new JSONObject();
		result.put(SystemConstants.TOTAL_ITEMS_KEY, userService.getUsersCount(loginInfoDTO, usDTO));
		
		return ResponseUtil.getResEntityForGet(result.toJSONString());	
	}
}