package com.cp.controller.faculty;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.FacultyDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.service.faculty.FacultyService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping("/api")
public class FacultyController {

	@Resource(name="facultyServiceImpl")
	private FacultyService facultyService;
	

	@RequestMapping(value="/faculty", method = RequestMethod.PUT)
	public ResponseEntity<String> updateFaculty(
			@Validated FacultyDTO facultyDTO, BindingResult errors,
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors) {
		if(errors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(facultyService.updateFaculty(facultyDTO, loginInfoDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	@RequestMapping(value="/faculty", method = RequestMethod.GET)
	public ResponseEntity<String> getFaculty(String userId) {
		if(StringUtil.isNullOrEmpty(userId))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(facultyService.getFacultyByUserId(userId));
	}
}
