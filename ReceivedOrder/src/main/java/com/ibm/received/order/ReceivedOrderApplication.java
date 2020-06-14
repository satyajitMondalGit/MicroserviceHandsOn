package com.ibm.received.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ReceivedOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceivedOrderApplication.class, args);
	}

}
