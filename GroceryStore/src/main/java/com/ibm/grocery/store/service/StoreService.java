package com.ibm.grocery.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.grocery.store.dto.ProductDTO;
import com.ibm.grocery.store.dto.ProductMapper;
import com.ibm.grocery.store.model.Product;
import com.ibm.grocery.store.repository.ProductRepository;

@Service
public class StoreService {
	@Autowired
	private ProductRepository productRepo;

	public boolean addItem(List<ProductDTO> list_dto) {
		boolean status= false;
		
		if(list_dto!=null && list_dto.size()>0) {
			for(ProductDTO dto:list_dto) {
				ProductMapper mapper = new ProductMapper();
				Product product = mapper.convertDTOtoProduct(dto);
				productRepo.save(product);
			}
			
			status = true;
		}
		
		return status;
	}

}
