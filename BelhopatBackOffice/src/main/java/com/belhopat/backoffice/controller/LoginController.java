package com.belhopat.backoffice.controller;

import javax.mail.MessagingException;
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
import com.belhopat.backoffice.service.UserService;
import com.belhopat.backoffice.session.SessionManager;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> authentication(@RequestBody User user,HttpServletRequest request) throws ServletException {
	    	User sessionUser=loginService.getUserByUserNameAndPwd(user);
//	    	request.login(user.getUsername(), user.getPassword());
	    	request.getSession().setAttribute("sessionUser", sessionUser);
	    	SessionManager.setCurrentUser(sessionUser);
	    	return loginService.authenticateUser(sessionUser);
	    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(HttpServletRequest request) throws ServletException {
	    	request.getSession().invalidate();
	    	request.logout();
	    }
	
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<String> forgotPassword( @RequestBody User user ) throws MessagingException {
    	boolean userStatus = userService.generatePasswordResetLink( user.getEmail() );
    	if(userStatus)
    		return new ResponseEntity<String>("New password has been sent to your registered email.",HttpStatus.OK);
    	else
    		return new ResponseEntity<String>("User account does not exist. Please contact administrator.",HttpStatus.OK);
    }
	 
}
