package com.ibm.received.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_list")
public class ItemList {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String product_Name;
private double price;
private String item_catagory;
private double discount;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct_Name() {
	return product_Name;
}
public void setProduct_Name(String product_Name) {
	this.product_Name = product_Name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getItem_catagory() {
	return item_catagory;
}
public void setItem_catagory(String item_catagory) {
	this.item_catagory = item_catagory;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public ItemList(int id, String product_Name, double price, String item_catagory, double discount) {
	super();
	this.id = id;
	this.product_Name = product_Name;
	this.price = price;
	this.item_catagory = item_catagory;
	this.discount = discount;
}
public ItemList() {
	super();
}


}
