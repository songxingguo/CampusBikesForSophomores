package com.cp.controller.employee;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.EmployeeDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.EmployeeSearchDTO;
import com.cp.service.employee.EmployeeService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Resource(name="employeeServiceImpl")
	private EmployeeService employeeService;
	
	/**
	 * 新增员工
	 * */
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public ResponseEntity<String> addEmployee(
			@Validated EmployeeDTO employeeDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(employeeService.addEmployee(employeeDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改员工
	 * */
	@RequestMapping(value="/employee", method=RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(
			@Validated EmployeeDTO employeeDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(employeeService.updateEmployee(employeeDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查看员工
	 * */
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartment(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(employeeService.getEmployee(id));
	}
	
	/**
	 * 删除员工
	 * */
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public ResponseEntity<String> deleteDepartments(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(employeeService.deleteEmployees(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 获取员工列表
	 * */
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartments(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult lsErrors,
			EmployeeSearchDTO esDTO) {
		if(liErrors.hasErrors() || lsErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(employeeService.getEmployees(loginInfoDTO, limitShowDTO, esDTO));
	}
	
	/**
	 * 得到员工总数
	 * */
	@RequestMapping(value="/employees/count", method=RequestMethod.GET)
	public ResponseEntity<String> getDepartmentsCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			EmployeeSearchDTO esDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject json = new JSONObject();
		json.put(SystemConstants.TOTAL_ITEMS_KEY, employeeService.getEmployeesCount(loginInfoDTO, esDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
}
