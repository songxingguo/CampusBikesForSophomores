package com.cp.controller.school;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.SchoolDTO;
import com.cp.dto.search.SchoolSearchDTO;
import com.cp.service.school.SchoolService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class SchoolController {

	@Resource(name="schoolServiceImpl")
	private SchoolService schoolService;
	
	/**
	 * 新增
	 * */
	@RequestMapping(value="/school", method = RequestMethod.POST)
	public ResponseEntity<String> addSchool(
			@Validated SchoolDTO schoolDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(schoolService.addSchool(schoolDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 修改
	 * */
	@RequestMapping(value="/school", method = RequestMethod.PUT)
	public ResponseEntity<String> updateSchool(
			@Validated SchoolDTO schoolDTO, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(schoolService.updateSchool(schoolDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 删除
	 * */
	@RequestMapping(value="/school/del", method = RequestMethod.POST)
	public ResponseEntity<String> deleteSchools(String[] ids) {
		if(ids == null || ids.length == 0)
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(schoolService.deleteSchools(ids))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 查询
	 * */
	@RequestMapping(value="/school", method = RequestMethod.GET)
	public ResponseEntity<String> getSchool(String id) {
		if(StringUtil.isNullOrEmpty(id))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(schoolService.getSchool(id));
	}
	
	/**
	 * 根据条件获取学校列表
	 * */
	@RequestMapping(value="/schools", method = RequestMethod.GET)
	public ResponseEntity<String> getSchools(
			@Validated LimitShowDTO limitShowDTO, BindingResult errors,
			SchoolSearchDTO ssDTO) {
		if(errors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJsonArray(schoolService.getSchools(limitShowDTO, ssDTO));
	}
	
	/**
	 * 根据条件获取学校总数
	 * */
	@RequestMapping(value="/schools/count", method = RequestMethod.GET)
	public ResponseEntity<String> getSchoolsCount(SchoolSearchDTO ssDTO) {
		JSONObject json = new JSONObject();
		
		json.put("totalItems", schoolService.getSchoolsCount(ssDTO));
		
		return ResponseUtil.getResEntityForGet(json.toJSONString());
	}
	
	/**
	 * 更改学校所属的运营商
	 * */
	@RequestMapping(value="/school/operator", method = RequestMethod.PUT)
	public ResponseEntity<String> updateSchoolOperator(String schoolId, String operatorId) {
		if(StringUtil.isNullOrEmpty(operatorId) || StringUtil.isNullOrEmpty(schoolId))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(schoolService.updateSchoolOperator(schoolId, operatorId))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	/**
	 * 获取所以的学校的名字和id
	 * */
	@RequestMapping(value="/schoolsWithName", method = RequestMethod.GET)
	public ResponseEntity<String> getSchoolsWithName(String name) {
		return ResponseUtil.getResEntityForGetAndJsonArray(schoolService.getSchoolsWithName(name));
	}
}
