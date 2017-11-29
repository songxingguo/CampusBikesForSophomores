package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.ModuleSearchDTO;

public interface ModuleMapperExtra {

	String getMaxChildCode(
			@Param("code") String code);

	int updateHasChild(
			@Param("code") String parentCode, 
			@Param("hasChild") byte hasChild);

	String[] getCodesByIds(
			@Param("ids") String[] ids);

	int deleteModuleAndChildren(
			@Param("code") String code);

	Map<String, Object> getModule(
			@Param("id") String id);

	List<Map<String, Object>> getModules(
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage, 
			@Param("msDTO") ModuleSearchDTO msDTO);
	

}
