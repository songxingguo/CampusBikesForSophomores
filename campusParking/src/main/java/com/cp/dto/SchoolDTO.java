package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class SchoolDTO {

	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String name;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String address;
	
	private String operatorId;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
