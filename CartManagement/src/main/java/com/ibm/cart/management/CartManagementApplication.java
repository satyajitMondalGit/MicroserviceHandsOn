package com.ibm.cart.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CartManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartManagementApplication.class, args);
	}

}
