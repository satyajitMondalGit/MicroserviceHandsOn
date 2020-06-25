package com.ibm.grocery.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ibm.grocery.store.dto.CartDTO;
import com.ibm.grocery.store.dto.ProductDTO;
import com.ibm.grocery.store.dto.ProductMapper;
import com.ibm.grocery.store.feign.CartFeignRepository;
import com.ibm.grocery.store.model.Product;
import com.ibm.grocery.store.repository.ProductRepository;

@Service
public class StoreService {
	
	private String username = "guest";
	

	
	@Autowired
	private CartFeignRepository cartFeignRepo;
	
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

	
	public List<ProductDTO> getProductByCagegory(String category) {
		
		List<ProductDTO> list_pdto = new ArrayList<ProductDTO>();
		
		if(category !=null) {
			List<Product> list_Product = productRepo.findByCategory(category);
			System.out.println("1");
			if(list_Product !=null && list_Product.size()>0) {
				for(Product p: list_Product) {
					ProductMapper mapper = new ProductMapper();
					ProductDTO pdto = mapper.convertProductToDTO(p);
					list_pdto.add(pdto);
				}
			}
		}

		
		return list_pdto;
	}


	public ProductDTO getProductByName(String pname) {
		ProductDTO pdto = new ProductDTO();
		if(pname !=null) {
			Product p = productRepo.findByName(pname);
			if(p!=null) {
				ProductMapper mapper = new ProductMapper();
				 pdto = mapper.convertProductToDTO(p);
				 System.out.println("22");
			}
		}
		
		
		return pdto;
	}


	


	public boolean addToCart(HttpHeaders headers, String pname) {
		username = getuserName();
		CartDTO cdto = new CartDTO();
		if(pname !=null) {
			Product p = productRepo.findByName(pname);
			if(p!=null) {
				
				double price = caculatePrice(p);
				cdto.setId(p.getId());
				cdto.setUserName(username);
				cdto.setProductName(p.getName());
				cdto.setCatagory(p.getCatagory());
				cdto.setPrice(price);
				cdto.setStatus(false);
				
				 System.out.println("22");
			}
		}
		
		
		List<CartDTO> list_cdto = cartFeignRepo.addItemToCart(headers, cdto);
		if(list_cdto !=null && list_cdto.size()>0) {
			return true;
		}
		return false;
	}


	private double caculatePrice(Product p) {
		double price = p.getPrice() * ((100-p.getDiscount())/100);
		return price;
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
