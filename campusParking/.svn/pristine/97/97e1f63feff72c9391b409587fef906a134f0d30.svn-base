package com.cp.service.school;

import java.util.List;
import java.util.Map;

import com.cp.dto.LimitShowDTO;
import com.cp.dto.SchoolDTO;
import com.cp.dto.search.SchoolSearchDTO;

public interface SchoolService {

	boolean addSchool(SchoolDTO schoolDTO);

	boolean updateSchool(SchoolDTO schoolDTO);

	boolean deleteSchools(String[] ids);

	Map<String, Object> getSchool(String id);

	List<Map<String, Object>> getSchools(LimitShowDTO limitShowDTO, SchoolSearchDTO ssDTO);

	int getSchoolsCount(SchoolSearchDTO ssDTO);

	boolean updateSchoolOperator(String schoolId, String operatorId);

	List<Map<String, Object>> getSchoolsWithName(String name);
}
