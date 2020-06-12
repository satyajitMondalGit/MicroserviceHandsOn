package com.ibm.user.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.user.authentication.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUser(String user);
}
