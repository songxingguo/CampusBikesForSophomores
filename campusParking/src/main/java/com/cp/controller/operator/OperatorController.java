package com.cp.controller.operator;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.OperatorDTO;
import com.cp.dto.search.OperatorSearchDTO;
import com.cp.service.operator.OperatorService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@RestController
@RequestMapping("/api")
public class OperatorController {

	@Resource(name="operatorServiceImpl")
	private OperatorService operatorService;
	
	/**
	 * 新增运营商
	 * */
	@RequestMapping(value="/operator", method=RequestMethod.POST)
	public ResponseEntity<String> addOperator(
			@Validated OperatorDTO operatorDTO, BindingResult oErrors,
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors) {
		if(oErrors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(operatorService.addOperator(operatorDTO, loginInfoDTO.getUserId()))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改运营商
	 * */
	@RequestMapping(value="/operator", method=RequestMethod.PUT)
	public ResponseEntity<String> updateOperator(
			@Validated OperatorDTO operatorDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(operatorService.updateOperator(operatorDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查看运营商信息
	 * */
	@RequestMapping(value="/operator", method=RequestMethod.GET)
	public ResponseEntity<String> getOperator(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(operatorService.getOperator(id));
	}
	
	/**
	 * 删除运营商
	 * */
	@RequestMapping(value="/operator/del", method=RequestMethod.POST)
	public ResponseEntity<String> deleteOperator(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(operatorService.deleteOperators(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 根据条件获取运营商列表
	 * */
	@RequestMapping(value="/operators", method=RequestMethod.GET)
	public ResponseEntity<String> getOperators(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors,
			@Validated LimitShowDTO limitShowDTO, BindingResult lsErrors,
			OperatorSearchDTO osDTO) {
		if(lsErrors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(operatorService.getOperators(loginInfoDTO, limitShowDTO, osDTO));
	}
	
	/**
	 * 根据条件获取运营商总数
	 * */
	@RequestMapping(value="/operators/count", method=RequestMethod.GET)
	public ResponseEntity<String> getOperatorsCount(
			@Validated LoginInfoDTO loginInfoDTO, BindingResult errors,
			OperatorSearchDTO osDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		JSONObject result = new JSONObject();
		result.put(SystemConstants.TOTAL_ITEMS_KEY, operatorService.getOperatorsCount(loginInfoDTO, osDTO));
		
		return ResponseUtil.getResEntityForGet(result.toJSONString());
	}
}
