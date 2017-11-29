package com.cp.controller.student;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.dto.LoginInfoDTO;
import com.cp.dto.StudentDTO;
import com.cp.service.student.StudentService;
import com.cp.util.ResponseUtil;
import com.cp.util.StringUtil;

@RestController
@RequestMapping(value="/api")
public class StudentController {

	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	
	@RequestMapping(value="/updateStudent", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent(
			@Validated StudentDTO studentDTO, BindingResult errors,
			@Validated LoginInfoDTO loginInfoDTO, BindingResult liErrors) {
		if(errors.hasErrors() || liErrors.hasErrors())
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		if(studentService.updateStudent(studentDTO, loginInfoDTO))
			return ResponseUtil.getResEntityForPPPWhenSuccess();
		
		return ResponseUtil.getResEntityForPPPWhenFail();
	}
	
	@RequestMapping(value="/student", method = RequestMethod.GET)
	public ResponseEntity<String> getStudent(String userId) {
		if(StringUtil.isNullOrEmpty(userId))
			return ResponseUtil.getResponseEntityWhenInvalidReqParams();
		
		return ResponseUtil.getResEntityForGetAndJson(studentService.getStudentByUserId(userId));
	}
}