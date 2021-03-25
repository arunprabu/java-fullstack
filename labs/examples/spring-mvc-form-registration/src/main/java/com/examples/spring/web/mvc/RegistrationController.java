package com.examples.spring.web.mvc;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { "/register" })
@SessionAttributes({ "user" })
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showRegisterForm() {

		ModelAndView modelView = new ModelAndView("register", "user", new User());
		return modelView;
	}

	@ModelAttribute("countries")
	public List<String> listCountries() {
		return Arrays.asList("India", "UK", "USA");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user, HttpSession session) {

		ModelAndView modelView = new ModelAndView("regSuccess");

		// adds user object into session scope when use @SessionAttributes annotation at
		// class level with same attribute name, so than can this object from model in
		// view
		modelView.addObject("user", user);

		// adds user object into session object directly
		// session.setAttribute("user", user);

		return modelView;
	}
}
