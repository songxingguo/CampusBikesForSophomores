package com.cp.service.operator.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.OperatorMapper;
import com.cp.dao.OperatorMapperExtra;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.OperatorDTO;
import com.cp.dto.UserDTO;
import com.cp.dto.search.OperatorSearchDTO;
import com.cp.model.Operator;
import com.cp.model.User;
import com.cp.service.operator.OperatorService;
import com.cp.service.user.UserService;
import com.cp.util.CodeGenerator;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Resource(name="operatorMapper")
	private OperatorMapper operatorMapper;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="operatorMapperExtra")
	private OperatorMapperExtra operatorMapperExtra;
	
	@Override
	@Transactional
	public synchronized boolean addOperator(OperatorDTO operatorDTO, String userId) {
		//生成运营商对应的用户
		User user = userService.addUserAndReturn(toUserDTO(operatorDTO));
		operatorDTO.setId(user.getId());
		
		String parentCode = operatorMapperExtra.getCodeByUserId(userId);
		String maxChildCode = operatorMapperExtra.getMaxChildCodeByParentCode(parentCode);
		
		Operator operator = toOperator(operatorDTO);
		
		if(StringUtil.isNullOrEmpty(parentCode))
			operator.setCode(CodeGenerator.generateCodeWithoutParentCode(maxChildCode));
		else
			operator.setCode(CodeGenerator.generateCodeWithParentCode(parentCode, maxChildCode.replaceFirst(parentCode, "")));
		
		operator.setId(StringUtil.createTimestamp());
		operator.setParentCode(parentCode);
		operator.setHasChild(SystemConstants.NUMBER_0);
			
		return operatorMapperExtra.updateHasChildByUserId(userId, SystemConstants.NUMBER_1) > 0 && 
				operatorMapper.insert(operator) > 0;
	}
	
	private UserDTO toUserDTO(OperatorDTO operatorDTO) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(operatorDTO.getUserId());
		userDTO.setCode(operatorDTO.getPhone());
		userDTO.setRoleId(SystemConstants.OPERATOR_ROLE_ID);
		
		return userDTO;
	}
	
	private Operator toOperator(OperatorDTO operatorDTO) {
		Operator operator = new Operator();
		
		operator.setId(operatorDTO.getId());
		operator.setLegalPerson(operatorDTO.getLegalPerson());
		operator.setName(operatorDTO.getName());
		operator.setPhone(operatorDTO.getPhone());
		operator.setUserId(operatorDTO.getUserId());
		operator.setIdNo(operatorDTO.getIdNo());
		
		return operator;
	}

	@Override
	@Transactional
	public synchronized boolean updateOperator(OperatorDTO operatorDTO) {
		Operator operator = toOperator(operatorDTO);
		
		return operatorMapper.updateByPrimaryKeySelective(operator) > 0
				&& userService.updateUser(toUserDTO(operatorDTO));
	}

	@Override
	public Map<String, Object> getOperator(String id) {
		
		return operatorMapperExtra.getOperator(id);
	}

	@Override
	@Transactional
	public boolean deleteOperators(String[] ids) {
		
		return operatorMapperExtra.deleteOperators(ids) > 0;
	}

	@Override
	public List<Map<String, Object>> getOperators(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			OperatorSearchDTO osDTO) {
		String parentCode = null;
		
		if(loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			parentCode = null;
		else
			parentCode = operatorMapperExtra.getCodeByUserId(loginInfoDTO.getUserId());
		
		return operatorMapperExtra.getOperators(parentCode, limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), osDTO);
	}

	@Override
	public int getOperatorsCount(LoginInfoDTO loginInfoDTO, OperatorSearchDTO osDTO) {
		String parentCode = null;
		
		if(loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			parentCode = null;
		else
			parentCode = operatorMapperExtra.getCodeByUserId(loginInfoDTO.getUserId());
		
		List<Map<String, Object>> result = operatorMapperExtra.getOperators(parentCode, -1, -1, osDTO);
		
		return result == null ? 0 : result.size();
	}

}
