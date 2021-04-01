package com.examples.empapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.examples.empapp.exception.DataException;
import com.examples.empapp.model.Employee;

@Repository
@Transactional
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext	
	EntityManager entityManager;	
	
	@Override
	public boolean create(Employee employee) throws DataException {
		entityManager.persist(employee);
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		entityManager.merge(employee);
		return true;
	}

	@Override
	public boolean delete(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
		return true;
	}

	@Override
	public Employee get(int empId) {
		Employee employee = entityManager.find(Employee.class, empId);
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		return employees;
	}

}
