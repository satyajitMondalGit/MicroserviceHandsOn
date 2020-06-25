package com.ibm.cart.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//import com.ibm.cart.management.config.UserFeignRepository;
import com.ibm.cart.management.dto.CartDTO;
import com.ibm.cart.management.dto.CartMapper;
import com.ibm.cart.management.feign.OrderFeignRepository;
import com.ibm.cart.management.model.Cart;
import com.ibm.cart.management.repository.CartRepository;

@Service
public class CartService {
	
	private String username = "guest";
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private OrderFeignRepository orderFeignRepo;
	
	
	
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

	public boolean completeOrder() {
		username = getuserName();
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

	public List<CartDTO> viewCartforUser() {
		username = getuserName();
		List<CartDTO> list_cdto = new ArrayList<CartDTO>();
		if(username !=null) {
			List<Cart> list_cart = cartRepo.findByUserName(username);
			if(list_cart!=null && list_cart.size()>0) {
				for(Cart c :list_cart) {
					CartMapper mapper = new CartMapper();
					CartDTO cdto = mapper.convertCartToDTO(c);
					list_cdto.add(cdto);
				}
			}
		}
		
		return list_cdto;
	}

	

	public List<CartDTO> deleteProductByName(String pname) {
		username = getuserName();
		List<CartDTO> list_cdto = new ArrayList<CartDTO>();
		if(username !=null && pname !=null) {
			List<Cart> list_cartToDelete= cartRepo.findByUserNameandProductName(username, pname);
			if(list_cartToDelete !=null && list_cartToDelete.size()>0) {
				for(Cart c:list_cartToDelete) {
					cartRepo.deleteById(c.getId());
				}
			}
			
			list_cdto = viewCartforUser();
		}
		return list_cdto;
	}

	public boolean placeOrder(HttpHeaders headers) {
		username = getuserName();
		boolean status= false;
		List<CartDTO> list_cdto = new ArrayList<CartDTO>();
		if(username !=null) {
			List<Cart> list_cart = cartRepo.findByUserName(username);
			if(list_cart!=null && list_cart.size()>0) {
				for(Cart c :list_cart) {
					CartMapper mapper = new CartMapper();
					CartDTO cdto = mapper.convertCartToDTO(c);
					list_cdto.add(cdto);
					cartRepo.deleteById(c.getId());
				}
			}
		}
		
		if(list_cdto !=null && list_cdto.size()>0 ) {
		
			status = orderFeignRepo.addOrder(headers, list_cdto);
			
		}
		
		
		return status;
	}


	private String getuserName() {
		String username = "guest1";
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			 username = ((UserDetails)principal).getUsername();
			System.out.println("12"+username);
		} else {
			 username = principal.toString();
			
			System.out.println("111"+username);
		}
		
		
		return username;
	}

}
