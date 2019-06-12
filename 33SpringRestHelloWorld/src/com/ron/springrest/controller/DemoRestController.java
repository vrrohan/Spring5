package com.ron.springrest.controller;

import org.omg.CORBA.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoRestController {

	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	private final String OPEN_WEATHER_API_CURRENT_WEATHER_URL = "api.openweathermap.org/data/2.5/weather?q="
			+ this.cityName + "&appid=c6dd31fc94da5b79c41a46ccdcdb5bfe";

	@GetMapping("/")
	public String displayHello() {
		return "home";
	}

	@PostMapping("/cityWeather")
	public String displayCityCurrentWeather(Request request, String cityName) {
		this.cityName = cityName;
		ResponseEntity<String> res = new RestTemplate().postForEntity(OPEN_WEATHER_API_CURRENT_WEATHER_URL, request,
				String.class);
		return res.getBody();
	}

	@GetMapping("/wel")
	public String displayWelcomeMessage() {
		return "welcome";
	}
}
