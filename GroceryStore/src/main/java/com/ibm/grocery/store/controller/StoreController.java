package com.ibm.grocery.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.grocery.store.dto.ProductDTO;
import com.ibm.grocery.store.service.StoreService;

@RestController
//@RequestMapping("/store")
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
	
	@GetMapping("/viewByCagegory/{category}")
	public ResponseEntity<List<ProductDTO>> viewByCagegory(@PathVariable(value = "category") String category){
		
		 if(category !=null) {
			 category = category.toLowerCase();
		 }
		
		List<ProductDTO> list_pdto = storeService.getProductByCagegory(category); 
		
	if(list_pdto !=null && list_pdto.size()>0) {
		
		return ResponseEntity.ok().body(list_pdto);
		
	}
		return ResponseEntity.badRequest().body(null);
	}
	
	@GetMapping("/viewByName/{pname}")
	public ResponseEntity<ProductDTO> viewByName(@PathVariable(value = "pname") String pname){
		if(pname !=null) {
			pname = pname.toLowerCase();
		 }
		
		ProductDTO pdto = storeService.getProductByName(pname); 
		
		if(pdto !=null ) {
		
			return ResponseEntity.ok().body(pdto);
		
		}
		return ResponseEntity.badRequest().body(null);
	}
	
	@GetMapping("/addToCartByName/{pname}")
	public String addToCartByName(@PathVariable(value = "pname") String pname){
		if(pname !=null) {
			pname = pname.toLowerCase();
		 }
		
		boolean status = storeService.addToCart(pname); 
		
		if(status) {
		
			return "[ "+pname+" ]  is added to the cart. please go to the cart for complete the order";
		
		}
		return "Item is not added to the Cart. !! Sorry !! Please try again";
	}
	
}
