package com.examples.spring.web.mvc;

import java.time.LocalDateTime;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	// Creating the Logger
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)  // Handler Mapping
	public String home(Locale locale, Model model) {
//		logger.trace("TRACE testing");
//		logger.debug("DEBUG testing");
//		logger.info("INFO testing");
//		logger.warn("WARN testing");
//		logger.error("ERROR testing");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("serverTime", LocalDateTime.now());
		
		// logical view name
		return "home";
	}
	
}
