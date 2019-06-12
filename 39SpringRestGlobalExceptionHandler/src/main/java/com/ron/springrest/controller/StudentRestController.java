package com.ron.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ron.springrest.model.Address;
import com.ron.springrest.model.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	List<Student> studentsList;

	// define @PostConstruct to load student data only once
	/*
	 * Now becus of spring @PostConstruct , student data is loaded only once during
	 * application initialization. Now every time you click on get all students
	 * link, it will just return students list. It will not load student list again.
	 */
	@PostConstruct
	public void loadStudentData() {
		studentsList = new ArrayList<Student>();
		studentsList
				.add(new Student("Mark", "Odgen", "computers", new Address("122A", "arsenal", "england", "111111")));
		studentsList.add(
				new Student("Lio", "Messi", "arts", new Address("9th Catalan Road", "barcelona", "spain", "222222")));
		studentsList
				.add(new Student("Paul", "Allen", "computers", new Address("64B 20 Street", "la", "usa", "333333")));
		logger.info("@@@==> StudentOne : " + studentsList.get(0));
		logger.info("@@@==> StudentTwo : " + studentsList.get(1));
		logger.info("@@@==> StudentThree : " + studentsList.get(2));
	}

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
		return studentsList;
	}

	// also define endpoint for /student/{studentId} - return student at specific
	// index

	/*
	 * If we pass studentId greater than size of list ex - /student/9999 - it will
	 * throw an exception
	 */

	// 1) We will handle the bad data exception & return error in form of json data

	// 2) we make call to /student/student/9999 --> it goes into rest service,
	// encounters & handles exception. Exception handler, no more ugly html page, a
	// proper json error message

	// 3) first we need to create custom error response class - StudentErrorResponse

	// 4) then , we create a custon exception class

	// 5) update our rest service to throw the exception if student is not found

	// 6) finally we add an exception handler method using @ExceptionHandler
	@GetMapping("/get/{studentId}")
	public Student getStudentByIndex(@PathVariable int studentId) {
		if ((studentId >= studentsList.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Sorry!!! Student Not Found");
		}
		logger.info("###==>Getting Student By Student id : " + studentId);
		return studentsList.get(studentId);
	}

}
