package com.ron.springboot.SpringBootMVCRestEmployee.service;

import java.util.List;

import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployeesDetails();

	public Employee getEmployeeDetailsById(int employeeId);

	public void saveNewEmployeeDetails(Employee employee);

	public void deleteEmployeeDetailsById(int employeeId);

}
