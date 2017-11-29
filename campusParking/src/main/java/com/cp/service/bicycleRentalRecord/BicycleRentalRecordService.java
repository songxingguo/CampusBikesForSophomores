package com.cp.service.bicycleRentalRecord;

import java.util.List;
import java.util.Map;

import com.cp.dto.BicycleRentalRecordDTO;

public interface BicycleRentalRecordService {

	boolean addRecord(BicycleRentalRecordDTO brrDTO);

	boolean updateRecord(BicycleRentalRecordDTO brrDTO);

	List<Map<String, Object>> getRecords(String userId);

}
