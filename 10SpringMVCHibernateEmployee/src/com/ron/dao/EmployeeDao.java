package com.ron.dao;

import java.util.List;

import com.ron.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();

	public void saveEmployeeDetails(Employee employeeAddDetails);

	public void updateEmployeeDetails(Employee employeeUpdateDetails);

	public Employee getEmployeeDetailsById(int employeeId);
	
	public boolean getAdminLoginDetails(String username, String password);

	public void deleteEmployeeDetails(int employeeIdToDelete);

	
}
