package com.cp.service.employee;

import java.util.List;
import java.util.Map;

import com.cp.dto.EmployeeDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.EmployeeSearchDTO;

public interface EmployeeService {

	boolean addEmployee(EmployeeDTO employeeDTO);

	boolean updateEmployee(EmployeeDTO employeeDTO);

	Map<String, Object> getEmployee(String id);

	boolean deleteEmployees(String[] ids);

	List<Map<String, Object>> getEmployees(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			EmployeeSearchDTO esDTO);

	int getEmployeesCount(LoginInfoDTO loginInfoDTO, EmployeeSearchDTO esDTO);

}
