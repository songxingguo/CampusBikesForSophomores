package com.cp.dto.search;

import com.cp.util.StringUtil;

public class SchoolSearchDTO {

	private String name;
	
	private String address;
	
	private String operatorName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtil.isNullOrEmpty(name) ? null : name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = StringUtil.isNullOrEmpty(address) ? null : address;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = StringUtil.isNullOrEmpty(operatorName) ? null : operatorName;
	}
}
