package com.ron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/loginController", method = RequestMethod.POST)
	public String getLogin(@RequestParam String name, @RequestParam String password, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("pass", password);

		if (name.equals("admin") && password.equals("admin123")) {
			String welcomeMessage = "Welcome " + name + ". You are logged in successfully";
			model.addAttribute("welmsg", welcomeMessage);
			return "login_success";
		} else {
			String failureMessage = "Invalid username or password";
			model.addAttribute("failmsg", failureMessage);
			return "login_failure";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}

}
