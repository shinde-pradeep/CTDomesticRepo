package com.kjnext.model;

import com.kjnext.hibernate.RaCompanyMaster;

public class UserTo {
	
	
	private Integer userId;

	private String loginName;

	 private String password;

	 private String userType;

	 private String position;
	 
	 RaCompanyMaster raCompanyMaster;
	 
	 

	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public RaCompanyMaster getRaCompanyMaster() {
		return raCompanyMaster;
	}

	public void setRaCompanyMaster(RaCompanyMaster raCompanyMaster) {
		this.raCompanyMaster = raCompanyMaster;
	}

	
}
