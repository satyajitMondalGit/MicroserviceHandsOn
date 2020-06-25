package com.ibm.user.authentication.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//import com.ibm.user.authentication.resource.AuthenticationResource;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

   
	
	private String secret =null;
	private int validityTime = 1000 * 60 * 60 * 10;
	
    
	
    public int getValidityTime() {
    	System.out.println("JwtUtil -- 1");
		return validityTime;
	}

	public void setValidityTime(int validityTime) {
		System.out.println("JwtUtil -- 2");
		this.validityTime = validityTime;
	}

	public String extractUsername(String token) {
		System.out.println("JwtUtil -- 3");
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
    	System.out.println("JwtUtil -- 4");
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    	System.out.println("JwtUtil -- 5");
        final Claims claims = extractAllClaims(token);
        System.out.println("JwtUtil -- 6");
        return claimsResolver.apply(claims);
        
    }
    private Claims extractAllClaims(String token) {
    	System.out.println("JwtUtil -- 7");
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    

    private Boolean isTokenExpired(String token) {
    	System.out.println("JwtUtil -- 8");
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
    	System.out.println("JwtUtil -- 9");
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
    	System.out.println("JwtUtil -- 10");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + validityTime))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    
    public Boolean validateToken(String token, UserDetails userDetails) {
    	System.out.println("JwtUtil -- 11");
        final String username = extractUsername(token);
        System.out.println("JwtUtil -- 12");
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    
    public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}


		
}

