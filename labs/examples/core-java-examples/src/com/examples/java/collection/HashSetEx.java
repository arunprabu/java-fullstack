package com.examples.java.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.examples.java.oops.Employee;

public class HashSetEx {

	public static void main(String[] args) {
		Set employees = new HashSet();

		employees.add(new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000));
		employees.add(new Employee(101, "Mukesh", 25, "Male", "Developer", "IT", 20000));
		employees.add(new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000));
		employees.add(new Employee(103, "John", 28, "Male", "Developer", "IT", 40000));
		employees.add(new Employee(104, "Mathew", 30, "Male", "Developer", "IT", 60000));
		employees.add(new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT", 70000));

		for (Object emp : employees) {
			System.out.println(emp + " " + emp.hashCode());
		}

		Employee emp1 = new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000);
		Employee emp2 = new Employee(105, "Mukesh", 25, "Male", "Developer", "IT", 20000);

		// compares Employee objects based on empId
		System.out.println(emp1.equals(emp2));
	}
}
