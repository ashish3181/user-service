package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepositoryImpl;
@Service
public class UserServiceImpl {
	 @Autowired
	    private UserRepositoryImpl userRepository;
	 
	 public boolean saveUser(User user) {
		 return userRepository.saveUser(user);
	 }
	 
	 public List getAllUser() {
		 return userRepository.getAllUsers();
	 }
	 
}
