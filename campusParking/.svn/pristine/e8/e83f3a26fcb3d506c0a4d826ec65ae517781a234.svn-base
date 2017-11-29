package com.cp.dao;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

	String loginForAdmin(
			@Param("code") String code, 
			@Param("password") String password, 
			@Param("roleId") String normalUserRoleId);

	String loginForOrdinaryUser(
			@Param("code") String code, 
			@Param("password") String password, 
			@Param("roleId") String normalUserRoleId);

}
