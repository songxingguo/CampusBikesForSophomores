package com.cp.service.role;

import java.util.List;
import java.util.Map;

import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.RoleDTO;
import com.cp.dto.search.RoleSearchDTO;

public interface RoleService {

	boolean addRole(RoleDTO roleDTO, String userId);

	boolean updateRole(RoleDTO roleDTO);

	Map<String, Object> getUser(String id);

	boolean deleteRoles(String[] ids);

	List<Map<String, Object>> getRoles(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO, RoleSearchDTO rsDTO);

	int getRolesCount(LoginInfoDTO loginInfoDTO, RoleSearchDTO rsDTO);

}
