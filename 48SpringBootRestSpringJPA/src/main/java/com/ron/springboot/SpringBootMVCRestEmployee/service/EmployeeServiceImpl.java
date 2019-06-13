package com.ron.springboot.SpringBootMVCRestEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ron.springboot.SpringBootMVCRestEmployee.dao.EmployeeRepository;
import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		Employee emp = null;
		if (employee.isPresent()) {
			emp = employee.get();
		} else {
			throw new RuntimeException("Employee id not present : " + employeeId);
		}
		return emp;
	}

	@Override
	public void saveNewEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeId);
	}

}
