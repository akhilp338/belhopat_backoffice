package com.belhopat.backoffice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.belhopat.backoffice.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserApiController {
	
	@Autowired
	UserService userService;

    @RequestMapping(value = "/forgotPassword/", method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestParam String email) throws MessagingException {
    	boolean userStatus = userService.generatePasswordResetLink( email );
    	if(userStatus)
    		return new ResponseEntity<String>("New password has been sent to your registered email.",HttpStatus.OK);
    	else
    		return new ResponseEntity<String>("User account does not exist. Please contact administrator",HttpStatus.OK);
    } 

}