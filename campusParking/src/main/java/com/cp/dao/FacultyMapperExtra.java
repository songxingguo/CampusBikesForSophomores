package com.cp.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FacultyMapperExtra {

	String getIdByUserId(
			@Param("userId") String userId);

	Map<String, Object> getFacultyByUserId(
			@Param("userId") String userId);

}
