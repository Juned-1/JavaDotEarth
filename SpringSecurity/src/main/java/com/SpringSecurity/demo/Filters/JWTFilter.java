package com.SpringSecurity.demo.Filters;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SpringSecurity.demo.Services.JWTService;
import com.SpringSecurity.demo.Services.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter{

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Bearer token
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        //if username is not null and user is already not authenticated
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            if(jwtService.validateToken(token, userDetails)){
                //if token is valid go to next filter
                UsernamePasswordAuthenticationToken stoken 
                =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //it takes three parameters, user principle, credentials, authorities 
                stoken.setDetails(new WebAuthenticationDetailsSource()
                .buildDetails(request));

                //setting context holder
                SecurityContextHolder.getContext().setAuthentication(stoken); //adding the token in chain
            }
        }
        filterChain.doFilter(request, response); //go to next filter
    }

}
