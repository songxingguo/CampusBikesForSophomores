package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cp.dto.search.BicycleSearchDTO;

public interface BicycleMapperExtra {

	List<Map<String, Object>> getBicycles(
			@Param("operatorId") String userId, 
			@Param("start") int caculateStart, 
			@Param("end") int itemPerPage, 
			@Param("bsDTO") BicycleSearchDTO bsDTO);

}
