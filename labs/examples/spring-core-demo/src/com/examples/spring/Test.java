package com.examples.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		System.out.println("Hello");
//		
//		Car bmw = new Car();
//		bmw.setColor("White");
//		bmw.setManufacturer("BMW");
//		bmw.setModel("XA");
//		
//		Engine vti = new Engine();
//		vti.setCapacity(2000);
//		vti.setNoOfCynclinders(4);
//		vti.setTorque(10);
//		
//		Engine vtix = new Engine();
//		vtix.setCapacity(4000);
//		vtix.setNoOfCynclinders(4);
//		vtix.setTorque(10);
//		
//		bmw.setEngine(vti);
//
//		System.out.println("Manufacturer: " + bmw.getManufacturer());
//		System.out.println("Color: " + bmw.getColor());
//		System.out.println("Capacity: " + bmw.getEngine().getCapacity());	
		
		// Instantiate IoC container
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		System.out.println("No of beans: " + context.getBeanDefinitionCount());
		for (String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		
		Car bmw = (Car) context.getBean("bmw");
		
		System.out.println("Manufacturer: " + bmw.getManufacturer());
		System.out.println("Color: " + bmw.getColor());
		System.out.println("Capacity: " + bmw.getEngine().getCapacity());
		
		context.registerShutdownHook();		

	}

}
