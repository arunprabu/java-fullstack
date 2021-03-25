package com.examples.spring.web.mvc;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginForm(ModelMap modelMap) {

		ModelAndView modelView = new ModelAndView("login", "command", new User());
		modelView.addAllObjects(modelMap);
		return modelView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");

		logger.info("Registered username: {}", user.getUsername());
		logger.info("Registered password: {}", user.getPassword());

		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			ModelAndView mav = new ModelAndView("loginSuccess");			
			mav.addAllObjects(model.asMap());
			return mav;
		} else {

			throw new RuntimeException("Login failed");
			// ModelAndView mav = new ModelAndView("redirect:login");
			// mav.addObject("error", "Invalid Username or Password.");
			// return mav;
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus)
	{
		// removes all session attributes and invalidates the session
		sessionStatus.setComplete();
		
//		session.removeAttribute("user");
//		session.invalidate();
		
		return "redirect:home";
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleLoginException(RuntimeException re) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("exception", re);
		return mav;
	}
}
