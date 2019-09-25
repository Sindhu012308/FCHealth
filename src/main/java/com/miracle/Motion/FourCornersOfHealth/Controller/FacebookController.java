package com.miracle.Motion.FourCornersOfHealth.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.miracle.Motion.FourCornersOfHealth.Entity.JwtRequest;


@RestController
public class FacebookController {

	// Creates a facebook connection using the given application id and secret key.
	private FacebookConnectionFactory factory = new FacebookConnectionFactory("fBDeveloperclientID", "secretKey");


	// Redirection uri.
	@GetMapping(value = "/useapp")
	public void redirect(HttpServletResponse res) throws IOException {
		
		// Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the user.
		OAuth2Operations operations= factory.getOAuthOperations();

		// Builds the OAuth2.0 authorize url and the scope parameters.
		OAuth2Parameters params= new OAuth2Parameters();
		params.setRedirectUri("http://localhost:8082/forwardLogin");
		params.setScope("email, public_profile");

		// Url to redirect the user for authentication via OAuth2.0 authorization code grant.
		String authUrl = operations.buildAuthenticateUrl(params);
		System.out.println("Generated url is= " + authUrl);
		res.sendRedirect(authUrl);

		
		
		
		//return "" + authUrl;
	}

	// Welcome page.
	@GetMapping(value = "/forwardLogin")
	public void producer(@RequestParam("code") String authorizationCode, HttpServletResponse res) throws IOException {
		 //Creates the OAuth2.0 flow and performs the oauth handshake on behalf of the user.
		OAuth2Operations operations= factory.getOAuthOperations();

		// OAuth2.0 access token.
		// "exchangeForAccess()" method exchanges the authorization code for an access grant.
		AccessGrant accessToken= operations.exchangeForAccess(authorizationCode, "http://localhost:8082/forwardLogin", null);

		Connection<Facebook> connection= factory.createConnection(accessToken);

		// Getting the connection that the current user has with facebook.
		Facebook facebook= connection.getApi();
		// Fetching the details from the facebook.
		//String[] fields = { "id", "name", "email", "about", "birthday"};
		
		
		String[] fields = {"email"};
		
		User userProfile= facebook.fetchObject("me", User.class, fields);

				
		String authUrl = "http://localhost:8082/authenticate?email="+userProfile.getEmail();
		
        res.sendRedirect(authUrl);

	}
}
