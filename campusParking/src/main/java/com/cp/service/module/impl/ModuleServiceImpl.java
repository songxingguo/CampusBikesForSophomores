package com.cp.service.module.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.ModuleMapper;
import com.cp.dao.ModuleMapperExtra;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.ModuleDTO;
import com.cp.dto.search.ModuleSearchDTO;
import com.cp.model.Module;
import com.cp.service.module.ModuleService;
import com.cp.util.CodeGenerator;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class ModuleServiceImpl implements ModuleService{

	@Resource(name="moduleMapper")
	private ModuleMapper moduleMapper;
	
	@Resource(name="moduleMapperExtra")
	private ModuleMapperExtra moduleMapperExtra;
	
	@Override
	@Transactional
	public boolean addModule(ModuleDTO moduleDTO) {
		Module module = toModule(moduleDTO);
		
		String parentCode = moduleDTO.getParentCode();
		String maxChildCode = moduleMapperExtra.getMaxChildCode(parentCode);
		
		if(StringUtil.isNullOrEmpty(parentCode))
			module.setCode(CodeGenerator.generateCodeWithoutParentCode(maxChildCode));
		else
			module.setCode(CodeGenerator.generateCodeWithParentCode(parentCode, maxChildCode.replaceFirst(parentCode, "")));
		
		module.setParentCode(parentCode);
		module.setId(StringUtil.createTimestamp());
		
		int result = moduleMapper.insertSelective(module);
		
		if(!StringUtil.isNullOrEmpty(parentCode))
			moduleMapperExtra.updateHasChild(parentCode, SystemConstants.NUMBER_1);
		
		return result > 0;
	}
	
	private Module toModule(ModuleDTO moduleDTO) {
		Module module = new Module();
		
		module.setId(moduleDTO.getId());
		module.setCode(moduleDTO.getCode());
		module.setParentCode(moduleDTO.getParentCode());
		module.setUrl(moduleDTO.getUrl());
		module.setIconUrl(moduleDTO.getIconUrl());
		module.setName(moduleDTO.getName());
		
		return module;
	}

	@Override
	@Transactional
	public synchronized boolean updateModule(ModuleDTO moduleDTO) {
		
		return moduleMapper.updateByPrimaryKeySelective(toModule(moduleDTO)) > 0;
	}

	@Override
	@Transactional
	public synchronized boolean deleteModules(String[] ids) {
		/*String[] codes = moduleMapperExtra.getCodesByIds(ids);*/
		
		for(int i = 0; i < ids.length; i++) {
			moduleMapperExtra.deleteModuleAndChildren(ids[i]);
		}

		return true;
	}

	@Override
	public Map<String, Object> getModule(String id) {
		
		return moduleMapperExtra.getModule(id);
	}

	@Override
	public List<Map<String, Object>> getModules(LimitShowDTO limitShowDTO, ModuleSearchDTO msDTO) {
		return moduleMapperExtra.getModules(limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), msDTO);
	}

	@Override
	public int getModulesCount(ModuleSearchDTO msDTO) {
		List<Map<String, Object>> result = moduleMapperExtra.getModules(-1, -1, msDTO);
		
		return result == null ? 0 : result.size();
	}

	@Override
	public List<Map<String, Object>> getMenu(int i, int j) {
		
		return moduleMapperExtra.getModules(-1, -1, new ModuleSearchDTO());
	}

}
