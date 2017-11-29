package com.cp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BicycleRentalRecordMapperExtra {

	List<Map<String, Object>> getRecords(
			@Param("userId") String userId);

}
