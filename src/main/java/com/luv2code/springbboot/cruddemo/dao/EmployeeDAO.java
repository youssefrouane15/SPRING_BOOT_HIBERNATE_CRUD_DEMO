package com.luv2code.springbboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springbboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int employeeId);
	
	public void save(Employee employee);
	
	public void deleteById(int employeeId);

}
