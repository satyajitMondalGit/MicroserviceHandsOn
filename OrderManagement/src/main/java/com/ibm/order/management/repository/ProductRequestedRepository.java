package com.ibm.order.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.ibm.cart.management.model.Cart;
import com.ibm.order.management.model.ProductRequested;

public interface ProductRequestedRepository extends JpaRepository<ProductRequested, Integer> {
	
	@Query("SELECT c FROM ProductRequested c WHERE c.userName = ?1")
	List<ProductRequested> findByUserName(String username);
	
	@Query("SELECT c FROM ProductRequested c WHERE c.userName = ?1 and c.productName = ?2")
	List<ProductRequested> findByUserNameandProductName(String username, String pname);

}
