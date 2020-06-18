package com.ibm.cart.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cart.management.dto.CartDTO;
//import com.ibm.cart.management.dto.OrderDTO;
import com.ibm.cart.management.service.CartService;

@RequestMapping("/cart")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;

	@GetMapping("/")
	public String greetings() {
	
		return "welcome to The Store";
	}
	
	@PostMapping("/addItem")
	public List<CartDTO> addItemToCart(@RequestBody CartDTO  dto) {
		
		List<CartDTO> list_dto = cartService.addItemToOrder(dto);
		
		return list_dto;
	}
	
	@PostMapping("/deleteItem")
	public List<CartDTO> deleteItemFromCart(@RequestBody CartDTO  dto) {
		
		List<CartDTO> list_dto = cartService.deleteItemFromOrder(dto);
		
		return list_dto;
	}
	
	@GetMapping("/completeOrder")
	public String completeOrder(String username) {
	
		boolean status = cartService.completeOrder(username);
		if(status) {
			return "order is successfully placed";
		} 
		return "Sorry !! please try again";
	}
}
