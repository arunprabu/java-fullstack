package com.examples.java.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.examples.java.oops.Employee;

public class TreeSetEx {

	public static void main(String[] args) {

		// Employees are sorted by age
		Comparator EMPLOYEE_SORT_BY_AGE = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return ((Employee) o1).getAge() - ((Employee) o2).getAge();
				}
				return 0;
			}
		};

		Set employees = new TreeSet(EMPLOYEE_SORT_BY_AGE);

		employees.add(new Employee(100, "Anand", 35, "Male", "Sr.Developer", "IT", 50000));
		employees.add(new Employee(101, "Mukesh", 25, "Male", "Developer", "IT", 20000));
		employees.add(new Employee(102, "Jancy", 30, "Female", "Sr.Developer", "IT", 30000));
		employees.add(new Employee(103, "John", 28, "Male", "Developer", "IT", 40000));
		employees.add(new Employee(104, "Mathew", 30, "Male", "Developer", "IT", 60000));
		employees.add(new Employee(105, "Mary", 27, "Female", "Sr.Developer", "IT", 70000));

		for (Object emp : employees) {
			System.out.println(emp);
		}
	}
}
