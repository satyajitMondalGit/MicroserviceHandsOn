package com.ibm.authorization.server.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibm.authorization.server.model.Credentials;
import com.ibm.authorization.server.repository.CredentialsRepository;
import com.ibm.authorization.server.security.CustomUser;

@Service
public class CustomDetailsService implements UserDetailsService{
	
	@Autowired
	CredentialsRepository credentialsRepository;
	
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials usermodel = credentialsRepository.findByUsername(username);
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
		grantedAuthoritiesList.add(grantedAuthority);
		
		System.out.println("cs"+usermodel.getPass());
		
		CustomUser customuser = new CustomUser(usermodel.getUname(),passwordEncoder.encode("password"), grantedAuthoritiesList);
		return customuser;
	}

}
