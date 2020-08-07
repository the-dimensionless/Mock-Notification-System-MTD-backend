package com.nagarro.nsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nsys.models.User;
import com.nagarro.nsys.services.UserService;

/**
 * <p>User Controller for the REST API</p>
 * <p>Contains all endpoints for user related actions</p>
 * @author sumitsingh
 *
 */
@RestController
@RequestMapping ("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * GET Request to retrieve all users details
	 * @return List<User>
	 */
	@GetMapping
	public List<User> getUserDetails () {
		return this.userService.getAllUserDetails();
	}

}
