package com.cp.dto;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisterDTO {

	@NotEmpty(message="{general.NotEmpty}")
	private String phoneNumber;
	
	@NotEmpty(message="{general.NotEmpty}")
	private String schoolId;
	
	@NotEmpty(message="{general.NotEmpty}")
	private String password;
	
	@NotEmpty(message="{general.NotEmpty}")
	private String authenticationCode;
	
	@Min(1)
	private int registerType; //0代表学生，1代表老师

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthenticationCode() {
		return authenticationCode;
	}

	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}

	public int getRegisterType() {
		return registerType;
	}

	public void setRegisterType(int registerType) {
		this.registerType = registerType;
	}
}
