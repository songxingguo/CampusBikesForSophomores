package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.UserSearchDTO;

public interface UserMapperExtra {

	Map<String, Object> getUserById(
			@Param("id") String id);

	int deleteUsers(
			@Param("ids") String[] ids);

	List<Map<String, Object>> getUsers(
			@Param("userId") String userId, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage, 
			@Param("usDTO") UserSearchDTO usDTO);

}
