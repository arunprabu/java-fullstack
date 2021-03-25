package com.examples.empapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@Configuration("com.examples.empapp")
public class EmployeeConfig {

		@Bean
		@Scope(scopeName="prototype")
		public Employee employee()
		{
			return new Employee();
		}
		
		@Bean
		public EmployeeService empService()
		{
			return new EmployeeService();
		}
}
