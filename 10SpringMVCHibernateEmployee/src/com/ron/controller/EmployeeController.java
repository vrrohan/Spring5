package com.ron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ron.dao.EmployeeDao;
import com.ron.model.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeDao employee;
	/*
	 * Spring will scan for a component that implements EmployeeDao Interface
	 */

	@RequestMapping("/list")
	public String displayEmployees(Model model) {
		// get employees from employeedao
		List<Employee> employeeList = employee.getAllEmployees();
		// add employees to model
		model.addAttribute("employees", employeeList);
		return "listEmployees";
	}
	
	@RequestMapping("/addEmployee")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
}
