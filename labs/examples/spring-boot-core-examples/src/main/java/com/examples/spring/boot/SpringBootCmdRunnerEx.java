package com.examples.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Uncomment @SpringBootApplication annotation to test CommandLineRunner example
//@SpringBootApplication
public class SpringBootCmdRunnerEx implements CommandLineRunner 
{
	
	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	Greetings greetings;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCmdRunnerEx.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(greetings.getMessage() + " - " + "Spring Boot Command Runner Example!");
	}

}
