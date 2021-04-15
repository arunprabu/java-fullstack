package com.examples.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerHelloWorldApplication.class, args);
	}
	
	@GetMapping("/")
	public String greetings() {
		return "Welcome to Docker Training!";
	}	

}
