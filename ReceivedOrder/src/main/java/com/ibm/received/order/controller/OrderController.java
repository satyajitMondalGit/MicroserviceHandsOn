package com.ibm.received.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@GetMapping("/")
	public String welcomeMessage() {
		return "welcome to order received microservice";
	}
}
