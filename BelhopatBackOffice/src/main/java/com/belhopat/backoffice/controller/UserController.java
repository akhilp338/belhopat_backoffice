package com.belhopat.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.belhopat.backoffice.service.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;


    

}