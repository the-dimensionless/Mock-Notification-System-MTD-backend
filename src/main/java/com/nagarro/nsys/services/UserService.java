package com.nagarro.nsys.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nsys.models.User;
import com.nagarro.nsys.repositories.UserRepository;

/**
 * Service layer for user related activities
 * @author sumitsingh
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<User> fetchUserDetails () {
		try {
			List<User> values = this.userRepository.findAll();
			logger.info("Successfully fetched user details");
			return values;
		} catch (Exception e) {
			logger.error("Some problem occurred while fetching user details");
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Retrieves all User Details
	 * @return : List<User>
	 */
	public List<User> getAllUserDetails () {
		return this.fetchUserDetails();
	}
}
