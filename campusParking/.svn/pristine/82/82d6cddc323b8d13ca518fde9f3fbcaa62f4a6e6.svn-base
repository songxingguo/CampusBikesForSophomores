package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class DepartmentDTO {

	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String name;
	
	private String operatorId;
	
	private String remark;
	
	private String parentCode;

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

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
