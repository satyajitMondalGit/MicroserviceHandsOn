package com.ibm.conversionFactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConversionFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionFactorApplication.class, args);
	}

}
