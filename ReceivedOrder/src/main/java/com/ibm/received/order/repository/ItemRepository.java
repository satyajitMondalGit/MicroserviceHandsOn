package com.ibm.received.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.received.order.model.ItemList;

public interface ItemRepository extends JpaRepository<ItemList, Integer> {
	ItemList findbyproduct_Name(String product_Name);
	
	List<ItemList> findbyitem_catagory(String item_catagory);
}
