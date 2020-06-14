package com.ibm.received.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.received.order.model.TokenStored;

public interface TokenRepository extends JpaRepository<TokenStored, Integer> {

	List<TokenStored> findByToken(String token);
	TokenStored findByUsername(String username);
}
