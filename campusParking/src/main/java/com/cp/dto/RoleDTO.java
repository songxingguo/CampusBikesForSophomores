package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class RoleDTO {

	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String name;
	
	private String creatorId;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
