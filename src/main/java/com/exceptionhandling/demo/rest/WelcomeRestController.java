package com.exceptionhandling.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		int num =10/0;
		
		return "Welcome to REST API";
	}
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> handleException(){
		return new ResponseEntity<String>("Some problem occured",HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}
