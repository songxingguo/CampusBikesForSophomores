package com.cp.service.department;

import java.util.List;
import java.util.Map;

import com.cp.dto.DepartmentDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.DepartmentSearchDTO;

public interface DepartmentService {

	boolean addDepartment(LoginInfoDTO loginInfoDTO, DepartmentDTO departmentDTO);

	boolean updateDepartment(DepartmentDTO departmentDTO);

	Map<String, Object> getDepartment(String id);

	boolean deleteDepartments(String[] ids);

	List<Map<String, Object>> getDepartments(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			DepartmentSearchDTO dsDTO);

	int getDepartmentsCount(LoginInfoDTO loginInfoDTO, DepartmentSearchDTO dsDTO);

}
