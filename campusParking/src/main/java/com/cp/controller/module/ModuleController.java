package com.cp.controller.module;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.ModuleDTO;
import com.cp.dto.search.ModuleSearchDTO;
import com.cp.service.module.ModuleService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class ModuleController {
	@Resource(name="moduleServiceImpl")
	private ModuleService moduleService;
	
	/**
	 * 新增
	 * */
	@RequestMapping(value="/addModule", method = RequestMethod.POST)
	public ResponseEntity<String> addModule(
			@Validated ModuleDTO moduleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(moduleService.addModule(moduleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改
	 * */
	@RequestMapping(value="/updateModule", method = RequestMethod.PUT)
	public ResponseEntity<String> updateModule(
			@Validated ModuleDTO moduleDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(moduleService.updateModule(moduleDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping(value="/deleteModules", method = RequestMethod.POST)
	public ResponseEntity<String> deleteModules(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(moduleService.deleteModules(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查询
	 * */
	@RequestMapping(value="/searchModule", method = RequestMethod.GET)
	public ResponseEntity<String> getCodeTable(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(moduleService.getModule(id));
	}
	
	/**
	 * 根据条件获取模块列表
	 * */
	@RequestMapping(value="/modules", method = RequestMethod.GET)
	public ResponseEntity<String> getSchools(
			@Validated LimitShowDTO limitShowDTO, BindingResult errors,
			ModuleSearchDTO msDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		List<Map<String, Object>> data = moduleService.getModules(limitShowDTO, msDTO);
		return ResponseUtil.getResEntityForGetAndJsonArray(data);
	}
	
	/**
	 * 根据条件获取模块总数
	 * */
	@RequestMapping(value="/modules/count", method = RequestMethod.GET)
	public ResponseEntity<String> getSchoolsCount(ModuleSearchDTO msDTO) {
		JSONObject json = new JSONObject();
		
		json.put("totalItems", moduleService.getModulesCount(msDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
	
	/**
	 * 根据条件获取模块列表
	 * */
	@RequestMapping(value="/getMenu", method = RequestMethod.GET)
	public ResponseEntity<String> getSchools() {
		
		List<Map<String, Object>> data = moduleService.getMenu(-1,-1);
		
		return ResponseUtil.getResEntityForGetAndJsonArray(data);
	}
}