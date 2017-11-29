package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class UserDTO {

	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String code;
	
	@NotEmpty(message="{general.NotEmpty}", groups = GroupForAdd.class)
	private String password;
	
	private String roleId;
	
	private String nickname;
	
	private String createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
