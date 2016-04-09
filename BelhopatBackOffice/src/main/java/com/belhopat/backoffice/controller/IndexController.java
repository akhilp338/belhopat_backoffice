package com.belhopat.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.belhopat.backoffice.repository.UserRepository;

@Controller
@RequestMapping("/*")
public class IndexController {

	
	
	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
		  
	        return "index";
	    }

}	