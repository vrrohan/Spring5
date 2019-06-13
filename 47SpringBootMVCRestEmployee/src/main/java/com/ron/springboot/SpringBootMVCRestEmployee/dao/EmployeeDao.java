package com.ron.springboot.SpringBootMVCRestEmployee.dao;

import java.util.List;

import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int employeeId);

	public void saveNewEmployee(Employee employee);

	public void deleteEmployeeById(int employeeId);

}
