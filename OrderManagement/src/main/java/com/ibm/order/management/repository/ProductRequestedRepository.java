package com.ibm.order.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.order.management.model.ProductRequested;

public interface ProductRequestedRepository extends JpaRepository<ProductRequested, Integer> {
	
	@Query(value = "SELECT p FROM ProductRequested p Where p.userName = userName")
	List<ProductRequested> findByUserName(String userName);

}
