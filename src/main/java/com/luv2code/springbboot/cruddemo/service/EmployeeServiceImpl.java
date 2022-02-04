package com.luv2code.springbboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springbboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springbboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		
		this.employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		
		return employeeDAO.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {

		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {

		employeeDAO.deleteById(employeeId);
	}

}
