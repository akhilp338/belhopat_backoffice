package com.belhopat.backoffice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/user")
public class UserApiController {

    @RequestMapping(value = "/forgotPassword/", method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
//    	userService.generatePasswordResetLink()
        return new ResponseEntity<String>("A recovery link has been sent to your email. Please check your email",HttpStatus.OK);
    } 

}