package com.cp.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.cp.validInterfaces.GroupForAdd;
import com.cp.validInterfaces.GroupForUpdate;

public class EmployeeDTO {

	@NotEmpty(message = "{general.NotEmpty}", groups = GroupForUpdate.class)
	private String id;

	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String name;

	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String employeeNo;

	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String idNo;

	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String phone;

	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String sex;
	
	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String departmentId;

	@NotEmpty(message = "{general.NotEmpty}", groups = GroupForUpdate.class)
	private String userId;
	
	@NotEmpty(message = "{general.NotEmpty}", groups = { GroupForAdd.class, GroupForUpdate.class })
	private String roleId;

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

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
