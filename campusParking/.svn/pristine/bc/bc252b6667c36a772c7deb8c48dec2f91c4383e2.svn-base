package com.cp.service.department.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.DepartmentMapper;
import com.cp.dao.DepartmentMapperExtra;
import com.cp.dto.DepartmentDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.search.DepartmentSearchDTO;
import com.cp.model.Department;
import com.cp.service.department.DepartmentService;
import com.cp.util.CodeGenerator;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource(name="departmentMapper")
	private DepartmentMapper departmentMapper;
	
	@Resource(name="departmentMapperExtra")
	private DepartmentMapperExtra departmentMapperExtra;

	@Override
	@Transactional
	public synchronized boolean addDepartment(LoginInfoDTO loginInfoDTO, DepartmentDTO departmentDTO) {
		Department department = toDepartment(departmentDTO);
		
		department.setId(StringUtil.createTimestamp());
		department.setOperatorId(loginInfoDTO.getUserId());
		
		String parentCode = departmentDTO.getParentCode();
		String maxChildCode = departmentMapperExtra.getMaxChildCode(parentCode);
		
		department.setParentCode(parentCode);
		
		if(StringUtil.isNullOrEmpty(parentCode))
			department.setCode(CodeGenerator.generateCodeWithoutParentCode(maxChildCode));
		else
			department.setCode(CodeGenerator.generateCodeWithParentCode(parentCode, maxChildCode.replaceFirst(parentCode, "")));
		
		department.setHasChild(SystemConstants.NUMBER_0);
		
		if(!StringUtil.isNullOrEmpty(parentCode))
			departmentMapperExtra.updateHasChild(parentCode, SystemConstants.NUMBER_1);
		
		return departmentMapper.insertSelective(department) > 0;
	}
	
	private Department toDepartment(DepartmentDTO departmentDTO) {
		Department department = new Department();
		
		department.setId(departmentDTO.getId());
		department.setName(departmentDTO.getName());
		department.setRemark(departmentDTO.getRemark());
		department.setOperatorId(departmentDTO.getOperatorId());
		
		return department;
	}

	@Override
	@Transactional
	public synchronized boolean updateDepartment(DepartmentDTO departmentDTO) {
		
		return departmentMapper.updateByPrimaryKeySelective(toDepartment(departmentDTO)) > 0;
	}

	@Override
	public Map<String, Object> getDepartment(String id) {
		
		return departmentMapperExtra.getDepartmentById(id);
	}

	@Override
	@Transactional
	public synchronized boolean deleteDepartments(String[] ids) {
		String parentCode = departmentMapperExtra.getParentCodeById(ids[0]);
		
		int result = departmentMapperExtra.deleteDepartments(ids);
		
		if(!StringUtil.isNullOrEmpty(parentCode)) {
			int numOfChild = departmentMapperExtra.getNumOfChild(parentCode);
			if(numOfChild == 0)
				departmentMapperExtra.updateHasChild(parentCode, SystemConstants.NUMBER_0);
		}
		
		return result > 0;
	}

	@Override
	public List<Map<String, Object>> getDepartments(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			DepartmentSearchDTO dsDTO) {
		
		return departmentMapperExtra.getDepartments(loginInfoDTO.getUserId(), limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), dsDTO);
	}

	@Override
	public int getDepartmentsCount(LoginInfoDTO loginInfoDTO, DepartmentSearchDTO dsDTO) {
		List<Map<String, Object>> result = departmentMapperExtra.getDepartments(loginInfoDTO.getUserId(), -1, -1, dsDTO);
		
		return result == null ? 0 : result.size();
	}

}
