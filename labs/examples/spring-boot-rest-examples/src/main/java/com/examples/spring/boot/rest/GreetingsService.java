package com.examples.spring.boot.rest;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsService {

	@RequestMapping(value = { "/", "/greetings", "/greeting-msg" }, method = RequestMethod.GET)
	public String greeting() {
		return "Welcome to RESTful services training :)";
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.GET, params = { "msg" })
	public String getGreeting(@RequestParam(required = false, defaultValue = "Hello") String msg) {
		return "Welcome to RESTful services training :) - " + msg;
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "text/plain" })
	public @ResponseBody String postGreetingMap(@RequestBody String greeting) {
		return "Welcome to RESTful services training :) - " + greeting;
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "application/xml",
			"application/json" }, produces = { "application/xml", "application/json" })
	public Greetings postGreetingObject(@RequestBody Greetings greeting) {
		greeting.setMessage(greeting.getMessage() + " - POST object mapping example");
		return greeting;
	}

	@RequestMapping(value = "/greetings/collection", method = RequestMethod.POST)
	public Map<String, String> postGreetingMap(@RequestBody Map<String, String> greeting) {
		greeting.put("updated", "POST collection mapping example");
		return greeting;
	}

	@RequestMapping(value = "/greetings/entity", method = RequestMethod.POST)
	public ResponseEntity<Greetings> postGreetingEntity(@RequestBody Greetings greeting) {
		greeting.setMessage(greeting.getMessage() + " Updated");

		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("message", "POST entity mapping example");

		ResponseEntity<Greetings> res = new ResponseEntity<Greetings>(greeting, resHeaders, HttpStatus.CREATED);
		return res;
	}

	@RequestMapping(value = "/greetings/{messageId}", method = RequestMethod.PUT)
	public Map<String, String> putGreetingWithPathVariable(@RequestBody Map<String, String> greeting,
			@PathVariable String messageId, @MatrixVariable(required = false) String msgType) {
		greeting.put(messageId, "PUT collection mapping with path variable example");
		if (msgType != null) {
			greeting.put(msgType, "Testing");
		}
		return greeting;
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.PUT)
	public Greetings putGreetingWithMatrixParameters(@RequestBody Greetings greeting,
			@MatrixVariable("messageId") String messageId) {
		return greeting;
	}
}
