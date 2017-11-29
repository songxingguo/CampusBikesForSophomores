package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.RoleSearchDTO;

public interface RoleMapperExtra {

	Map<String, Object> getRoleById(
			@Param("id") String id);

	int deleteRoles(
			@Param("ids") String[] ids);

	List<Map<String, Object>> getRoles(
			@Param("creatorId") String creatorId, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage, 
			@Param("rsDTO") RoleSearchDTO rsDTO);

}
