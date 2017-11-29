package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.DepartmentSearchDTO;

public interface DepartmentMapperExtra {

	String getMaxChildCode(
			@Param("parentCode") String parentCode);
	
	int updateHasChild(
			@Param("parentCode") String parentCode,
			@Param("hasChild") byte hasChild);

	Map<String, Object> getDepartmentById(
			@Param("id") String id);

	String getParentCodeById(
			@Param("id") String id);
	
	int getNumOfChild(
			@Param("parentCode") String parentCode);

	int deleteDepartments(
			@Param("ids") String[] ids);

	List<Map<String, Object>> getDepartments(
			@Param("operatorId") String userId, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage,
			@Param("dsDTO") DepartmentSearchDTO dsDTO);

}
