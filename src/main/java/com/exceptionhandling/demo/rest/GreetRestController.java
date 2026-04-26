package com.exceptionhandling.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@GetMapping("/greet")
	public String getGreetMsg() {
		
		String name =null;
		name.toUpperCase();
		
		return "Good Morning";
	}
}
