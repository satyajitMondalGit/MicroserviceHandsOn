package com.ibm.cart.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.cart.management.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query(value = "SELECT p FROM Cart p Where p.userName = userName")
	List<Cart> findByUserName(String userName);
}
