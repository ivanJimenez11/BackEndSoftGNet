package com.project.carrier.filter;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthorizationFilter extends OncePerRequestFilter{

	private final Logger logger = LoggerFactory.getLogger(CustomAuthorizationFilter.class);

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			logger.info("doFilterInternal method.....");
		  if (request.getServletPath().equals("/api/login") || 
				  request.getServletPath().equals("/api/token/refresh") || 
				  request.getServletPath().equals("/api/user/save")) {
			  System.out.println("here1");
			  filterChain.doFilter(request, response);
		  } else {
			String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {					
					  System.out.println("here2");
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String username = decodedJWT.getSubject();
					String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
					Stream<String> stream = Arrays.stream(roles);
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					stream.forEach(role -> {
						authorities.add(new SimpleGrantedAuthority(role));
					});
					UsernamePasswordAuthenticationToken authenticationToken = 
							new UsernamePasswordAuthenticationToken(username, null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					  System.out.println("here3");

					filterChain.doFilter(request, response);
 				} catch (Exception e) {
 					System.out.println("here4");

					// TODO: handle exception
 					logger.error("Error logging in: " + e.getMessage());
 					response.setHeader("error", e.getMessage());
 					response.setStatus(HttpStatus.FORBIDDEN.value());
// 					response.sendError(HttpStatus.FORBIDDEN.value());
 					Map<String, String> error = new HashMap<>();
 					error.put("error_message", e.getMessage());
 					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
 					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}
			} else {
				System.out.println("here5");
				filterChain.doFilter(request, response);
			}
		  }
	}

	
}