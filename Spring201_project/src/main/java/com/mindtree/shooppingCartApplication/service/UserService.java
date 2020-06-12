package com.mindtree.shooppingCartApplication.service;

import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.UserDto;



@Service
public interface UserService {

	/**
	 * @param user
	 * @return 
	 */
	public UserDto addUser(UserDto user);

}
