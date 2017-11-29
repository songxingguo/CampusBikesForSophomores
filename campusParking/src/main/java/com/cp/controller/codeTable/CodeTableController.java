package com.cp.controller.codeTable;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.CodeTableDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.search.CodeTableSearchDTO;
import com.cp.service.codeTable.CodeTableService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class CodeTableController {
	@Resource(name="codeTableServiceImpl")
	private CodeTableService codeTableService;
	
	/**
	 * 新增
	 * */
	@RequestMapping(value="/codeTable", method = RequestMethod.POST)
	public ResponseEntity<String> addCodeTable(
			@Validated CodeTableDTO codeTableDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(codeTableService.addCodeTable(codeTableDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改
	 * */
	@RequestMapping(value="/codeTable", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCodeTable(
			@Validated CodeTableDTO codeTableDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(codeTableService.updateCodeTable(codeTableDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping(value="/codeTables", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCodeTables(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(codeTableService.deleteCodeTables(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查询
	 * */
	@RequestMapping(value="/codeTable", method = RequestMethod.GET)
	public ResponseEntity<String> getCodeTable(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(codeTableService.getCodeTable(id));
	}
	
	/**
	 * 根据条件获取码表列表
	 * */
	@RequestMapping(value="/codeTables", method = RequestMethod.GET)
	public ResponseEntity<String> getCodeTables(
			@Validated LimitShowDTO limitShowDTO, BindingResult errors,
			CodeTableSearchDTO ctsDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(codeTableService.getCodeTables(limitShowDTO, ctsDTO));
	}
	
	/**
	 * 根据条件获取码表总数
	 * */
	@RequestMapping(value="/codeTables/count", method = RequestMethod.GET)
	public ResponseEntity<String> getCodeTablesCount(CodeTableSearchDTO ctsDTO) {
		JSONObject json = new JSONObject();
		
		json.put("totalItems", codeTableService.getCodeTablesCount(ctsDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
}
