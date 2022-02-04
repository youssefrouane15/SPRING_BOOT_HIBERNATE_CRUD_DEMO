package com.luv2code.springbboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springbboot.cruddemo.entity.Employee;
import com.luv2code.springbboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {

		this.employeeService = theEmployeeService;
	}

	// add the mapping to get the list of employees
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return this.employeeService.findAll();
	}
	
	// add the mapping to get an employee by id 
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = this.employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee not found with id: ---" + employeeId);
		}
		
		return employee;
	}
	
	// add the mapping to save an employee
	
	@PostMapping("/employees") 
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	// add the mapping to update an existing employee
	
	@PutMapping("/employees") 
	public Employee updateEmployee(@RequestBody Employee employee) {
				
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		//throw an exception if no employee was found
		if (employee == null) {
			throw new RuntimeException("Employee not found with id: ---" + employeeId);
		}
		
		employeeService.deleteById(employeeId);	
		
		return "Employee with Id: " + employeeId + " is deleted";
	}
	
	

}
