package com.ron.springboot.SpringBootDemo.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@Value("${soccer.playerName}")
	private String playerName;

	@Value("${soccer.playerClub}")
	private String clubName;

	@GetMapping("/")
	public String displayCurrentServerTime() {
		return "Current Server Time : " + LocalDate.now();
	}

	@GetMapping("/wel")
	public String displayWelcome() {
		return "Welcome Spring Boot";
	}

	@GetMapping("/team")
	public String displayTeamInfo() {
		return "Player Name : " + this.playerName + "\nClub Name : " + this.clubName;
	}
}
