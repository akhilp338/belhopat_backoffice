package com.belhopat.backoffice.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.service.LoginService;
import com.belhopat.backoffice.session.SessionManager;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> authentication(@RequestBody User user,HttpServletRequest request) throws ServletException {
	    	System.out.println(user.getPassword()+user.getUsername());
	    	User sessionUser=loginService.getUserByUserNameAndPwd(user);
//	    	request.login(user.getUsername(), user.getPassword());
	    	request.getSession().setAttribute("sessionUser", sessionUser);
	    	SessionManager.setCurrentUser(sessionUser);
	    	return loginService.authenticateUser(sessionUser);
	    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest request) throws ServletException {
		System.out.println(SessionManager.getCurrentUser());
	    	request.getSession().invalidate();
	    	request.logout();
	    }
	 
}
