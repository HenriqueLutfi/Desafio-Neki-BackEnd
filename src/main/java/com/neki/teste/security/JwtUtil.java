package com.neki.teste.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JwtUtil {

//	@Value("${jwt.secret}")
	private static String secret = "neki";

//	@Value("${jwt.expiration}")
//	private Long expiration;
	private Long expiration = (long) 3600000;
	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, "neki".getBytes())
				.compact();
	}
	
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("neki".getBytes())
					.parseClaimsJws(token.replace("Bearer", ""))
					.getBody()
					.getSubject();
	
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		
		return null;
		//Adicionar exception
	}
}
