package com.ron.springrest.controller;

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

import com.ron.springrest.model.Employee;
import com.ron.springrest.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployeesDetails();
	}

	@GetMapping("/empBy/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeDetailsById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found with Id : " + employeeId);
		}

		return employee;
	}

	// add new employee using @POST , since @POST is synonym to add new object
	@PostMapping("/newEmployee")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(0);
		employeeService.saveEmployeeDetails(employee);
		return employee;
	}

	// for update employee object use @Put , to update existing employee
	@PutMapping("/upEmployee")
	public Employee updateExistingEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployeeDetails(employee);
		return employee;
	}

	@DeleteMapping("/del/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeDetailsById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Unable to delelte. Employee not Found with Id : " + employeeId);
		}

		employeeService.deleteEmployeeDetailsById(employeeId);
		return "Employee Deleted with Id : " + employeeId;

	}
}
