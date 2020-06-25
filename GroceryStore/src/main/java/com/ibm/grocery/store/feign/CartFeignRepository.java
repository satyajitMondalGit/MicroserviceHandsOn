package com.ibm.grocery.store.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ibm.grocery.store.dto.CartDTO;

//import com.ibm.cart.management.dto.CartDTO;

@FeignClient(name = "cart-management", url = "http://localhost:8086/" )
public interface CartFeignRepository {

	@PostMapping("/addItem")
	public List<CartDTO> addItemToCart(@RequestHeader HttpHeaders headers, @RequestBody CartDTO  dto);
}
