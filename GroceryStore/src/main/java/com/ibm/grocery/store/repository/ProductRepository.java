package com.ibm.grocery.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.grocery.store.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT p FROM Product p WHERE p.name = ?1")
	Product findByName(String name);
	
	@Query("SELECT p FROM Product p WHERE p.category = ?1")
	List<Product> findByCategory(String category);
}