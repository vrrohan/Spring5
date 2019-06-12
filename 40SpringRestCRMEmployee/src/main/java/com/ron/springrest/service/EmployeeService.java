package com.ron.springrest.service;

import java.util.List;

import com.ron.springrest.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployeesDetails();

	public void saveEmployeeDetails(Employee employee);

	public Employee getEmployeeDetailsById(int employeeId);

	public void deleteEmployeeDetailsById(int employeeId);

}
