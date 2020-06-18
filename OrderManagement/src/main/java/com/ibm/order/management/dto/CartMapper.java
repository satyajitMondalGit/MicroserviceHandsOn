package com.ibm.order.management.dto;

import com.ibm.order.management.model.ProductRequested;


public class CartMapper {

	public ProductRequested convertDTOtoBO(CartDTO dto) {
		ProductRequested order = new ProductRequested();
		
		order.setId(dto.getId());
		order.setUserName(dto.getUserName());
		order.setProductName(dto.getProductName());
		order.setCatagory(dto.getCatagory());
		order.setPrice(dto.getPrice());
		order.setStatus(dto.isStatus());
		
		return order;
	}
	
	public CartDTO convertBOToDTO(ProductRequested order) {
		CartDTO dto = new CartDTO();
		
		dto.setId(order.getId());
		dto.setUserName(order.getUserName());
		dto.setProductName(order.getProductName());
		dto.setCatagory(order.getCatagory());
		dto.setPrice(order.getPrice());
		dto.setStatus(order.isStatus());
		
		
	return dto;	
	}
	
}
