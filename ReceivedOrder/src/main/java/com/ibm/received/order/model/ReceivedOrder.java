package com.ibm.received.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order")
public class ReceivedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	private String orderItem;
	private double price;
	private boolean status;
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getOrderItem() {
		return orderItem;
	}


	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public ReceivedOrder() {
		super();
	}


	public ReceivedOrder(int id, String username, String orderItem, double price, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.orderItem = orderItem;
		this.price = price;
		this.status = status;
	}
	

}
