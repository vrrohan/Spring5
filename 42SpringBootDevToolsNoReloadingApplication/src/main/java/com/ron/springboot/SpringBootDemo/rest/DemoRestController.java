package com.ron.springboot.SpringBootDemo.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/")
	public String displayCurrentServerTime() {
		return "Current Server Time : " + LocalDate.now();
	}

	@GetMapping("/wel")
	public String displayWelcome() {
		return "Welcome Spring Boot";
	}
}
