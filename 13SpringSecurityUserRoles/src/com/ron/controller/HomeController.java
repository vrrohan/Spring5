package com.ron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String displayHomePage() {
		return "homePage";
	}

	@GetMapping("/manager")
	public String displayManagersPage() {
		return "managersPage";
	}

	@GetMapping("/admin")
	public String displayAdminsPage() {
		return "adminsPage";
	}

}
