package com.cp.service.bicycle.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.BicycleMapper;
import com.cp.dao.BicycleMapperExtra;
import com.cp.dto.BicycleDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.BicycleSearchDTO;
import com.cp.model.Bicycle;
import com.cp.service.bicycle.BicycleService;
import com.cp.util.DateUtil;
import com.cp.util.StringUtil;

@Service
public class BicycleServiceImpl implements BicycleService{

	@Resource(name="bicycleMapper")
	private BicycleMapper bicycleMapper;
	
	@Resource(name="bicycleMapperExtra")
	private BicycleMapperExtra bicycleMapperExtra;
	
	@Override
	public boolean addBicycle(BicycleDTO bicycleDTO) {
		Bicycle bicycle = toBicycle(bicycleDTO);
		
		bicycle.setId(StringUtil.createTimestamp());
		
		return bicycleMapper.insertSelective(toBicycle(bicycleDTO)) > 0;
	}
	
	private Bicycle toBicycle(BicycleDTO bicycleDTO) {
		Bicycle bicycle = new Bicycle();
		
		bicycle.setId(bicycleDTO.getId());
		bicycle.setBicycleNo(bicycleDTO.getBicycleNo());
		bicycle.setBicycleType(bicycleDTO.getBicycleType());
		bicycle.setBrand(bicycleDTO.getBrand());
		bicycle.setOperatorId(bicycleDTO.getOperatorId());
		bicycle.setEntryTime(DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", bicycleDTO.getBrand()));
		
		return bicycle;
	}

	@Override
	public boolean addBicycles(BicycleDTO bicycleDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBicycle(BicycleDTO bicycleDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBicycles(String[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getCodeTable(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getBicycles(LimitShowDTO limitShowDTO, LoginInfoDTO loginInfoDTO,
			BicycleSearchDTO bsDTO) {
		
		return bicycleMapperExtra.getBicycles(loginInfoDTO.getUserId(), limitShowDTO.caculateStart(),
				limitShowDTO.getItemPerPage(), bsDTO);
	}

	@Override
	public int getBicyclesCount(BicycleSearchDTO bsDTO, LoginInfoDTO loginInfoDTO) {
		List<Map<String, Object>> reuslt = bicycleMapperExtra.getBicycles(loginInfoDTO.getUserId(), -1,
				-1, bsDTO);
		
		return reuslt == null ? 0 : reuslt.size();
	}

}
