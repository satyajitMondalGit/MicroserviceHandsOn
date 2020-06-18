package com.ibm.order.management.dto;

public class CartDTO {
	
	private long id;
	private String userName;
	private String productName;
	private String catagory;
	private double price;
	private boolean status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
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
	@Override
	public String toString() {
		return "CartDTO [id=" + id + ", userName=" + userName + ", productName=" + productName + ", catagory="
				+ catagory + ", price=" + price + ", status=" + status + "]";
	}
	
	
	
}