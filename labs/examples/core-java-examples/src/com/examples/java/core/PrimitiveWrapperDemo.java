package com.examples.java.core;


import com.examples.java.oops.Employee;


public class PrimitiveWrapperDemo {
	public static void main(String[] args) {
		int a = 100;
		Integer b = new Integer(100);
		
		Integer c = b;
		
		a = (int) b;
		
		b = Integer.valueOf(a);
		
		System.out.println(a);
		
		
		Employee emp1 = new Employee();
		Employee emp2 = emp1;
		System.out.println(emp1);
		System.out.println(emp1.hashCode());
		System.out.println(emp1.equals(emp2));
		
	}
}
