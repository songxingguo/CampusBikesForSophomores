package com.cp.service.faculty.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.FacultyMapper;
import com.cp.dao.FacultyMapperExtra;
import com.cp.dto.FacultyDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.model.Faculty;
import com.cp.service.faculty.FacultyService;
import com.cp.util.StringUtil;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Resource(name="facultyMapper")
	private FacultyMapper facultyMapper;
	
	@Resource(name="facultyMapperExtra")
	private FacultyMapperExtra facultyMapperExtra;
	
	@Override
	public synchronized boolean updateFaculty(FacultyDTO facultyDTO, LoginInfoDTO loginInfoDTO) {
		Faculty faculty = toFaculty(facultyDTO);
		
		String id = facultyMapperExtra.getIdByUserId(loginInfoDTO.getUserId());
		
		faculty.setId(id);
		
		return facultyMapper.updateByPrimaryKeySelective(faculty) > 0;
	}
	
	private Faculty toFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = new Faculty();
		
		faculty.setId(facultyDTO.getId());
		faculty.setFacultyNo(facultyDTO.getFacultyNo());
		faculty.setIdNo(facultyDTO.getIdNo());
		faculty.setName(facultyDTO.getName());
		faculty.setSchoolId(facultyDTO.getSchoolId());
		faculty.setSex(facultyDTO.getSex());
		faculty.setUserId(facultyDTO.getUserId());
		
		return faculty;
	}

	@Override
	public Map<String, Object> getFacultyByUserId(String userId) {
	
		return facultyMapperExtra.getFacultyByUserId(userId);
	}

	@Override
	public boolean addFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = toFaculty(facultyDTO);
		
		faculty.setId(StringUtil.createTimestamp());
		
		return facultyMapper.insertSelective(faculty) > 0;
	}

}
