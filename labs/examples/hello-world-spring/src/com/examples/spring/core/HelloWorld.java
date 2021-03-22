package com.examples.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
//		Greetings greetings = new Greetings();
//		System.out.println(greetings.getMessage());
		
		// Step 1: Create Spring IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		
		
		System.out.println(ctx);
		System.out.println(ctx.getBeanDefinitionCount());
		
		// Step 2: Access Greetings bean from container
		Greetings greetings1 = (Greetings) ctx.getBean("greetings1");
		
		// Step 3: Print Greeting message
		System.out.println(greetings1.getMessage());
		
		Greetings greetings2 = (Greetings) ctx.getBean("greetings2");
		System.out.println(greetings2.getMessage());
	}
}
