package com.ibm.user.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.authentication.dto.UserAuthentication;
import com.ibm.user.authentication.util.JwtUtil;


@RestController
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcomeCOntroller() {
		
		return "Welcome to spring Security";
	}

	@PostMapping("/authenticate")
	public String generateAuthenticationToken(@RequestBody UserAuthentication authRequest) throws Exception{
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
	}
	
}
