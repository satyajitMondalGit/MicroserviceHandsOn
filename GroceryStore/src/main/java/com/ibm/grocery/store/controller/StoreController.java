package com.ibm.grocery.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.grocery.store.dto.ProductDTO;
import com.ibm.grocery.store.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@GetMapping("/")
	public String greetings() {
	
		return "welcome to The Store";
	}
	
	@PostMapping("/addItem")
	public ResponseEntity<String> addItemToTheStore(@RequestBody List<ProductDTO> list_dto ) {
		
		boolean status = storeService.addItem(list_dto);
		String message = "";
		
		if(status) {
			message=message+ "added Successfully";
			
			return ResponseEntity.ok().body(message);	
		}
		return ResponseEntity.badRequest().body("Not updated to the DB");
	}
	
}
