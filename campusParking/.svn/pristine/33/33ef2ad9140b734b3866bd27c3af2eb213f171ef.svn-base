package com.cp.controller.department;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.DepartmentDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.DepartmentSearchDTO;
import com.cp.service.department.DepartmentService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 新增部门
	 * */
	@RequestMapping(value="/department", method=RequestMethod.POST)
	public ResponseEntity<String> addDepartment(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated DepartmentDTO departmentDTO, BindingResult dErrors) {
		if(liErrors.hasErrors() || dErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(departmentService.addDepartment(loginInfoDTO, departmentDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改部门
	 * */
	@RequestMapping(value="/department", method=RequestMethod.PUT)
	public ResponseEntity<String> updateDepartment(
			@Validated DepartmentDTO departmentDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(departmentService.updateDepartment(departmentDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查看部门
	 * */
	@RequestMapping(value="/department", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartment(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(departmentService.getDepartment(id));
	}
	
	/**
	 * 删除部门
	 * */
	@RequestMapping(value="/departments", method=RequestMethod.POST)
	public ResponseEntity<String> deleteDepartments(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(departmentService.deleteDepartments(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 获取部门列表
	 * */
	@RequestMapping(value="/departments", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartments(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult lsErrors,
			DepartmentSearchDTO dsDTO) {
		if(liErrors.hasErrors() || lsErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(departmentService.getDepartments(loginInfoDTO, limitShowDTO, dsDTO));
	}
	
	/**
	 * 得到部门总数
	 * */
	@RequestMapping(value="/departments/count", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartmentsCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			DepartmentSearchDTO dsDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject json = new JSONObject();
		json.put(SystemConstants.TOTAL_ITEMS_KEY, departmentService.getDepartmentsCount(loginInfoDTO, dsDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
}
