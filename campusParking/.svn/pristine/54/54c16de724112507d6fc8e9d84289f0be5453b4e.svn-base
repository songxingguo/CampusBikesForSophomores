package com.cp.controller.bicycle;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.BicycleDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.BicycleSearchDTO;
import com.cp.service.bicycle.BicycleService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class BicycleController {

	@Resource(name="bicycleServiceImpl")
	private BicycleService bicycleService;
	
	/**
	 * 新增
	 * */
	@RequestMapping(value="/bicycle", method = RequestMethod.POST)
	public ResponseEntity<String> addBicycle(
			@Validated BicycleDTO bicycleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleService.addBicycle(bicycleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 批量新增
	 * */
	@RequestMapping(value="/bicycles", method = RequestMethod.POST)
	public ResponseEntity<String> addBicycles(
			@Validated BicycleDTO bicycleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleService.addBicycles(bicycleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改
	 * */
	@RequestMapping(value="/bicycle", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBicycle(
			@Validated BicycleDTO bicycleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleService.updateBicycle(bicycleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping(value="/bicycles/del", method = RequestMethod.POST)
	public ResponseEntity<String> deleteBicycles(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(bicycleService.deleteBicycles(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查询
	 * */
	@RequestMapping(value="/bicycle", method = RequestMethod.GET)
	public ResponseEntity<String> getBicycle(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(bicycleService.getCodeTable(id));
	}
	
	/**
	 * 根据条件获取自行车列表
	 * */
	@RequestMapping(value="/bicycles", method = RequestMethod.GET)
	public ResponseEntity<String> getBicycles(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult errors,
			BicycleSearchDTO bsDTO) {
		if(errors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(bicycleService.getBicycles(limitShowDTO, loginInfoDTO, bsDTO));
	}
	
	/**
	 * 根据条件获取自行车总数
	 * */
	@RequestMapping(value="/bicycles/count", method = RequestMethod.GET)
	public ResponseEntity<String> getBicyclesCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			BicycleSearchDTO bsDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject json = new JSONObject();
		
		json.put("totalItems", bicycleService.getBicyclesCount(bsDTO, loginInfoDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
}
