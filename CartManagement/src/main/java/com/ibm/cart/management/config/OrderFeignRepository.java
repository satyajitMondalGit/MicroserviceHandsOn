package com.ibm.cart.management.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.cart.management.dto.CartDTO;

@FeignClient(name = "order-management", url = "http://localhost:8087/" )
public interface OrderFeignRepository {

	@PostMapping("/addOrder")
	public boolean addOrder(@RequestBody List<CartDTO> listCartDto);
	
}
