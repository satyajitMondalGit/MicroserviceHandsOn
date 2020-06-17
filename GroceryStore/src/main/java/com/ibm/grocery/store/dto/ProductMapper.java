package com.ibm.grocery.store.dto;

import com.ibm.grocery.store.model.Product;

public class ProductMapper {
	
	public Product convertDTOtoProduct(ProductDTO dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setCatagory(dto.getCategory());
		product.setPrice(dto.getPrice());
		product.setDiscount(dto.getDiscount());
		
		return product;
	}
	
	public ProductDTO convertProductToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setCategory(product.getCatagory());
		dto.setPrice(product.getPrice());
		dto.setDiscount(product.getDiscount());
		
		return dto;
	}

}
