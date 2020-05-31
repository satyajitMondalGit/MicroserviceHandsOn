package com.ibm.conversionFactor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Factor")
public class Factor {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String countryCode;
	
	private String countryName;
	private double conversionRate;
	private double Brokercharges;
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
		return "ConversionFactor [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", conversionRate=" + conversionRate + ", Brokercharges=" + Brokercharges + "]";
	}
	

}
