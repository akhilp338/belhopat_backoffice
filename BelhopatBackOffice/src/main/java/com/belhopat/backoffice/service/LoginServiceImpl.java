package com.belhopat.backoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.repository.UserRepository;

@Component
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public ResponseEntity<User> authenticateUser(User user) {
		User userEntity= userRepo.findByUserNameAndPwd(user.getUsername(),user.getPassword());
		  if(userEntity==null){
			  System.out.println("asd");
	            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
	        }
	       return new ResponseEntity<User>(userEntity, HttpStatus.OK);
	}

}
