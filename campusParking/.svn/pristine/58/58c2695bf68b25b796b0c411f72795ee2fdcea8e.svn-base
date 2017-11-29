package com.cp.controller.bicycleRentalRecord;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.BicycleRentalRecordDTO;
import com.cp.service.bicycleRentalRecord.BicycleRentalRecordService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class BicycleRentalRecordController {

	@Resource(name="bicycleRentalRecordServiceImpl")
	private BicycleRentalRecordService bicycleRentalRecordService;
	
	@RequestMapping(value="/startOrder", method = RequestMethod.POST)
	public ResponseEntity<String> addRentalRecord(
			@Validated BicycleRentalRecordDTO brrDTO, BindingResult brrErrors) {
		if(brrErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleRentalRecordService.addRecord(brrDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();	
	}
	
	@RequestMapping(value="/endOrder", method = RequestMethod.PUT)
	public ResponseEntity<String> updateRentalRecord(
			@Validated BicycleRentalRecordDTO brrDTO, BindingResult brrErrors) {
		if(brrErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleRentalRecordService.updateRecord(brrDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();	
	}
	
	@RequestMapping(value="/rentanRecords", method = RequestMethod.GET)
	public ResponseEntity<String> getRecords(String userId) {
		if(StringUtil.isNullOrEmpty(userId))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(bicycleRentalRecordService.getRecords(userId));
	}
}
