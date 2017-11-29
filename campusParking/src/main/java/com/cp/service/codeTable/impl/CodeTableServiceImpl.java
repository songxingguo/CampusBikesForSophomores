package com.cp.service.codeTable.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.CodeTableMapper;
import com.cp.dao.CodeTableMapperExtra;
import com.cp.dto.CodeTableDTO;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.search.CodeTableSearchDTO;
import com.cp.model.CodeTable;
import com.cp.service.codeTable.CodeTableService;
import com.cp.util.CodeGenerator;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class CodeTableServiceImpl implements CodeTableService{

	@Resource(name="codeTableMapper")
	private CodeTableMapper codeTableMapper;
	
	@Resource(name="codeTableMapperExtra")
	private CodeTableMapperExtra codeTableMapperExtra;
	
	@Override
	@Transactional
	public synchronized boolean addCodeTable(CodeTableDTO codeTableDTO) {
		CodeTable codeTable = toCodeTable(codeTableDTO);
		
		String parentCode = codeTableDTO.getParentCode();
		String maxChildCode = codeTableMapperExtra.getMaxChildCode(parentCode);
		
		if(StringUtil.isNullOrEmpty(parentCode))
			codeTable.setCode(CodeGenerator.generateCodeWithoutParentCode(maxChildCode));
		else
			codeTable.setCode(CodeGenerator.generateCodeWithParentCode(parentCode, maxChildCode.replaceFirst(parentCode, "")));
		
		codeTable.setParentCode(parentCode);
		
		int result = codeTableMapper.insertSelective(codeTable);
		
		if(!StringUtil.isNullOrEmpty(parentCode))
			codeTableMapperExtra.updateHasChild(parentCode, SystemConstants.NUMBER_1);
		
		return result > 0;
	}
	
	private CodeTable toCodeTable(CodeTableDTO codeTableDTO) {
		CodeTable codeTable = new CodeTable();
		
		codeTable.setCode(codeTableDTO.getCode());
		codeTable.setParentCode(codeTableDTO.getParentCode());
		codeTable.setName(codeTableDTO.getName());
		codeTable.setDetail(codeTableDTO.getDetail());
		
		return codeTable;
	}

	@Override
	@Transactional
	public synchronized boolean updateCodeTable(CodeTableDTO codeTableDTO) {
		
		return codeTableMapper.updateByPrimaryKeySelective(toCodeTable(codeTableDTO)) > 0;
	}

	@Override
	@Transactional
	public synchronized boolean deleteCodeTables(String[] codes) {
		String parentCode = codeTableMapperExtra.getParentCodeByCode(codes[0]);
		
		if(!StringUtil.isNullOrEmpty(parentCode)) {
			int childNum = codeTableMapperExtra.getChildNumByCode(parentCode);
			if(childNum == 0)
				codeTableMapperExtra.updateHasChild(parentCode, SystemConstants.NUMBER_0);
		}
		
		return codeTableMapperExtra.deleteCodeTables(codes) > 0;
	}

	@Override
	public Map<String, Object> getCodeTable(String id) {
		
		return codeTableMapperExtra.getCodeTable(id);
	}

	@Override
	public int getCodeTablesCount(CodeTableSearchDTO ctsDTO) {
		List<Map<String, Object>> result = codeTableMapperExtra.getCodeTables(-1, -1, ctsDTO);
		
		return result == null ? 0 : result.size();
	}

	@Override
	public List<Map<String, Object>> getCodeTables(LimitShowDTO limitShowDTO, CodeTableSearchDTO ctsDTO) {
		
		return codeTableMapperExtra.getCodeTables(limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), ctsDTO);
	}

}
