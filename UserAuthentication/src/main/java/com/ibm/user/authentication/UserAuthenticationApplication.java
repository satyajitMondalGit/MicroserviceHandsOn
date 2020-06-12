package com.ibm.user.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ibm.user.authentication.model.User;
import com.ibm.user.authentication.repository.UserRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class UserAuthenticationApplication {

	
	@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
    	List<User> list_User = new ArrayList<User>();
    	
    	list_User.add(new User(101, "satya", "pwd", "ADMIN"));
    	list_User.add(new User( 102, "user1", "pwd1", "USER"));
    	list_User.add(new User(103, "user2", "pwd2", "USER"));
    	       
        repository.saveAll(list_User);
    }
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
	}

}
