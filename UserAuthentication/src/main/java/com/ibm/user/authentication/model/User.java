package com.ibm.user.authentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	private int id;
	
	private String user;
	private String pass;
	private String role;
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
		return "User [id=" + id + ", user=" + user + ", pass=" + pass + ", role=" + role + "]";
	}
	
	public User() {
		super();
	}
	public User(int id, String user, String pass, String role2) {
		
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.role = role2;
		// TODO Auto-generated constructor stub
	}
	
	
	
}
