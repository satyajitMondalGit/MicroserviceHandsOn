package com.ibm.order.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ibm.order.management.dto.CartDTO;
import com.ibm.order.management.dto.CartMapper;
import com.ibm.order.management.model.ProductRequested;
import com.ibm.order.management.repository.ProductRequestedRepository;

@Service
public class OrderService {
	
	private String username = "guast";
	
	@Autowired
	private ProductRequestedRepository productRequestedRepository;
	
//	@Autowired
//	private CartMapper cartMapper;

	public boolean addOrder(List<CartDTO> listCartDto) {
		boolean status = false;
		if(listCartDto!=null) {
			
			for(CartDTO cartDto:listCartDto) {
				CartMapper cartMapper = new CartMapper();
				ProductRequested productReq = cartMapper.convertDTOtoBO(cartDto);
				productRequestedRepository.save(productReq);
			}
			status = true;
		}
		return status;
	}

	public List<CartDTO> viewOrder() {
		username = getuserName();
		List<CartDTO> list_CartDto = new ArrayList<CartDTO>();
		if(username !=null && !"".equalsIgnoreCase(username)) {
			List<ProductRequested> list_order = productRequestedRepository.findByUserName(username);
			if(list_order !=null && list_order.size()>0) {
				System.out.println("11");
				for(ProductRequested order:list_order) {
					CartMapper cartMapper = new CartMapper();
					CartDTO cartDto = cartMapper.convertBOToDTO(order);
					System.out.println(""+cartDto.toString());
					list_CartDto.add(cartDto);
				}
			}
			
			System.out.println("12");
		}
		return list_CartDto;
	}

	public List<CartDTO> viewOrderforUser() {
		username = getuserName();

		List<CartDTO> list_CartDto = new ArrayList<CartDTO>();
		if(username !=null && !"".equalsIgnoreCase(username)) {
			List<ProductRequested> list_order = productRequestedRepository.findByUserName(username);
			if(list_order !=null && list_order.size()>0) {
				System.out.println("11");
				for(ProductRequested order:list_order) {
					if(!order.isStatus()) {
						CartMapper cartMapper = new CartMapper();
						CartDTO cartDto = cartMapper.convertBOToDTO(order);
						System.out.println(""+cartDto.toString());
						list_CartDto.add(cartDto);
					}
					
				}
			}
			
			System.out.println("14");
		}
		return list_CartDto;
	}

	public List<CartDTO> deliverProductByName(String pname) {
		username = getuserName();
		if(username !=null && pname!=null) {
			List<ProductRequested> list_order = productRequestedRepository.findByUserNameandProductName(username, pname);
		
			if(list_order!=null && list_order.size()>0) {
				for(ProductRequested p :list_order) {
					p.setStatus(true);
					productRequestedRepository.deleteById(p.getId());
					productRequestedRepository.save(p);
				}
			}
			
			}
		
		List<CartDTO> list_dto = viewOrderforUser();
		return list_dto;
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
