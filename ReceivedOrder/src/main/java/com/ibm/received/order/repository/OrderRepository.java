package com.ibm.received.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.received.order.model.ReceivedOrder;

public interface OrderRepository extends JpaRepository<ReceivedOrder, Integer> {
	
	List<ReceivedOrder> findbyUserName(String username);
	List<ReceivedOrder> findbyUserName_orderItem (String username, String orderItem);

}
