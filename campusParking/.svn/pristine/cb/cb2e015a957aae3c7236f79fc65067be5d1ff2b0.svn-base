package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.EmployeeSearchDTO;

public interface EmployeeMapperExtra {

	Map<String, Object> getEmployee(
			@Param("id") String id);

	int deleteEmployees(
			@Param("ids") String[] ids);

	List<Map<String, Object>> getEmployees(
			@Param("operatorId") String userId, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage,
			@Param("esDTO") EmployeeSearchDTO esDTO);

}
