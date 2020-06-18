package com.ibm.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.order.management.dto.CartDTO;
import com.ibm.order.management.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public String greetings() {
	
		return "welcome to The Store";
	}
	
	@PostMapping("/addOrder")
	public boolean addOrder(@RequestBody List<CartDTO> listCartDto) {
		
		boolean success = orderService.addOrder(listCartDto);
		return success;
	}
	
	@PostMapping("/viewOrder")
	public List<CartDTO> viewOrder(@RequestBody String username) {
		
		List<CartDTO> listCartDto = orderService.viewOrder(username);
		return listCartDto;
	}
	
}
