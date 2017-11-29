package com.cp.service.role.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cp.dao.RoleMapper;
import com.cp.dao.RoleMapperExtra;
import com.cp.dto.LimitShowDTO;
import com.cp.dto.LoginInfoDTO;
import com.cp.dto.RoleDTO;
import com.cp.dto.search.RoleSearchDTO;
import com.cp.model.Role;
import com.cp.service.role.RoleService;
import com.cp.util.StringUtil;
import com.cp.util.SystemConstants;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;

	@Resource(name = "roleMapperExtra")
	private RoleMapperExtra roleMapperExtra;

	@Override
	public synchronized boolean addRole(RoleDTO roleDTO, String userId) {
		Role role = toRole(roleDTO);

		role.setId(StringUtil.createTimestamp());
		role.setCreatorId(userId);

		return roleMapper.insertSelective(role) > 0;
	}

	private Role toRole(RoleDTO roleDTO) {
		Role role = new Role();

		role.setId(roleDTO.getId());
		role.setName(roleDTO.getName());
		role.setRemark(roleDTO.getRemark());
		role.setCreatorId(roleDTO.getCreatorId());

		return role;
	}

	@Override
	public synchronized boolean updateRole(RoleDTO roleDTO) {

		return roleMapper.updateByPrimaryKeySelective(toRole(roleDTO)) > 0;
	}

	@Override
	public Map<String, Object> getUser(String id) {

		return roleMapperExtra.getRoleById(id);
	}

	@Override
	public boolean deleteRoles(String[] ids) {

		return roleMapperExtra.deleteRoles(ids) > 0;
	}

	@Override
	public List<Map<String, Object>> getRoles(LoginInfoDTO loginInfoDTO, LimitShowDTO limitShowDTO,
			RoleSearchDTO rsDTO) {
		if (loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			return roleMapperExtra.getRoles(null, limitShowDTO.caculateStart(), limitShowDTO.getItemPerPage(),
					rsDTO);

		return roleMapperExtra.getRoles(loginInfoDTO.getUserId(), limitShowDTO.caculateStart(),
				limitShowDTO.getItemPerPage(), rsDTO);
	}

	@Override
	public int getRolesCount(LoginInfoDTO loginInfoDTO, RoleSearchDTO rsDTO) {
		List<Map<String, Object>> result = null;
		if (loginInfoDTO.getUserId().equals(SystemConstants.ADMIN_ID))
			result = roleMapperExtra.getRoles(null, -1, -1, rsDTO);
		else
			result = roleMapperExtra.getRoles(loginInfoDTO.getUserId(), -1, -1, rsDTO);
		
		return result == null ? 0 : result.size();
	}

}
