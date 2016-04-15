package com.belhopat.backoffice.controller;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.service.LoginService;
import com.belhopat.backoffice.service.UserService;
import com.belhopat.backoffice.util.Constants;
import com.belhopat.backoffice.util.ResponseObject;

@Controller
@RequestMapping("/*")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;

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
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> forgotPassword( @RequestBody User user ) throws MessagingException {
    	boolean userStatus = userService.generatePasswordResetLink( user.getEmail() );
    	if(userStatus)
    		return new ResponseEntity<ResponseObject>(new ResponseObject(userStatus, Constants.PASS_RESET_SUCC_MSG),HttpStatus.OK);
    	else
    		return new ResponseEntity<ResponseObject>(new ResponseObject(userStatus, Constants.PASS_RESET_FAIL_MSG),HttpStatus.OK);
    }

}
