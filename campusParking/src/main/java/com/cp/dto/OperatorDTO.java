package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class OperatorDTO {

	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String name;
	
	@NotEmpty(message="{general.NotEmpty}", groups = GroupForUpdate.class)
	private String userId;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String legalPerson;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String phone;
	
	@NotEmpty(message="{general.NotEmpty}", groups = {GroupForAdd.class, GroupForUpdate.class})
	private String idNo;
	
	private String parentId;
	
	private String parentCode;
	
	private String code;
	
	private byte hasChild;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte getHasChild() {
		return hasChild;
	}

	public void setHasChild(byte hasChild) {
		this.hasChild = hasChild;
	}
}
