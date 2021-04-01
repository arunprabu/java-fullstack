package com.examples.hibernate.core;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.examples.hibernate.model.Employee;

public class EmployeeManager {

	private static SessionFactory factory;

	public static void main(String[] args) {

		// STEP 1: Create Configuration
		Configuration config = new Configuration();
		// loads hibernate mapping configs from annotated class
		config.addAnnotatedClass(Employee.class);

		// STEP 2: Create SessionFactory
		factory = config.buildSessionFactory();
		System.out.println("Connected to databased - " + factory);

		// STEP 3: Create Session
		// STEP 4: Transaction Management
		// STEP 5: Perform CRUD Operations using Query/Criteria API
		Employee emp = new Employee();
		emp.setName("Mani");
		emp.setAge(25);
		emp.setGender("M");
		emp.setContractor(false);
		emp.setDesignation("Developer");
		emp.setDepartment("IT");
		emp.setAddress("Bengaluru");
		emp.setCountry("India");

		listEmployees();

		Integer empId1 = createEmployee(emp);

		listEmployees();

		updateEmployee(empId1, "Admin", "Software Engineer");

		listEmployees();

		deleteEmployee(empId1);

		listEmployees();

		// Uncomment to test different query types
//		listEmployeesWithNativeQuery();
//		listEmployeesWithHSQL();
//		listEmployeesWithCriteria();

	}

	// CREATE EMPLOYEE
	private static Integer createEmployee(Employee employee) {

		Transaction tnx = null;
		Integer id = -1;

		try (Session session = factory.openSession()) {
			tnx = session.beginTransaction();

			// Insert data into table by supplying the persistent object
			id = (Integer) session.save(employee);

			System.out.println("\nEmployee inserted successfully with ID - " + id);

			tnx.commit();
		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}

		return id;
	}

	// UPDATE EMPLOYEE DETAILS
	private static void updateEmployee(Integer empId, String dept, String designation) {
		Transaction tnx = null;

		try (Session session = factory.openSession()) {
			tnx = session.beginTransaction();

			// Update Employee Details
			Employee empForUpdate = session.get(Employee.class, empId);
			empForUpdate.setDepartment(dept);
			empForUpdate.setDesignation(designation);
			session.update(empForUpdate);

			System.out.format("\nEmployee %s updated successfuly.\n", empId);

			tnx.commit();

		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}
	}

	// DELETE EMPLOYEE DETAILS
	private static void deleteEmployee(Integer empId) {
		Transaction tnx = null;

		try (Session session = factory.openSession()) {
			tnx = session.beginTransaction();

			// Update Employee Details
			Employee empForDelete = session.get(Employee.class, empId);
			session.delete(empForDelete);

			System.out.format("\nEmployee %s deleted successfuly.\n", empId);

			tnx.commit();

		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}
	}

	private static void listEmployees() {
		listEmployeesWithHSQL();
	}

	// LIST EMPLOYEE DETAILS WITH HQL QUERY
	private static void listEmployeesWithHSQL() {
		Transaction tnx = null;

		try (Session session = factory.openSession()) {
			tnx = session.beginTransaction();

			// List Employee Details
			List<Employee> employees = session.createQuery("FROM Employee").list();

			System.out.println("ID \tName \tAge \tGender \tDepartment \tDesignation");
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
						+ employee.getGender() + "\t" + employee.getDepartment() + "\t" + employee.getDesignation());
			}

			tnx.commit();

		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}
	}

	// LIST EMPLOYEE DETAILS WITH NATIVE QUERY
	private static void listEmployeesWithNativeQuery() {
		Transaction tnx = null;

		try (Session session = factory.openSession()) {
			tnx = session.beginTransaction();

			// List Employee Details
			List<Employee> employees = session.createNativeQuery("SELECT * FROM Employee", Employee.class).list();

			System.out.println("ID \tName \tAge \tGender \tDepartment \tDesignation");
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
						+ employee.getGender() + "\t" + employee.getDepartment() + "\t" + employee.getDesignation());
			}

			tnx.commit();

		} catch (HibernateException he) {
			tnx.rollback();
			he.printStackTrace();
		}
	}

	private static void listEmployeesWithCriteria() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Employee.class);
			List<Employee> employees = criteria.list();

			System.out.println("ID \tName \tAge \tGender \tDepartment \tDesignation");
			for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();

				System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
						+ employee.getGender() + "\t" + employee.getDepartment() + "\t" + employee.getDesignation());
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
