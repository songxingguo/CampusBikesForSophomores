package com.cp.service.employee.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.EmployeeMapper;
import com.cp.dao.EmployeeMapperExtra;
import com.cp.dto.EmployeeDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.UserDTO;
import com.cp.dto.search.EmployeeSearchDTO;
import com.cp.model.Employee;
import com.cp.model.User;
import com.cp.service.employee.EmployeeService;
import com.cp.service.user.UserService;
import com.cp.util.StringUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;
	
	@Resource(name="employeeMapperExtra")
	private EmployeeMapperExtra employeeMapperExtra;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Override
	public synchronized boolean addEmployee(EmployeeDTO employeeDTO) {
		User user = userService.addUserAndReturn(toUserDTO(employeeDTO));
		
		Employee employee = toEmployee(employeeDTO);
		
		employee.setId(StringUtil.createTimestamp());
		employee.setUserId(user.getId());
		
		return employeeMapper.insertSelective(employee) > 0;
	}
	
	private UserDTO toUserDTO(EmployeeDTO employeeDTO) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(employeeDTO.getUserId());
		userDTO.setCode(employeeDTO.getPhone());
		userDTO.setRoleId(employeeDTO.getRoleId());
		
		return userDTO;
	}
	
	private Employee toEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		
		employee.setId(employeeDTO.getId());
		employee.setDepartmentId(employeeDTO.getDepartmentId());
		employee.setEmployeeNo(employeeDTO.getEmployeeNo());
		employee.setIdNo(employeeDTO.getIdNo());
		employee.setName(employeeDTO.getName());
		employee.setPhone(employeeDTO.getPhone());
		employee.setUserId(employeeDTO.getUserId());
		employee.setSex(employeeDTO.getSex());
		
		return employee;
	}

	@Override
	public boolean updateEmployee(EmployeeDTO employeeDTO) {
		
		return employeeMapper.updateByPrimaryKeySelective(toEmployee(employeeDTO)) > 0;
	}

	@Override
	public Map<String, Object> getEmployee(String id) {
		
		return employeeMapperExtra.getEmployee(id);
	}

	@Override
	public boolean deleteEmployees(String[] ids) {
		
		return employeeMapperExtra.deleteEmployees(ids) > 0;
	}

	@Override
	public List<Map<String, Object>> getEmployees(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			EmployeeSearchDTO esDTO) {
		
		return employeeMapperExtra.getEmployees(loginInfoDTO.getUserId(), limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), esDTO);
	}

	@Override
	public int getEmployeesCount(LoginInfoDTO loginInfoDTO, EmployeeSearchDTO esDTO) {
		List<Map<String, Object>> result = employeeMapperExtra.getEmployees(loginInfoDTO.getUserId(), -1, -1, esDTO);
		
		return result == null ? 0 : result.size();
	}

}
