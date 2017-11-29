package com.cp.dto.search;

import com.cp.util.StringUtil;

public class OperatorSearchDTO {

	private String name;
	
	private String legalPerson;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtil.isNullOrEmpty(name) ? null : name;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = StringUtil.isNullOrEmpty(legalPerson) ? null : legalPerson;
	}
}
