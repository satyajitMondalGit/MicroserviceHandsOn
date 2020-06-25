package com.ibm.user.authentication.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ibm.user.authentication.model.Temporary;
import com.ibm.user.authentication.model.User;
import com.ibm.user.authentication.repository.TempRepository;
import com.ibm.user.authentication.repository.UserRepository;
//import com.ibm.user.authentication.resource.AuthenticationResource;
import com.ibm.user.authentication.service.UserService;
import com.ibm.user.authentication.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private UserService service;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	private UserRepository repository;

	@Autowired
	private TempRepository tempRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("JwtFilter -- 1");
		final String authorizationHeader = request.getHeader("Authorization");

		System.out.println(" header "+authorizationHeader);
		String userName = null;
		String jwtToken = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwtToken = authorizationHeader.substring(7);
			userName = jwtUtil.extractUsername(jwtToken);
			System.out.println("JwtFilter -- 2");
			// bellow part is added for select key from database
			User user = repository.findByUser(userName);

			if (user != null) {
				jwtUtil.setSecret(user.getAuthKey());
			} else {
				try {
					throw new Exception("DB is not responding");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// bellow part is add to store userid in the temporary table
			tempRepository.deleteAll();
			tempRepository.save(new Temporary(101, userName));

		} else if (authorizationHeader != null && authorizationHeader.startsWith("Transac ")) {
			jwtToken = authorizationHeader.substring(8);
			userName = jwtUtil.extractUsername(jwtToken);
			System.out.println("JwtFilter -- 3");
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = service.loadUserByUsername(userName);
			System.out.println("JwtFilter -- 4");
			if (jwtUtil.validateToken(jwtToken, userDetails)) {
				System.out.println("JwtFilter -- 5");
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				System.out.println("JwtFilter -- 6");
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		System.out.println("JwtFilter -- 7");
		filterChain.doFilter(request, response);
		System.out.println("JwtFilter -- 8");
	}

}
