package com.ron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ron.controller.config.DemoSecurityConfig;

@Controller
public class LoginController {

	@GetMapping(DemoSecurityConfig.LOGIN_PAGE_URL)
	public String displayLoginPage() {
		return "loginPage";
	}
}
