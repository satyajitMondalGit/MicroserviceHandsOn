package com.ibm.grocery.store.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.grocery.store.dto.CartDTO;

//import com.ibm.cart.management.dto.CartDTO;

@FeignClient(name = "cart-management", url = "http://localhost:8086/" )
public interface CartFeignRepository {

	@PostMapping("/addItem")
	public List<CartDTO> addItemToCart(@RequestBody CartDTO  dto);
}
