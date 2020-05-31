package com.ibm.conversionFactor.dto;

import com.ibm.conversionFactor.model.Factor;


public class ConversionFactorMapper {
	
 public Factor dtoToFactor(ConversionFactorDTO factorDTO) {
	 
	 Factor factor = new Factor();
		
	factor.setCountryCode(factorDTO.getCountryCode());
	factor.setCountryName(factorDTO.getCountryName());
	factor.setConversionRate(factorDTO.getConversionRate());
	factor.setBrokercharges(factorDTO.getBrokercharges());
		
	return factor;
 }
 
 public ConversionFactorDTO factorToDTO(Factor factor) {
		ConversionFactorDTO factorDTO = new ConversionFactorDTO();
		
		factorDTO.setCountryCode(factor.getCountryCode());
		factorDTO.setCountryName(factor.getCountryName());
		factorDTO.setConversionRate(factor.getConversionRate());
		factorDTO.setBrokercharges(factor.getBrokercharges());
		
		return factorDTO;
	}
 
}
