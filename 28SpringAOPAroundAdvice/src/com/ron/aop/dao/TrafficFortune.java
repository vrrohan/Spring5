package com.ron.aop.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortune {

	public String getFortune() {
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return the fortune
		return "Lots of Incoming Request Traffic";
	}
}
