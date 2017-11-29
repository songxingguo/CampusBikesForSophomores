package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.SchoolSearchDTO;

public interface SchoolMapperExtra {

	int deleteSchoolsByIds(
			@Param("ids") String[] ids);

	Map<String, Object> getSchool(
			@Param("id") String id);

	List<Map<String, Object>> getSchools(
			@Param("ssDTO") SchoolSearchDTO ssDTO, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage);

	int updateSchoolOperator(
			@Param("schoolId") String schoolId, 
			@Param("operatorId") String operatorId);

	List<Map<String, Object>> getSchoolsWithName(
			@Param("name") String name);
}
