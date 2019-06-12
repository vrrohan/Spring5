package com.ron.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ron.springrest.dao.EmployeeDao;
import com.ron.springrest.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject customer dao
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void deleteEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeById(employeeId);
	}
}
