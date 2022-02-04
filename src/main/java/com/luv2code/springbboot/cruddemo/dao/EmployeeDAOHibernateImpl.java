package com.luv2code.springbboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springbboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define a field for entityManager

	private EntityManager entityManager;

	// set up the constructor injection

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntitymanager) {
		this.entityManager = theEntitymanager;
	}

	@Override
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query and get the result list
		List<Employee> employees = query.getResultList();
		
		// returning the results
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {

		// get the current hibernate session
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employee = currentSession.get(Employee.class, employeeId);
		
		//return the employee
		
		return employee;
	}

	@Override
	public void save(Employee employee) {

		// get the current hibernate session
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		// save the employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		
		// get the current hibernate session
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		// create the query to delete the object with primay key = employeeId
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", employeeId);
		
		// execute the query
		query.executeUpdate();		
	}

}
