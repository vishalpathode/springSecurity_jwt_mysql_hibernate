package com.pro.jwt.JwtSpringsecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.jwt.JwtSpringsecurity.model.User;
import com.pro.jwt.JwtSpringsecurity.service.UserService;


@RestController
public class UserController {

	@Autowired 
	private UserService userService;
	
	@GetMapping(value = "/users")
	/* 
	 * either we can use @PreAuthorize here(with API call method) or antMatchers().access() in configure() of 
	 * SecurityConfiguration file to give access to particular role
	*/
	//@PreAuthorize("hasRole('ADMIN')") 
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<User> getUser(Principal principal){
		User user = userService.getUserByEmail(principal.getName());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}	