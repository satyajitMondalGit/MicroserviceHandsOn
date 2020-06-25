package com.ibm.cart.management.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ibm.cart.management.dto.CartDTO;

@FeignClient(name = "order-management", url = "http://localhost:8087/" )
public interface OrderFeignRepository {

	@PostMapping("/addOrder")
	public boolean addOrder(@RequestHeader HttpHeaders headers, @RequestBody List<CartDTO> listCartDto);
	
}
