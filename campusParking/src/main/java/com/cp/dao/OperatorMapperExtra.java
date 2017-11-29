package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.OperatorSearchDTO;

public interface OperatorMapperExtra {

	/**
	 * 根据userId获取运营商的code值
	 * */
	String getCodeByUserId(
			@Param("userId") String userId);

	/**
	 * 根据parentCode找到其下面最大的孩子的code
	 * */
	String getMaxChildCodeByParentCode(
			@Param("parentCode") String parentCode);

	int updateHasChildByUserId(
			@Param("userId") String userId,
			@Param("hasChild") byte hasChild);

	Map<String, Object> getOperator(
			@Param("id") String id);

	int deleteOperators(
			@Param("ids") String[] ids);

	List<Map<String, Object>> getOperators(
			@Param("parentCode") String parentCode, 
			@Param("start") int caculateStart, 
			@Param("end") int curItemPerPage,
			@Param("osDTO") OperatorSearchDTO osDTO);
}
