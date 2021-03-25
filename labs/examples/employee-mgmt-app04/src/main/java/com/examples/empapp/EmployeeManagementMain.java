package com.examples.empapp;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.empapp.config.EmployeeConfig;
import com.examples.empapp.exception.EmployeeValidationException;
import com.examples.empapp.exception.NoEmployeeFoundException;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

public class EmployeeManagementMain {

	private static Scanner scanner = null;
	private static AbstractApplicationContext context = null;
	private static EmployeeService empService = null;

	public static void main(String[] args) {
		int option;
		
		// XML based configuation
		//context = new ClassPathXmlApplicationContext("beans-config.xml");

		// Java based configuration
		context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		scanner = new Scanner(System.in);
		
		// Get EmployeeService bean from container
		empService = (EmployeeService) context.getBean("empService");
		
		System.out.println("Welcome to Employee Management App!!!");

		try {
			do {
				System.out.println();
				System.out.println("1. Add Employee");
				System.out.println("2. View Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. View All Employees");
				System.out.println("6. Exit");

				System.out.print("\nEnter your option: ");
				option = scanner.nextInt();

				try {
					switch (option) {
					case 1:
						createEmployee();
						break;
					case 2:
						viewEmployee();
						break;
					case 3:
						updateEmployee();
						break;
					case 4:
						deleteEmployee();
						break;
					case 5:
						listEmployees();
						break;
					case 6:
						exit();
						break;
					default:
						System.out.println("Invalid option entered. Please enter correct option.");
						break;
					}
				} catch (NoEmployeeFoundException | EmployeeValidationException e) {
					System.out.println(e.getMessage());
				}

			} while (option != 7);
		} finally {
			// releasing the resource
			releaseResources();
		}

		System.out.println("\nThank you!!!");
	}

	private static void createEmployee() throws EmployeeValidationException {
		
		// Get Employee bean from container
		Employee emp = 	(Employee) context.getBean("employee"); 

		System.out.println("\nEnter employee details...");

		captureDetail(emp);

		boolean isCreateSuccess = empService.add(emp);

		String message = isCreateSuccess ? "Employee created successfully." : "Employee creation failed.";
		System.out.println(message);
	}

	private static void viewEmployee() throws NoEmployeeFoundException {
		System.out.print("\nEnter employee id to view: ");
		int id = scanner.nextInt();

		Employee emp = empService.get(id);

		if (emp == null) {
			throw new NoEmployeeFoundException("No employee found to show for given id - " + id);
		}

		printHeader();
		printDetail(emp);
		System.out.println();

	}

	private static void updateEmployee() throws NoEmployeeFoundException, EmployeeValidationException {

		System.out.print("\nEnter employee id to update: ");
		int id = scanner.nextInt();

		Employee emp = empService.get(id);

		if (emp == null) {
			throw new NoEmployeeFoundException("No employee found to update for given id - " + id);
		}
		
		captureDetail(emp);

		boolean isUpdateSuccess = empService.update(emp);

		String message = isUpdateSuccess ? "Employee updated successfully." : "Employee updation failed.";
		System.out.println(message);
	}

	private static void deleteEmployee() throws NoEmployeeFoundException {

		System.out.print("\nEnter employee id to delete: ");
		int id = scanner.nextInt();

		Employee emp = empService.get(id);
		if (emp == null) {
			throw new NoEmployeeFoundException("No employee found to delete for given id - " + id);
		}

		boolean isDeleteSuccess = empService.delete(emp);

		String message = isDeleteSuccess ? "Employee deleted successfully." : "Employee deletion failed.";
		System.out.println(message);
	}

	private static void listEmployees() {

		Collection<Employee> empList = empService.getAll();

		printHeader();

		for (Object emp : empList) {
			printDetail((Employee) emp);
		}
		System.out.println();
	}

	private static void captureDetail(Employee emp) throws EmployeeValidationException {
		System.out.print("Enter name: ");
		emp.setName(scanner.next());

		System.out.print("Enter age: ");
		try {
			int age = Integer.parseInt(scanner.next());
			emp.setAge(age);
		} catch (NumberFormatException e) {
			throw new EmployeeValidationException("Invalid input for age. Please enter integer value.");
		}

		System.out.print("Enter designation: ");
		emp.setDesignation(scanner.next());

		System.out.print("Enter department: ");
		emp.setDepartment(scanner.next());

		System.out.print("Enter country: ");
		emp.setCountry(scanner.next());
	}

	private static void printHeader() {
		System.out.format("\n%5s %15s %5s %15s %15s %15s", "ID", "Name", "Age", "Designation", "Department", "Country");
	}

	private static void printDetail(Employee emp) {
		if (emp == null) {
			return;
		}

		System.out.format("\n%5d %15s %5d %15s %15s %15s", emp.getId(), emp.getName(), emp.getAge(),
				emp.getDesignation(), emp.getDepartment(), emp.getCountry());
	}
	
	private static void exit() {
		releaseResources();
		System.out.println("\nThank you!!!");
		System.exit(0);
	}
	
	private static void releaseResources()
	{
		scanner.close();
		context.registerShutdownHook();
	}
}
