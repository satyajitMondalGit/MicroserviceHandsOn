package com.ibm.authorization.server.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public class CustomUser extends User {

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}

	private static final long serialVersionUID = 1L;


	
	
}
