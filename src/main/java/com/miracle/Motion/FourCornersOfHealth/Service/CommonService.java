package com.miracle.Motion.FourCornersOfHealth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommonService {
	
	@Autowired
	private RestTemplate restTemplate;

	   public long getCurrentUserID() {
	      String url = "http://localhost:8080/user";   
	      return restTemplate.getForObject(url, Long.class);
	   }
	  
	   @Bean
	   public RestTemplate restTemplate() {
	       return new RestTemplate();
	   }
	   
	
}
