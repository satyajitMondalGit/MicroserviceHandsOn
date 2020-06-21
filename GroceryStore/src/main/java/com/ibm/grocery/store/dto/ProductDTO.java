package com.ibm.grocery.store.dto;


public class ProductDTO {

	private int id;
	private String name;
	private String category;
	private Double price;
	private Double discount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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
		return "ProductDTO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", discount="
				+ discount + "]";
	}

}
