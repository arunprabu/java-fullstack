package com.examples.spring.boot.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greetings {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
