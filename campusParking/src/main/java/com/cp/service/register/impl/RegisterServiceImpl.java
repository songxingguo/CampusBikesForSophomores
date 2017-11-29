package com.cp.service.register.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.cp.dto.FacultyDTO;
import com.cp.dto.RegisterDTO;
import com.cp.dto.StudentDTO;
import com.cp.dto.UserDTO;
import com.cp.model.User;
import com.cp.service.faculty.FacultyService;
import com.cp.service.register.RegisterService;
import com.cp.service.register.manager.AuthenticationCodeManager;
import com.cp.service.student.StudentService;
import com.cp.service.user.UserService;
import com.cp.util.CodeGenerator;
import com.cp.util.SystemConstants;
import com.cp.util.sms.ShortMessageService;

@Service
public class RegisterServiceImpl implements RegisterService {

	private static final int TEMPLATE_ID = 27713;
	
	private static final int STUDENT_FLAG = 0;
	
	private static final int FACULTY_FLAG = 1;
	
	private int effectiveTime;
	
	@Resource(name="shortMessageServiceImpl")
	private ShortMessageService shortMessageService;
	
	@Resource(name="authenticationCodeManager")
	private AuthenticationCodeManager authenticationCodeManager;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="studentServiceImpl")
	private StudentService studentService;
	
	@Resource(name="facultyServiceImpl")
	private FacultyService faucltyService;
	
	@Override
	public synchronized boolean sendAuthenticationCode(String phoneNumber) {
		JSONArray params = new JSONArray(2);
		
		String authenticationCode = CodeGenerator.generateAuthenticationCode();
		
		System.out.println(authenticationCode);
		
		params.add(authenticationCode);
		params.add(String.valueOf(effectiveTime / 60));
		
		System.out.println(shortMessageService.sendSingleMessageWithTemplate(phoneNumber, TEMPLATE_ID, params));
		
		authenticationCodeManager.saveAuthenticationCode(phoneNumber, authenticationCode);
		
		return true;
	}
	
	@Override
	public synchronized boolean register(RegisterDTO registerDTO) {
		if(authenticationCodeManager.checkAuthenticationCode(registerDTO.getPhoneNumber(), registerDTO.getAuthenticationCode())) {
			User user = userService.addUserAndReturn(toUserDTO(registerDTO));
			if(registerDTO.getRegisterType() == STUDENT_FLAG) {
				return studentService.addStudent(toStudentDTO(registerDTO, user.getId()));
			}
			
			if(registerDTO.getRegisterType() == FACULTY_FLAG) {
				return faucltyService.addFaculty(toFacultyDTO(registerDTO, user.getId()));
			}
		}
		
		return false;
	}
	
	private UserDTO toUserDTO(RegisterDTO registerDTO) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setCode(registerDTO.getPhoneNumber());
		userDTO.setRoleId(SystemConstants.NORMAL_USER_ROLE_ID);
		userDTO.setPassword(registerDTO.getPassword());
		
		return userDTO;
	}
	
	private StudentDTO toStudentDTO(RegisterDTO registerDTO, String userId) {
		StudentDTO studentDTO = new StudentDTO();
		
		studentDTO.setSchoolId(registerDTO.getSchoolId());
		studentDTO.setUserId(userId);
		
		return studentDTO;
	}
	
	private FacultyDTO toFacultyDTO(RegisterDTO registerDTO, String userId) {
		FacultyDTO facultyDTO = new FacultyDTO();
		
		facultyDTO.setSchoolId(registerDTO.getSchoolId());
		facultyDTO.setUserId(userId);
		
		return facultyDTO;
	}
	
	public void setEffectiveTime(int effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
}
