package com.examples.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Uncomment @SpringBootApplication annotation to test ApplicationRunner example
//@SpringBootApplication
public class SpringBootAppRunnerEx implements ApplicationRunner 
{
	
	@Autowired
	Greetings greetings;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppRunnerEx.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String msg = args.getNonOptionArgs().size() > 0 ? args.getNonOptionArgs().get(0) : "";
		System.out.println(greetings.getMessage() + " - Spring Boot Application Runner Example! - " + msg);		
	}

}
