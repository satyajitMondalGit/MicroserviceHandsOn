package com.ibm.cart.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cart.management.dto.CartDTO;
//import com.ibm.cart.management.dto.OrderDTO;
import com.ibm.cart.management.service.CartService;
//import com.ibm.grocery.store.dto.ProductDTO;

//@RequestMapping("/cart")
@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;

	@GetMapping("/")
	public String greetings() {
	
		return "welcome to The cart";
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
	
	
	@GetMapping("/view")
	public ResponseEntity<List<CartDTO>> viewCart() {
	
		List<CartDTO> list_cdto = cartService.viewCartforUser();
		if(list_cdto !=null && list_cdto.size()>0) {
			return ResponseEntity.ok().body(list_cdto);
		} 
		
		CartDTO cdto = new CartDTO();
		cdto.setProductName("No item in the Cart");
		list_cdto.add(cdto);
		return ResponseEntity.badRequest().body(list_cdto);
	}
	
	@GetMapping("/deleteByName/{pname}")
	public ResponseEntity<List<CartDTO>> deleteByName(@PathVariable(value = "pname") String pname){
		
		 if(pname !=null) {
			 pname = pname.toLowerCase();
		 }
		
		List<CartDTO> list_cdto = cartService.deleteProductByName(pname); 
		
	if(list_cdto !=null && list_cdto.size()>0) {
		
		return ResponseEntity.ok().body(list_cdto);
		
	}
		CartDTO cdto = new CartDTO();
		
		cdto.setProductName("No item in the Cart");
		list_cdto.add(cdto);
		return ResponseEntity.badRequest().body(list_cdto);
	}
	
	
	
	
	@GetMapping("/placeOrder")
	public String placeOrder() {
	
		boolean status = cartService.placeOrder();
		if(status) {
			return "order is successfully placed";
		} 
		return "Sorry !! please try again";
	}
}
