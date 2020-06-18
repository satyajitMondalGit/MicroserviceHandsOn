package com.ibm.cart.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CartManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartManagementApplication.class, args);
	}

}
