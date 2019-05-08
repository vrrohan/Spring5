package com.ron.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ron.dao.EmployeeDao;
import com.ron.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employeeAddDetails) {
		// TODO Auto-generated method stub
		employeeDao.saveEmployeeDetails(employeeAddDetails);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employeeUpdateDetails) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployeeDetails(employeeUpdateDetails);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeDetailsById(employeeId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeIdToDelete) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeDetails(employeeIdToDelete);
	}

}
