package com.examples.java.reflection;

import java.beans.DesignMode;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.examples.java.oops.Employee;

public class ReflectionEx {

	public static void main(String[] args) {
		try {

			Class<?> c = Class.forName("com.examples.java.oops.Employee");
//			Class<?> c = Employee.class;
			System.out.println(c);

			Constructor<?> consrt = c.getConstructor();

			System.out.println(consrt);

			Object obj = consrt.newInstance();
			
			// Set Designation
			Method setDesignation = c.getMethod("setDesignation", String.class);
			setDesignation.invoke(obj, "Developer");
			
			// Set Department
			Method setDepartment = c.getMethod("setDepartment", String.class);
			setDepartment.invoke(obj, "Admin");			

			// Print Employee Details
			Method printDet = c.getMethod("printDetails", new Class[] {});
			printDet.invoke(obj, new Object[] {});

		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
