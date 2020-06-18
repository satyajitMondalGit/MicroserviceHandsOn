package com.ibm.cart.management.dto;

import com.ibm.cart.management.model.Cart;

public class CartMapper {

	public Cart convertDTOtoCart(CartDTO dto) {
		Cart cart = new Cart();
		
		cart.setId(dto.getId());
		cart.setUserName(dto.getUserName());
		cart.setProductName(dto.getProductName());
		cart.setCatagory(dto.getCatagory());
		cart.setPrice(dto.getPrice());
		cart.setStatus(dto.isStatus());
		
		return cart;
	}
	
	public CartDTO convertCartToDTO(Cart cart) {
		CartDTO dto = new CartDTO();
		
		dto.setId(cart.getId());
		dto.setUserName(cart.getUserName());
		dto.setProductName(cart.getProductName());
		dto.setCatagory(cart.getCatagory());
		dto.setPrice(cart.getPrice());
		dto.setStatus(cart.isStatus());
		
		
	return dto;	
	}
	
}
