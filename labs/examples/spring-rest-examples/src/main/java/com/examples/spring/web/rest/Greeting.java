package com.examples.spring.web.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
