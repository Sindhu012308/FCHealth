package com.miracle.Motion.FourCornersOfHealth.Controller;


import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.Motion.FourCornersOfHealth.Entity.JwtRequest;
import com.miracle.Motion.FourCornersOfHealth.Entity.JwtResponse;
import com.miracle.Motion.FourCornersOfHealth.Service.JwtService;
import com.miracle.Motion.FourCornersOfHealth.util.JWTUtility;

@RestController
public class JWTController {

	@Autowired
	JwtService jwtService;	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUtility jwtTokenUtil;

	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
//	public void login(HttpServletResponse res) throws IOException{
//		
//		//Here I redirect to facebook
//		
//		res.sendRedirect("http://localhost:8082/useapp");
//		
//	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String email) throws Exception {
		//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = jwtService
				.loadUserByUsername(email);
		final String token = jwtTokenUtil.generateToken(userDetails); 
		
		System.out.println("Token= "+token);
		
		String[] roles  = new String[]{userDetails.getAuthorities().toString()};
		
		//roles = userDetails.getAuthorities().toArray(roles);
		
		JwtResponse jres = new JwtResponse(token, roles);
		
		System.out.println(jres.getToken() + "   "+ jres.getRole());

		return ResponseEntity.ok(jres);
	}
	
//	private void authenticate(String username, String password) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
		


}
