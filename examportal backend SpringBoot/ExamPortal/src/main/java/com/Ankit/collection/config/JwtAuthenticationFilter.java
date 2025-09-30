package com.Ankit.collection.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Ankit.collection.service.impl.UserDetailServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailServiceImpl userdetailsservicesssImpllll;
	
	@Autowired
	private Jwtutil Jwtutiless;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 final String requestTokenHeader = request.getHeader("Authorization");
	        String username = null;
	        String jwtToken = null;

	        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
	            jwtToken = requestTokenHeader.substring(7);

	            try {
	                username = this.Jwtutiless.extractUsername(jwtToken);
	            } catch (ExpiredJwtException e) {
	                e.printStackTrace();
	                System.out.println("JWT token has expired");
	            } catch (Exception e) {
	                e.printStackTrace();
	                System.out.println("Error");
	            }
	        } else {
	            System.out.println("Invalid token, does not start with Bearer");
	        }
	        
	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	        	
	        	UserDetails userDetails = this.userdetailsservicesssImpllll.loadUserByUsername(username);
	        	
	        	UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        	
	        	 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	        	 
	        	 SecurityContextHolder.getContext().setAuthentication(authToken);
	        }
	        else {
				System.out.println("token not vallid");
			}
	        
	        filterChain.doFilter(request, response);
		// TODO Auto-generated method stub
		
	}

}
