package com.cp.service.user;

import java.util.List;
import java.util.Map;

import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.UserDTO;
import com.cp.dto.search.UserSearchDTO;
import com.cp.model.User;

public interface UserService {

	boolean addUser(UserDTO userDTO);
	
	User addUserAndReturn(UserDTO userDTO);
	
	boolean updateUser(UserDTO userDTO);

	Map<String, Object> getUser(String id);

	boolean deleteUsers(String[] ids);

	List<Map<String, Object>> getUsers(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO, UserSearchDTO usDTO);

	int getUsersCount(LoginInfoDTO loginInfoDTO, UserSearchDTO usDTO);
}
