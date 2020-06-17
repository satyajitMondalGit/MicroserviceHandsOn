package com.ibm.grocery.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "category")
	private String category;
	
	@Column(name= "price")
	private Double price;
	
	@Column(name= "discount")
	private Double discount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagory() {
		return category;
	}

	public void setCatagory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", catagory=" + category + ", price=" + price + ", discount="
				+ discount + "]";
	}

	public Product(long id, String name, String category, Double price, Double discount) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}

	public Product() {
		super();
	}
	
	
	
}