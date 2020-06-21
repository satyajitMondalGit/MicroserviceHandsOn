package com.ibm.cart.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.cart.management.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Query("SELECT c FROM Cart c WHERE c.userName = ?1")
	List<Cart> findByUserName(String username);
	
	@Query("SELECT c FROM Cart c WHERE c.userName = ?1 and c.productName = ?2")
	List<Cart> findByUserNameandProductName(String username, String pname);
}
