package com.ron.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/loginController", method = RequestMethod.POST)
	public String getLogin(HttpServletRequest request) {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		if (username.equals("admin") && password.equals("admin123")) {
			String welcomeMessage = "Welcome " + username + ". You are logged in successfully";
			request.setAttribute("welmsg", welcomeMessage);
			return "login_success";
		} else {
			String failureMessage = "Invalid username or password";
			request.setAttribute("failmsg", failureMessage);
			return "login_failure";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}

}
