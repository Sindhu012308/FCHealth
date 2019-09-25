package com.miracle.Motion.FourCornersOfHealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class })
public class FourCornersOfHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourCornersOfHealthApplication.class, args);
	}

}
