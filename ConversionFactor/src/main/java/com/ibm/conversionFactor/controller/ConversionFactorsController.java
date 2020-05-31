package com.ibm.conversionFactor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.conversionFactor.dto.ConversionFactorDTO;
import com.ibm.conversionFactor.service.ConversionFactorService;


@RequestMapping("factor")
@RestController

public class ConversionFactorsController {


	
	private static Logger loger = LoggerFactory.getLogger(ConversionFactorsController.class);
	
	@Autowired
	ConversionFactorService conversionFactorService;
	
	@GetMapping("/{countrycode}")
	public ResponseEntity<ConversionFactorDTO> getConversionFactorByCountryCode(@PathVariable(value = "countrycode") String countrycode){
		
	return ResponseEntity.ok().body(conversionFactorService.getConversionFactor(countrycode));
	}
	
	
	
//	@GetMapping("/add/{countrycode}/{countryname}/{conversionRate}/{Brokercharges}")
//	public ResponseEntity<ConversionFactorDTO> addFactor(@PathVariable(value = "countrycode") String countrycode,
//														@PathVariable(value = "countryname") String countryname,
//														@PathVariable(value = "conversionRate") Long conversionRate,
//														@PathVariable(value = "Brokercharges") Long Brokercharges){
//		
//		
//		return ResponseEntity.ok().body(conversionFactorService.getConversionFactor(countrycode));
//	}
	
	
	@PostMapping("/add")
	public ResponseEntity<ConversionFactorDTO> addFactor(@RequestBody ConversionFactorDTO factorDTO){
		
		//System.out.println(factorDTO.toString());
		
		loger.info("before addConversionFactor call ");
		ConversionFactorDTO dto = conversionFactorService.addConversionFactor(factorDTO);
		loger.info("after addConversionFactor call ");
		//System.out.println(dto.toString());
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ConversionFactorDTO> updateFactor(@RequestBody ConversionFactorDTO factorDTO){
		
		ConversionFactorDTO dto = conversionFactorService.updateConversionFactor(factorDTO);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@GetMapping("/feign/{countrycode}")
	public Double getConversionRate(@PathVariable(value = "countrycode") String countrycode){
		loger.info("before getConversionFactor call ");
		ConversionFactorDTO dto = conversionFactorService.getConversionFactor(countrycode);
		double conversionRate = dto.getConversionRate()+dto.getBrokercharges();
		loger.info("before getConversionFactor call "+conversionRate);
	return conversionRate;
	}
	

	
}
