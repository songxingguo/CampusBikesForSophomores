package com.cp.service.bicycleRentalRecord.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.BicycleRentalRecordMapper;
import com.cp.dao.BicycleRentalRecordMapperExtra;
import com.cp.dto.BicycleRentalRecordDTO;
import com.cp.model.BicycleRentalRecord;
import com.cp.service.bicycleRentalRecord.BicycleRentalRecordService;
import com.cp.util.StringUtil;

@Service
public class BicycleRentalRecordServiceImpl implements BicycleRentalRecordService {

	@Resource(name="bicycleRentalRecordMapper")
	private BicycleRentalRecordMapper bicycleRentalRecordMapper;
	
	@Resource(name="bicycleRentalRecordMapperExtra")
	private BicycleRentalRecordMapperExtra bicycleRentalRecordMapperExtra;
	
	@Override
	@Transactional
	public synchronized boolean addRecord(BicycleRentalRecordDTO brrDTO) {
		BicycleRentalRecord brr = new BicycleRentalRecord();
		
		brr.setId(StringUtil.createTimestamp());
		brr.setStartTime(new Date());
		brr.setUserId(brrDTO.getUserId());
		brr.setBicycleId(brrDTO.getBicycleId());
		
		return bicycleRentalRecordMapper.insertSelective(brr) > 0;
	}

	@Override
	@Transactional
	public synchronized boolean updateRecord(BicycleRentalRecordDTO brrDTO) {
		BicycleRentalRecord brr = new BicycleRentalRecord();
		
		brr.setId(brrDTO.getId());
		brr.setEndTime(new Date());
		brr.setConsumptiveMoney(20);
		
		return bicycleRentalRecordMapper.updateByPrimaryKeySelective(brr) > 0;
	}

	@Override
	public List<Map<String, Object>> getRecords(String userId) {
		
		return bicycleRentalRecordMapperExtra.getRecords(userId);
	}

}
