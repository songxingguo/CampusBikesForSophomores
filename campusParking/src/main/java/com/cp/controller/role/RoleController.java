package com.cp.controller.role;

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
import com.cp.dto.RoleDTO;
import com.cp.dto.search.RoleSearchDTO;
import com.cp.service.role.RoleService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Resource(name="roleServiceImpl")
	private RoleService roleService;
	
	/**
	 * 新增角色
	 * */
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public ResponseEntity<String> addRole(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated RoleDTO roleDTO, BindingResult rErrors) {
		if(liErrors.hasErrors() || rErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(roleService.addRole(roleDTO, loginInfoDTO.getUserId()))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改角色
	 * */
	@RequestMapping(value="/role", method=RequestMethod.PUT)
	public ResponseEntity<String> updateRole(
			@Validated RoleDTO roleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(roleService.updateRole(roleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查看
	 * */
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public ResponseEntity<String> getRole(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(roleService.getUser(id));
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping(value="/roles", method=RequestMethod.POST)
	public ResponseEntity<String> deleteRoles(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(roleService.deleteRoles(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 得到角色列表
	 * */
	@RequestMapping(value="/roles", method=RequestMethod.GET)
	public ResponseEntity<String> getRoles(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult lsErrors,
			RoleSearchDTO rsDTO) {
		if(liErrors.hasErrors() || lsErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(roleService.getRoles(loginInfoDTO, limitShowDTO, rsDTO));
	}
	
	/**
	 * 得到角色总数
	 * */
	@RequestMapping(value="/roles/count", method=RequestMethod.GET)
	public ResponseEntity<String> getRoleCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			RoleSearchDTO rsDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject result = new JSONObject();
		result.put(SystemConstants.TOTAL_ITEMS_KEY, roleService.getRolesCount(loginInfoDTO, rsDTO));
		
		return ResponseUtil.getResEntityForGet(result.toJSONString());
	}
}
