package com.ron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ron.model.Employee;
import com.ron.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	/*
	 * Spring will scan for a component that implements EmployeeDao Interface
	 */

	@InitBinder
	public void initBinder(WebDataBinder webBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		webBinder.registerCustomEditor(String.class, stringTrimmer);
	}

	@RequestMapping("/list")
	public String displayEmployees(Model model) {
		// get employees from employeedao
		List<Employee> employeeList = employeeService.getEmployees();
		// add employees to model
		model.addAttribute("employees", employeeList);
		return "listEmployees";
	}

	@RequestMapping("/addEmployeeForm")
	public String addNewEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployeeForm";
	}

	@PostMapping("/addEmployee")
	public String addNewEmployee(@Valid @ModelAttribute("employee") Employee employeeAddDetails, BindingResult result) {
		if (result.hasErrors()) {
			return "addEmployeeForm";
		} else {
			employeeService.saveEmployee(employeeAddDetails);
			return "redirect:/emp/list";
		}
	}

	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm(@RequestParam("employeeId") int employeeId, Model model) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		// Here "employee" is same name as in employeeUpdateForm.jsp
		// modelAttribute="employee"
		model.addAttribute("employee", employee);
		return "updateEmployeeForm";
	}

	@PostMapping("/updateEmployee")
	public String updateExistingEmployee(@Valid @ModelAttribute("employee") Employee employeeUpdateDetails,
			BindingResult result) {
		if (result.hasErrors()) {
			return "updateEmployeeForm";
		} else {
			employeeService.updateEmployee(employeeUpdateDetails);
			return "redirect:/emp/list";
		}
	}

	@RequestMapping("/deleteEmployee")
	public String deleteExistingEmployee(@RequestParam("employeeId") int employeeIdToDelete) {
		employeeService.deleteEmployee(employeeIdToDelete);
		return "redirect:/emp/list";
	}

	@RequestMapping("/loginAdmin")
	public String validateAdminLoginDetails(HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		// invalidate or destroy session if any
		session.invalidate();
		String pageToRedirect = "";

		// get admin login details like admin login & password
		String adminLoginName = request.getParameter("username").toString().trim();
		String adminLoginPassword = request.getParameter("password").toString().trim();

		final String ADMIN_LOGIN_QUERY = "select * from admin where username = ? and password = ?";

		final String USERNAME = "root";
		final String PASSWORD = "root";
		final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";

		// connect to database
		try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
			PreparedStatement prepStatement = conn.prepareStatement(ADMIN_LOGIN_QUERY);
			prepStatement.setString(1, adminLoginName);
			prepStatement.setString(2, adminLoginPassword);
			ResultSet resultSet = prepStatement.executeQuery();
			if (resultSet.first()) {
				// create Session
				HttpSession newSession = request.getSession();
				newSession.setAttribute("username", adminLoginName);
				newSession.setAttribute("password", adminLoginPassword);
				pageToRedirect = "redirect:/emp/list";
			} else {
				response.setContentType("text/html");
				PrintWriter writer = response.getWriter();
				writer.println("<html><head></head><body>	<script type=\"text/javascript\">\r\n"
						+ "		alert(\"Admin need to login first\");\r\n" + "	</script></body></html>");
				pageToRedirect = "redirect:/";
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return pageToRedirect;
	}

	@RequestMapping("/logoutAdmin")
	public String adminLogoutDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session + " Session Destroyed...");
		if (session != null) {
			System.out.println(session + " Session Destroyed...");
			session.invalidate();
			session = null;
		}
		return "redirect:/";
	}

}
