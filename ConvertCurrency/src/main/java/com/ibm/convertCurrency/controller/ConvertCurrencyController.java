package com.ibm.convertCurrency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertCurrency.config.FeignRepository;
import com.ibm.convertCurrency.service.ConvertCurrencyService;


//@RequestMapping("convertCurrency")
@RestController
public class ConvertCurrencyController {

	private static Logger loger = LoggerFactory.getLogger(ConvertCurrencyController.class);
	
	
	@Autowired
	ConvertCurrencyService convertCurrencyService;
	
	@GetMapping("/")
	public String greetings() {
		
		return "welcome to Currency Conversion App";
	}
	
	
	@GetMapping("/{countrycode}/{amount}")
	public ResponseEntity<Double> getconvertedAmount(@PathVariable(value = "countrycode") String countrycode,
			@PathVariable(value = "amount") double amount){
		loger.info("inside the getconvertedAmount ");
		return ResponseEntity.ok().body(convertCurrencyService.convertCurrencyService(countrycode, amount));
		}
	
}
