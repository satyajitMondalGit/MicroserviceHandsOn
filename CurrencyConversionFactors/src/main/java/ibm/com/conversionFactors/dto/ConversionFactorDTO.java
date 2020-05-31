package ibm.com.conversionFactors.dto;

public class ConversionFactorDTO {
	
	
	private String countryCode;
	private String countryName;
	private double conversionRate;
	private double Brokercharges;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public double getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}
	public double getBrokercharges() {
		return Brokercharges;
	}
	public void setBrokercharges(double brokercharges) {
		Brokercharges = brokercharges;
	}
	@Override
	public String toString() {
		return "ConversionFactorDTO [countryCode=" + countryCode + ", countryName=" + countryName + ", conversionRate="
				+ conversionRate + ", Brokercharges=" + Brokercharges + ", id=" + id + "]";
	}
	
	

}
