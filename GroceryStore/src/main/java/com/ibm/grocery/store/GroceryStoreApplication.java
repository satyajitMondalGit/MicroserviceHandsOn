package com.ibm.grocery.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class GroceryStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApplication.class, args);
	}

}
