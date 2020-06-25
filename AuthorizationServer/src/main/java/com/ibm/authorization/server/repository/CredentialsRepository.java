package com.ibm.authorization.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.authorization.server.model.Credentials;


public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {

	@Query("SELECT u FROM Credentials u WHERE u.uname = ?1")
	Credentials findByUsername(String username);
	
}
