package com.miracle.Motion.FourCornersOfHealth.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session.LockRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miracle.Motion.FourCornersOfHealth.Entity.JwtRequest;

public class CustomFilter extends UsernamePasswordAuthenticationFilter{
	

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String requestBody;
        
        UsernamePasswordAuthenticationToken token = null;
        try {
            requestBody = IOUtils.toString(request.getReader());
            JwtRequest authRequest = objectMapper.readValue(requestBody, JwtRequest.class);
 
            token
                = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
 
            // Allow subclasses to set the "details" property
            setDetails(request, token);
 
           
        } catch(IOException e) {
            
        }
        
        return this.getAuthenticationManager().authenticate(token);
    }

}
