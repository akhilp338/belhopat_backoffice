package com.belhopat.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> authentication(@RequestBody User user) {
	    	System.out.println("aksfsadfsad");
	    	System.out.println(user.getPassword()+user.getUsername());
	    	return loginService.authenticateUser(user);
	    }
	 
}
