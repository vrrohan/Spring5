package com.ron.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ron.model.Person;

@Controller
public class PersonController {

	@InitBinder
	public void initBinder(WebDataBinder webBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		webBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "login";
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("person") Person person, BindingResult result) {

		if (result.hasErrors()) {
			return "login_failure";
		} else {
			System.out.println("submit form runs");
			return "login_success";
		}
	}

}
