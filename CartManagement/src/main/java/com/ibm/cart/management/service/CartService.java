package com.ibm.cart.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cart.management.dto.CartDTO;
import com.ibm.cart.management.dto.CartMapper;
import com.ibm.cart.management.model.Cart;
import com.ibm.cart.management.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	public List<CartDTO> addItemToOrder(CartDTO dto) {
		
		
		String username = dto.getUserName();
		List<Cart> list_cart = new ArrayList<Cart>();
		List<CartDTO> list_dto = new ArrayList<CartDTO>();
		if(dto !=null) {
			CartMapper mapper = new CartMapper();
			Cart cart = mapper.convertDTOtoCart(dto);
			cartRepo.save(cart);
		}
		
		
		if(username !=null && !"".equalsIgnoreCase(username)) {
			
			list_cart = cartRepo.findByUserName(username);
		}
		
		if(list_cart !=null && list_cart.size()>0) {
			for(Cart cart:list_cart) {
				CartMapper mapper = new CartMapper();
				CartDTO dto1 = mapper.convertCartToDTO(cart);
				list_dto.add(dto1);
			}
		}
		
		return list_dto;
	}

	public List<CartDTO> deleteItemFromOrder(CartDTO dto) {
		String username = dto.getUserName();
		List<Cart> list_cart = new ArrayList<Cart>();
		List<CartDTO> list_dto = new ArrayList<CartDTO>();
		if(dto !=null) {
			CartMapper mapper = new CartMapper();
			Cart cart = mapper.convertDTOtoCart(dto);
			cartRepo.delete(cart);
		}
		
		
		if(username !=null && !"".equalsIgnoreCase(username)) {
			
			list_cart = cartRepo.findByUserName(username);
		}
		
		if(list_cart !=null && list_cart.size()>0) {
			for(Cart cart:list_cart) {
				CartMapper mapper = new CartMapper();
				CartDTO dto1 = mapper.convertCartToDTO(cart);
				list_dto.add(dto1);
			}
		}
		
		return list_dto;
	}

	public boolean completeOrder(String username) {
		boolean isSucces = false;
		List<Cart> list_cart = new ArrayList<Cart>();
		
		if(username !=null && !"".equalsIgnoreCase(username)) {
			
			list_cart = cartRepo.findByUserName(username);
			if(list_cart !=null && list_cart.size()>0) {
				for(Cart cart:list_cart) {
					
					if(!cart.isStatus()) {
						cart.setStatus(true);
						cartRepo.save(cart);
					}
					
				}
				isSucces = true;
			}
		}
		
		
		return isSucces;
	}



}
