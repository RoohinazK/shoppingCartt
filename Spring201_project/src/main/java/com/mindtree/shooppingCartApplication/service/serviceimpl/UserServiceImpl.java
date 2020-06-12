package com.mindtree.shooppingCartApplication.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shooppingCartApplication.dto.UserDto;
import com.mindtree.shooppingCartApplication.entity.User;
import com.mindtree.shooppingCartApplication.repository.UserRepository;
import com.mindtree.shooppingCartApplication.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	ModelMapper model = new ModelMapper();
	
	@Override
	public UserDto addUser(UserDto user) {
		User users = model.map(user, User.class);
		User user1 = userRepository.save(users);
		UserDto userDto = model.map(user1, UserDto.class);
		return userDto;
	}
	
}
