package com.ibm.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.order.management.dto.CartDTO;
import com.ibm.order.management.service.OrderService;

@RestController
//@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public String greetings() {
	
		return "welcome to The order";
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
	
	@GetMapping("/view")
	public ResponseEntity<List<CartDTO>> viewCart(){
		
		List<CartDTO> list_cdto = orderService.viewOrderforUser();
		if(list_cdto !=null && list_cdto.size()>0) {
			return ResponseEntity.ok().body(list_cdto);
		} 
		
		CartDTO cdto = new CartDTO();
		cdto.setProductName("No active Order");
		list_cdto.add(cdto);
		return ResponseEntity.badRequest().body(list_cdto);
	}
	
	@GetMapping("/deliverByName/{pname}")
	public String deliverByName(@PathVariable(value = "pname") String pname){
		
		if(pname !=null) {
			 pname = pname.toLowerCase();
		 }
		List<CartDTO> listDto = orderService.deliverProductByName(pname);
		
		if(listDto !=null && listDto.size()>0) {
			return "[ "+pname+" ] is delivered successfully.";
		}
		return "Your all placed order are delivered successfully. Your transaction token is also expired. For new order please generate a new Transaction token";
	}
	
}
