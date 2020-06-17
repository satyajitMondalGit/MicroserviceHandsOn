package com.ibm.grocery.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.grocery.store.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByName(String name);
	
	List<Product> findByCategory(String category);
}