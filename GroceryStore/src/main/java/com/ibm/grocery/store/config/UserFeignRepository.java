package com.ibm.grocery.store.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "jwt-authentication", url = "http://localhost:9092/" )
public interface UserFeignRepository {

	@GetMapping("/validateSToken")
	public String validateServiceToken(@RequestHeader HttpHeaders headers);
}
