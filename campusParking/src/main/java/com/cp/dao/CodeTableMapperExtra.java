package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.CodeTableSearchDTO;

public interface CodeTableMapperExtra {

	String getMaxChildCode(
			@Param("parentCode") String parentCode);

	int updateHasChild(
			@Param("code") String code,
			@Param("hasChild") byte hasChild);

	int deleteCodeTables(
			@Param("codes") String[] codes);

	String getParentCodeByCode(
			@Param("code") String code);

	int getChildNumByCode(
			@Param("code") String code);

	Map<String, Object> getCodeTable(
			@Param("code") String code);

	List<Map<String, Object>> getCodeTables(
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage, 
			@Param("ctsDTO") CodeTableSearchDTO ctsDTO);
	

}
