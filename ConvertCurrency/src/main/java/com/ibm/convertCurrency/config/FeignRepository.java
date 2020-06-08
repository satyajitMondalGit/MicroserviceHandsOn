package com.ibm.convertCurrency.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Conversion-Factor", url = "http://localhost:8081/factor" )

//@FeignClient(name = "Conversion-Factor")
//@RibbonClient(name = "Conversion-Factor")
public interface FeignRepository {

	@GetMapping("/feign/{countrycode}")
	public Double getConversionRate(@PathVariable(value = "countrycode") String countrycode);

}
