package ibm.com.conversionFactors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import ibm.com.conversionFactors.model.ConversionFactor;
import ibm.com.conversionFactors.model.Factor;

@Repository
public interface ConversionFactorRepository extends JpaRepository<Factor, Long> {

	Factor findBycountryCode(String countryCode);
}
