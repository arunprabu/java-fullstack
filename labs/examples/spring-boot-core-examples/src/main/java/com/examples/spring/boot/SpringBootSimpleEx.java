package com.examples.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	// same as @ComponentScan, @Configuration, @EnableAutoConfiguration
public class SpringBootSimpleEx {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleEx.class, args);
		
//		new SpringApplicationBuilder(SpringBootSimpleEx.class)
//		.properties("spring.config.name:conf")
//		.build()
//		.run(args);
		
		System.out.println("Welcome to Spring Boot training :) - Spring Boot Simple example!");
	}	
}
