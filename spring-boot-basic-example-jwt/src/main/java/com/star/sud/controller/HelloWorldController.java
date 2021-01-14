package com.star.sud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value = "/hello")
	public String helloWorld() {
		return "Welcome to Spring Boot JWT";
	}

}
