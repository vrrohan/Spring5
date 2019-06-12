package com.ron.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ron.springrest.model.Address;
import com.ron.springrest.model.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	/*
	 * Becus of Spring REST & jackson in-built All spring POJO's are automatically
	 * converted to JSON automatically
	 */

	/*
	 * Also donot mark data-members of POJO class as private else - it will not
	 * convert them in JSON & changes will not be reflected into final result.
	 */

	/*
	 * Make all data-members of both class as public , else those members will not
	 * be saved into JSON format. Since, we are getting back student objects in form
	 * of list, hence all members must be declared as public
	 */
	@GetMapping("/all")
	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		studentsList
				.add(new Student("Mark", "Odgen", "computers", new Address("122A", "arsenal", "england", "111111")));
		studentsList.add(
				new Student("Lio", "Messi", "arts", new Address("9th Catalan Road", "barcelona", "spain", "222222")));
		studentsList
				.add(new Student("Paul", "Allen", "computers", new Address("64B 20 Street", "la", "usa", "333333")));
		logger.info("@@@==> StudentOne : " + studentsList.get(0));
		logger.info("@@@==> StudentTwo : " + studentsList.get(1));
		logger.info("@@@==> StudentThree : " + studentsList.get(2));
		return studentsList;
	}
}
