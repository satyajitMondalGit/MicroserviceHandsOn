package com.ibm.conversionFactor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.conversionFactor.dto.ConversionFactorDTO;
import com.ibm.conversionFactor.dto.ConversionFactorMapper;
import com.ibm.conversionFactor.model.Factor;
import com.ibm.conversionFactor.repository.ConversionFactorRepository;


@Service
public class ConversionFactorService {
	


	private static Logger loger = LoggerFactory.getLogger(ConversionFactorService.class);
	
	@Autowired
	ConversionFactorRepository conversionFactorRepository;
	
	public ConversionFactorDTO addConversionFactor(ConversionFactorDTO factorDTO) {
		//ConversionFactorDTO factorDTO = null;
		ConversionFactorMapper mapper = new ConversionFactorMapper();
		System.out.println(factorDTO.toString());
		Factor factor = mapper.dtoToFactor(factorDTO);
		
		System.out.println(factor.toString());
		
		Factor factor1 = conversionFactorRepository.save(factor);
				
		System.out.println(factor1.toString());
		
		return mapper.factorToDTO(factor1);
	}
	
	public ConversionFactorDTO updateConversionFactor(ConversionFactorDTO factorDTO) {
		//ConversionFactorDTO factorDTO = null;
		String countryCode = factorDTO.getCountryCode();
		Factor factor = new Factor();
		if(countryCode !=null && !"".equalsIgnoreCase(countryCode)) {
			
			factor = conversionFactorRepository.findBycountryCode(countryCode);
			if(factorDTO.getCountryName() !=null && !"".equalsIgnoreCase(factorDTO.getCountryName())) {
				factor.setCountryName(factorDTO.getCountryName());
			}
			if(factorDTO.getConversionRate()>0 ) {
				factor.setConversionRate(factorDTO.getConversionRate());
			}
			if(factorDTO.getBrokercharges()>0) {
				factor.setBrokercharges(factorDTO.getBrokercharges());
			}
			
			
			
		}
		
		//ConversionFactor factor = mapper.dtoToFactor(factorDTO);
		ConversionFactorMapper mapper = new ConversionFactorMapper();
		Factor factor1 = conversionFactorRepository.save(factor);
				
		return mapper.factorToDTO(factor1);
		
		
	}
	
	public ConversionFactorDTO getConversionFactor(String countryCode) {
		
		loger.info("before the repository call"+countryCode);
		Factor factor = conversionFactorRepository.findBycountryCode(countryCode);
		ConversionFactorDTO factorDTO = null;
		if(factor !=null ) {
			ConversionFactorMapper mapper = new ConversionFactorMapper();
			factorDTO = mapper.factorToDTO(factor);
		}
		
		loger.info("before the repository call"+factorDTO.toString());
		return factorDTO;
	}
	
//	private void deleteConversionFactor(ConversionFactorDTO factorDTO) {
//		
//	}
	


}
