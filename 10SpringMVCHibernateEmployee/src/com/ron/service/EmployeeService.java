package com.ron.service;

import java.util.List;

import com.ron.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee employeeAddDetails);

	public void updateEmployee(Employee employeeUpdateDetails);

	public Employee getEmployeeById(int employeeId);

	public void deleteEmployee(int employeeIdToDelete);
	
}
