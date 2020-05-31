package com.ibm.conversionFactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.conversionFactor.model.Factor;


public interface ConversionFactorRepository extends JpaRepository<Factor, Long> {

	Factor findBycountryCode(String countryCode);
}
