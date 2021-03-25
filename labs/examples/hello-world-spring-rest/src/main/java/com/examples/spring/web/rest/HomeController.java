package com.examples.spring.web.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)  // Handler Mapping
	public String home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return "Hello World - " + formattedDate ;
	}
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)  // Handler Mapping
	public String listGreetings(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return "Hello World - " + formattedDate ;
	}
	
	@RequestMapping(value = "/greetings", method = RequestMethod.POST)  // Handler Mapping
	public String createGreetings(@RequestBody String message) {
				
		return "Hello World - " + message ;
	}	
}