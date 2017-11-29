package com.cp.dto.search;

import com.cp.util.StringUtil;

public class ModuleSearchDTO {

	private String name;
	
	private String parentCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = StringUtil.isNullOrEmpty(parentCode) ? null : parentCode;
	}
}
