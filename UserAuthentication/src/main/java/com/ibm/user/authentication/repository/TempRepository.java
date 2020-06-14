package com.ibm.user.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.user.authentication.model.Temporary;

//import com.ibm.user.authentication.model.User;

public interface TempRepository extends JpaRepository<Temporary, Integer>{

}
