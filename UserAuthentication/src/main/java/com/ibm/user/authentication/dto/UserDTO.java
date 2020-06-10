package com.ibm.user.authentication.dto;

public class UserDTO {

	
	private int id;
	private String user;
	private String pass;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", user=" + user + ", pass=" + pass + ", role=" + role + "]";
	}
}
