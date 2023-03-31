package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entites.User;

public interface UserService {
    //User Operations
	//Crate
	User saveUser(User user);
	//Get All User
	List<User> getAllUser();
	//get single user of given userId
	User getUserById(String userId);
}
