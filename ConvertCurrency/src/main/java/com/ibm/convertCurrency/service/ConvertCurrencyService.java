package com.ibm.convertCurrency.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ibm.convertCurrency.bean.ConversionFactorDetails;
//import com.ibm.convertCurrency.bean.ConvertCurrencyBean;
import com.ibm.convertCurrency.config.FeignRepository;
import com.ibm.convertCurrency.controller.ConvertCurrencyController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConvertCurrencyService {
	
	private static Logger loger = LoggerFactory.getLogger(ConvertCurrencyService.class);

	@Autowired
	FeignRepository feignRepository;
	
	@HystrixCommand(fallbackMethod ="convertCurrencyServiceFallback")
	public double convertCurrencyService(String countryCode, double amount) {
		
		loger.info("before feign repository call");
		double convertedAmount = feignRepository.getConversionRate(countryCode)* amount;
		loger.info("after feign repository call");
		return convertedAmount;
	}
	
	public double convertCurrencyServiceFallback(String countryCode, double amount) {
		
		return 73*amount;
	}
	
}
