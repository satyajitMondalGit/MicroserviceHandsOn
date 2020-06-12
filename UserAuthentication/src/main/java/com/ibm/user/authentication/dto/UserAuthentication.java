package com.ibm.user.authentication.dto;

public class UserAuthentication {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserAuthentication(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public UserAuthentication() {
		super();
	}
	@Override
	public String toString() {
		return "UserAuthentication [userName=" + userName + ", password=" + password + "]";
	}
	

}
