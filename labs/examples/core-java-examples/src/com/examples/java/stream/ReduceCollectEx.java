package com.examples.java.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.examples.java.oops.Employee;


public class ReduceCollectEx {
	
	public static void main(String args[])
	{
		Map<Integer, Employee<Double>> employees = new HashMap<>();
		employees.put(100, new Employee<>(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000.0));
		employees.put(101, new Employee<>(101, "Mary", 45, "Female", "Manager", "Admin", 75000.0));
		employees.put(102, new Employee<>(102, "John", 25, "Male", "Lead", "Admin", 25000.0));
		employees.put(103, new Employee<>(103, "Joe", 30, "Female", "Developer", "IT", 35000.0));
		
		// 
		double totalSalary = employees.values()
					.stream()
					.map(Employee::getSalary) // stream of salary
					.reduce(0.0, (a,b) -> a.doubleValue() + b.doubleValue()).doubleValue();    // sum of salary
		
		System.out.println("Total Salary: " + totalSalary);
					// 0 + 50000 
					// 50000 + 75000
					// 125000 + 25000
					// 150000 + 35000
					// 185000
					//Identity	=> Initial value or default value
					//Accumulator => Accumulates partial output with current value
		
		Averager averager = employees.values()
							.stream()
							.map(Employee::getSalary) // stream of salary
							.collect(Averager::new, Averager::accept, Averager::combine);
		
					// 185000/4 => 46250
		System.out.println(averager.average());
		
		double avgSalary = employees.values()
				.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary)).doubleValue();		
					// Supplier	=> Factory method to create new instance of container object
					// Accumulator => Accumulates partial output with current value
					// Combiner	=> Combines output of similar container into this container
		System.out.println(avgSalary);
		
		
		Map<String, Long> groupByDept = 
				employees.values()
					.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(groupByDept);
	}
}
