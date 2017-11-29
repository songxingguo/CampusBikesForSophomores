package com.cp.service.user.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.dao.UserMapper;
import com.cp.dao.UserMapperExtra;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.UserDTO;
import com.cp.dto.search.UserSearchDTO;
import com.cp.model.User;
import com.cp.service.user.UserService;
import com.cp.util.CodeGenerator;
import com.cp.util.DateUtil;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class UserServiceImpl implements UserService{

	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Resource(name="userMapperExtra")
	private UserMapperExtra userMapperExtra;
	
	@Override
	public boolean addUser(UserDTO userDTO) {
		
		return addUserAndReturn(userDTO) != null;
	}
	
	private User toUser(UserDTO userDTO) {
		User user = new User();
		
		user.setId(userDTO.getId());
		user.setCode(userDTO.getCode());
		user.setPassword(userDTO.getPassword());
		user.setCreateTime(DateUtil.parseDate("yyyy-MM-dd HH:mm:ss", userDTO.getCreateTime()));
		user.setRoleId(userDTO.getRoleId());
		user.setNickname(userDTO.getNickname());
		
		return user;
	}

	@Override
	@Transactional
	public synchronized User addUserAndReturn(UserDTO userDTO) {
		User user = toUser(userDTO);
		
		user.setId(StringUtil.createTimestamp());
		user.setCreateTime(new Date());
		user.setNickname(CodeGenerator.generateNickname());
		
		String password = user.getPassword();
		if(StringUtil.isNullOrEmpty(password))
			user.setPassword(SystemConstants.INIT_PASSWORD);
		
		if(userMapper.insert(user) > 0)
			return user;
		
		return null;
	}

	@Override
	@Transactional
	public synchronized boolean updateUser(UserDTO userDTO) {
		
		return userMapper.updateByPrimaryKeySelective(toUser(userDTO)) > 0;
	}

	@Override
	public Map<String, Object> getUser(String id) {
		
		return userMapperExtra.getUserById(id);
	}

	@Override
	public boolean deleteUsers(String[] ids) {
		
		return userMapperExtra.deleteUsers(ids) > 0;
	}

	@Override
	public List<Map<String, Object>> getUsers(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			UserSearchDTO usDTO) {
		if(loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			return userMapperExtra.getUsers(null, limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), usDTO);
		
		return userMapperExtra.getUsers(loginInfoDTO.getUserId(), limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(), usDTO);
	}

	@Override
	public int getUsersCount(LoginInfoDTO loginInfoDTO, UserSearchDTO usDTO) {
		List<Map<String, Object>> result = null;
		
		if(loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			result = userMapperExtra.getUsers(null, -1, -1, usDTO);
		else
			result = userMapperExtra.getUsers(loginInfoDTO.getUserId(), -1, -1, usDTO);
		
		return result == null ? 0 : result.size();
	}
}
