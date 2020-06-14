package com.ibm.user.authentication.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.authentication.dto.UserAuthentication;
import com.ibm.user.authentication.model.Temporary;
import com.ibm.user.authentication.model.User;
import com.ibm.user.authentication.repository.TempRepository;
import com.ibm.user.authentication.repository.UserRepository;
//import com.ibm.user.authentication.resource.AuthenticationResource;
import com.ibm.user.authentication.service.UserService;
import com.ibm.user.authentication.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository repository;

	@Autowired
	private TempRepository tempRepository;

	@GetMapping("/welcome")
	public String welcomeCOntroller() {

		return "Welcome to spring Security";
	}

	@PostMapping("/authenticate")
	public String generateAuthenticationToken(@RequestBody UserAuthentication authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}

		User user = repository.findByUser(authRequest.getUserName());

		if (user != null) {
			jwtUtil.setSecret(user.getAuthKey());
		} else {
			throw new Exception("DB is not responding");
		}

		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@GetMapping("/serviceToken")
	public String generateServiceToken() {
		System.out.println("before service call");

		String userName = null;

		Optional<Temporary> temp = tempRepository.findById(101);

		if (temp.isPresent()) {
			userName = temp.get().getTempUser();
		}

		User user = repository.findByUser(userName);

		if (user != null) {
			jwtUtil.setSecret(user.getTransacKey());
		}
		System.out.println("before service call");

		return jwtUtil.generateToken(userName);

	}

	@GetMapping("/validateSToken")
	public String validateServiceToken() {
		return "Service Token validate properly";
	}
	
}
