package com.ron.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ron.model.Person;

/*
The model presents a placeholder to hold the information you want to display on the view. 
It could be a string, which is in your above example, or it could be an object containing bunch of properties.

Example 1 If you have - return new ModelAndView("welcomePage","WelcomeMessage","Welcome!");
... then in your jsp, to display the message, you will do:-
	Hello Stranger! ${WelcomeMessage} // displays Hello Stranger! Welcome!

Example 2 If you have - 

MyBean bean = new MyBean();
bean.setName("Mike!");
bean.setMessage("Meow!");

return new ModelAndView("welcomePage","model",bean);
... then in your jsp, you can do:-
Hello ${model.name}! {model.message} // displays Hello Mike! Meow!

============================

new ModelAndView("welcomePage", "WelcomeMessage", message);
is shorthand for

ModelAndView mav = new ModelAndView();
mav.setViewName("welcomePage");
mav.addObject("WelcomeMessage", message);

link :- https://stackoverflow.com/questions/5055358/what-is-model-in-modelandview-from-spring-mvc
*/

@Controller
public class PersonController {

	private static final String NAME_FIELD_EMPTY_MESSAGE = "Name Field is Empty. Please fill you name.";
	private static final String EMAIL_FIELD_EMPTY_MESSAGE = "Email Field is Empty. Please fill valid email.";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showForm() {
		/*
		 * ModelAndView constructor that takes 3 arguments - (viewName,
		 * modelAttributeName, Model Object)
		 */
		Map<String, String> countryItems = new LinkedHashMap<String, String>();
		countryItems.put("US", "United States");
		countryItems.put("IT", "Italy");
		countryItems.put("UK", "United Kingdom");
		countryItems.put("FR", "France");
		return new ModelAndView("login", "person", new Person());
	}

	@RequestMapping(value = "/submitForm", method = RequestMethod.POST)
	public String submit(@ModelAttribute("person") Person person, BindingResult result, ModelMap model) {
		/*
		 * LinkedHashMap<String, String> countryItems = new LinkedHashMap<String,
		 * String>(); countryItems.put("US", "USA"); countryItems.put("IND", "INDIA");
		 * countryItems.put("AUS", "AUSTRALIA"); countryItems.put("ENG", "ENGLAND");
		 */

		if (result.hasErrors()) {
			return "login_failure";
		}
		if (isEmailFieldEmpty(result)) {
			model.put("failmsg", EMAIL_FIELD_EMPTY_MESSAGE);
			return "login_failure";
		} else {
			System.out.println("submit form runs");
			model.addAttribute("firstname", person.getFirstname());
			model.addAttribute("lastname", person.getLastname());
			model.addAttribute("email", person.getEmail());
			model.addAttribute("gender", person.getGender());
			model.addAttribute("mealType", person.getMealType());
			model.addAttribute("meals", person.getMeals());
			model.addAttribute("dateOfTravel", person.getDateOfTravel());
			model.addAttribute("fromCity", person.getFromCity());
			model.addAttribute("toCity", person.getToCity());
			return "login_success";
		}
	}

	private boolean isEmailFieldEmpty(BindingResult result) {
		// TODO Auto-generated method stub
		return (result.getFieldValue("email").toString().trim().length() > 0) ? false : true;
	}

}
