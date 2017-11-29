package com.cp.service.school.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.SchoolMapper;
import com.cp.dao.SchoolMapperExtra;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.SchoolDTO;
import com.cp.dto.search.SchoolSearchDTO;
import com.cp.model.School;
import com.cp.service.school.SchoolService;
import com.cp.util.StringUtil;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Resource(name="schoolMapper")
	private SchoolMapper schoolMapper;
	
	@Resource(name="schoolMapperExtra")
	private SchoolMapperExtra schoolMapperExtra;
	
	@Override
	public synchronized boolean addSchool(SchoolDTO schoolDTO) {
		
		return schoolMapper.insertSelective(toSchool(schoolDTO)) > 0;
	}
	
	private School toSchool(SchoolDTO schoolDTO) {
		School school = new School();
		
		school.setId(StringUtil.isNullOrEmpty(schoolDTO.getId()) ? StringUtil.createTimestamp() : schoolDTO.getId());
		school.setName(schoolDTO.getName());
		school.setAddress(schoolDTO.getAddress());
		
		return school;
	}

	@Override
	public synchronized boolean updateSchool(SchoolDTO schoolDTO) {
		
		return schoolMapper.updateByPrimaryKeySelective(toSchool(schoolDTO)) > 0;
	}

	@Override
	public boolean deleteSchools(String[] ids) {
		
		return schoolMapperExtra.deleteSchoolsByIds(ids) > 0;
	}

	@Override
	public Map<String, Object> getSchool(String id) {
		
		return schoolMapperExtra.getSchool(id);
	}

	@Override
	public List<Map<String, Object>> getSchools(LimitShowDTO limitShowDTO, SchoolSearchDTO ssDTO) {
		
		return schoolMapperExtra.getSchools(ssDTO, limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage());
	}

	@Override
	public int getSchoolsCount(SchoolSearchDTO ssDTO) {
		List<Map<String, Object>> result = schoolMapperExtra.getSchools(ssDTO, -1, -1);
		
		return result == null ? 0 : result.size();
	}

	@Override
	public boolean updateSchoolOperator(String schoolId, String operatorId) {
		
		return schoolMapperExtra.updateSchoolOperator(schoolId, operatorId) > 0;
	}

	@Override
	public List<Map<String, Object>> getSchoolsWithName(String name) {
		
		return schoolMapperExtra.getSchoolsWithName(name);
	}

}
