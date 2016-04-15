package com.belhopat.backoffice.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belhopat.backoffice.service.LoginService;
import com.belhopat.backoffice.session.SessionManager;

@Controller
@RequestMapping("/*")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("error");
			model.addObject("error", "Wrong User name or Password");
		}
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/loginSuccess")
	public ModelAndView loginSuccess() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("asdasd");
		if (auth != null) {
			System.out.println("error");
			model.addObject("user", auth.getName());
		}
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest request) throws ServletException {
		request.getSession().invalidate();
		request.logout();
	}

}