package com.ron.springboot.SpringBootMVCRestEmployee.rest;

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

import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;
import com.ron.springboot.SpringBootMVCRestEmployee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployeesAsJson() {
		return employeeService.getAllEmployeesDetails();
	}

	@GetMapping("/empBy/{employeeId}")
	public Employee getEmployeeByIdAsJson(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeDetailsById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found with id : " + employeeId);
		}
		return employee;
	}

	// add new employee
	@PostMapping("/add")
	public Employee addNewEmployeeAsJson(@RequestBody Employee employee) {
		employee.setEmployeeId(0);
		employeeService.saveNewEmployeeDetails(employee);
		return employee;
	}

	// update existing employee
	@PutMapping("/up")
	public Employee updateExistingEmployeeAsJson(@RequestBody Employee employee) {
		employeeService.saveNewEmployeeDetails(employee);
		return employee;
	}

	@DeleteMapping("/rm/{employeeId}")
	public String deleteExistingEmployeeByIdAsJson(@PathVariable int employeeId) {
		Employee employee = employeeService.getEmployeeDetailsById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found with id : " + employeeId);
		}
		employeeService.deleteEmployeeDetailsById(employeeId);
		return "Employee deleted with id : " + employeeId;
	}
}
