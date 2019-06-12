package com.ron.springrest.dao;

import java.util.List;

import com.ron.springrest.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(int employeeId);

	public void deleteEmployeeById(int employeeId);

}
