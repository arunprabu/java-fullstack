package com.examples.boot.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public String home(Principal user) {
		return "Hi " + user.getName();
	}
	
	@RequestMapping("/greetings")
	public String greetings() {
		return "Hey! Welcome to Spring Security OAuth2 Training";
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
}
