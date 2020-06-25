package com.ibm.grocery.store.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ibm.grocery.store.config.UserFeignRepository;
import com.ibm.grocery.store.util.JwtUtil;

//import com.ibm.user.authentication.model.Temporary;
//import com.ibm.user.authentication.model.User;
//import com.ibm.user.authentication.repository.TempRepository;
//import com.ibm.user.authentication.repository.UserRepository;
////import com.ibm.user.authentication.resource.AuthenticationResource;
//import com.ibm.user.authentication.service.UserService;
//import com.ibm.user.authentication.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private UserService service;
//
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	private UserFeignRepository userFeignRepo;
	
	private String username = null;
	
	private boolean securityvalidation = true;
//
//	@Autowired
//	private UserRepository repository;
//
//	@Autowired
//	private TempRepository tempRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorizationHeader = request.getHeader("Authorization");

		System.out.println(" header "+authorizationHeader);
		String userName = null;
		String jwtToken = null;

//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			jwtToken = authorizationHeader.substring(7);
//			userName = jwtUtil.extractUsername(jwtToken);
//
//			// bellow part is added for select key from database
//			User user = repository.findByUser(userName);
//
//			if (user != null) {
//				jwtUtil.setSecret(user.getAuthKey());
//			} else {
//				try {
//					throw new Exception("DB is not responding");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			// bellow part is add to store userid in the temporary table
//			tempRepository.deleteAll();
//			tempRepository.save(new Temporary(101, userName));
//
//		} else 
		if (authorizationHeader != null && authorizationHeader.startsWith("Transac ")) {
			HttpHeaders headers = new HttpHeaders();;
			headers.set("Authorization", authorizationHeader);
			try {
				username = userFeignRepo.validateServiceToken(headers);
				securityvalidation = true;
				System.out.println(" "+username);
			}catch(Exception e) {
				System.out.println(" token validation is failed");
			}
			
			
			
			
//			jwtToken = authorizationHeader.substring(8);
//			userName = jwtUtil.extractUsername(jwtToken);

			
		}

//		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = service.loadUserByUsername(userName);
//
//			if (jwtUtil.validateToken(jwtToken, userDetails)) {
//
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}

		if(securityvalidation) {
			System.out.println(" beforeFilterchain");
			filterChain.doFilter(request, response);
		}else {
			throw new IOException("Transactional token is not valid");
		}
		

	}

}
