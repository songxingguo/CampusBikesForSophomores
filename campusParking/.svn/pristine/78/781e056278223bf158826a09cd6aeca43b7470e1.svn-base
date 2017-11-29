package com.cp.service.student.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.StudentMapper;
import com.cp.dao.StudentMapperExtra;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.StudentDTO;
import com.cp.model.Student;
import com.cp.service.student.StudentService;
import com.cp.util.StringUtil;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource(name="studentMapper")
	private StudentMapper studentMapper;
	
	@Resource(name="studentMapperExtra")
	private StudentMapperExtra studentMapperExtra;

	@Override
	public synchronized boolean addStudent(StudentDTO studentDTO) {
		Student student = toStudent(studentDTO);
		
		student.setId(StringUtil.createTimestamp());
		
		return false;
	}
	
	private Student toStudent(StudentDTO studentDTO) {
		Student student = new Student();
		
		student.setId(studentDTO.getId());
		student.setAcademy(studentDTO.getAcademy());
		student.setIdNo(studentDTO.getIdNo());
		student.setName(studentDTO.getName());
		student.setSchoolId(studentDTO.getSchoolId());
		student.setSex(studentDTO.getSex());
		student.setSpecialty(studentDTO.getSpecialty());
		student.setStudentNo(studentDTO.getStudentNo());
		student.setUserId(studentDTO.getUserId());
		
		return student;
	}

	@Override
	public synchronized boolean updateStudent(StudentDTO studentDTO, LoginInfoDTO loginInfoDTO) {
		String stuId = studentMapperExtra.getIdByUserId(loginInfoDTO.getUserId());
		
		Student student = toStudent(studentDTO);
		
		student.setId(stuId);
		
		return studentMapper.updateByPrimaryKeySelective(student) > 0;
	}

	@Override
	public Map<String, Object> getStudentById(String id) {
		
		return null;
	}

	@Override
	public Map<String, Object> getStudentByUserId(String userId) {
		
		return studentMapperExtra.getStudent(userId);
	}
}
