package com.ibm.user.authentication.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.user.authentication.model.User;
import com.ibm.user.authentication.repository.UserRepository;
//import com.ibm.user.authentication.resource.AuthenticationResource;
import com.ibm.user.authentication.util.JwtUtil;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUser(username);
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		
		return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPass(), new ArrayList<>());
	}
	
	

	public String getuserName() {
		
		
		HttpServletRequest request = null;
		
		final String authorizationHeader = request.getHeader("Authorization");
		
		String userName = null;
		String jwtToken = null;
		
		if(authorizationHeader !=null  && authorizationHeader.startsWith("Bearer ")) {
			jwtToken = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(jwtToken);
            
    		
    		           
		}
		
		
		return userName;
	}



	
}
