package ibm.com.conversionFactors.dto;

//import ibm.com.conversionFactors.model.ConversionFactor;
import ibm.com.conversionFactors.model.Factor;

public class ConversionFactorMapper {
	
	public Factor dtoToFactor(ConversionFactorDTO FactorDTO) {
	
		Factor factor = new Factor();
		
		factor.setCountryCode(FactorDTO.getCountryCode());
		factor.setCountryName(FactorDTO.getCountryName());
		factor.setConversionRate(FactorDTO.getConversionRate());
		factor.setBrokercharges(FactorDTO.getBrokercharges());
		
		
		return factor;
	}
	
	public ConversionFactorDTO factorToDTO(Factor factor) {
		ConversionFactorDTO FactorDTO = new ConversionFactorDTO();
		
		FactorDTO.setCountryCode(factor.getCountryCode());
		FactorDTO.setCountryName(factor.getCountryName());
		FactorDTO.setConversionRate(factor.getConversionRate());
		FactorDTO.setBrokercharges(factor.getBrokercharges());
		
		return FactorDTO;
	}

}
