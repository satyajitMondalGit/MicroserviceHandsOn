package com.ibm.oauth.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class OAuthResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthResourceServerApplication.class, args);
	}

	@RequestMapping(value="/api")
	public String success() {
		return "SUCCESS";
	}
	
}
