package com.cp.service.bicycle;

import java.util.List;
import java.util.Map;

import com.cp.dto.BicycleDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.BicycleSearchDTO;

public interface BicycleService {

	boolean addBicycle(BicycleDTO bicycleDTO);

	boolean addBicycles(BicycleDTO bicycleDTO);

	boolean updateBicycle(BicycleDTO bicycleDTO);

	boolean deleteBicycles(String[] ids);

	Map<String, Object> getCodeTable(String id);

	List<Map<String, Object>> getBicycles(LimitShowDTO limitShowDTO, LoginInfoDTO loginInfoDTO, BicycleSearchDTO bsDTO);

	int getBicyclesCount(BicycleSearchDTO bsDTO, LoginInfoDTO loginInfoDTO);

}
