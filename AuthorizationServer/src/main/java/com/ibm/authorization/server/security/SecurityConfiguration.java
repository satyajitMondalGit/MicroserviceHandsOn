package com.ibm.authorization.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ibm.authorization.server.service.CustomDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomDetailsService customDetailsService;
	
//	@Bean
//	public PasswordEncoder encoder() {
//		System.out.println("6");
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	@Autowired
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("1");
//		auth.userDetailsService(customDetailsService).passwordEncoder(encoder());
//		System.out.println("2");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		System.out.println("3");
//		http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.NEVER);
//		System.out.println("4");
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		System.out.println("5");
//		return super.authenticationManagerBean();
//		
//	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		System.out.println("SecurityConfig -- 1");
		auth.userDetailsService(customDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("SecurityConfig -- 2");
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("SecurityConfig -- 3");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig -- 4");
		http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		System.out.println("SecurityConfig -- 5");
	//	http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
}
