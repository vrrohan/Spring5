package com.ron.springboot.SpringBootMVCRestEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ron.springboot.SpringBootMVCRestEmployee.dao.EmployeeDao;
import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void saveNewEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.saveNewEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeById(employeeId);
	}

}
