package com.ron.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ron.model.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String showAdminForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "adminForm";
	}
}
