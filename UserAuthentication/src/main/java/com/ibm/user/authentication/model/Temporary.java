package com.ibm.user.authentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Temporary")
public class Temporary  {

	@Id
	private int id;
	private String tempUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTempUser() {
		return tempUser;
	}
	public void setTempUser(String tempUser) {
		this.tempUser = tempUser;
	}
	public Temporary(int id, String tempUser) {
		super();
		this.id = id;
		this.tempUser = tempUser;
	}
	public Temporary() {
		super();
	}
	
}
