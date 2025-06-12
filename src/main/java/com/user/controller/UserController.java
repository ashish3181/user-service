package com.user.controller;
import java.util.ArrayList;
import java.util.List;

//https://chatgpt.com/c/683d7d8e-0c24-8010-916a-3d454b06d8fc
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	 @Autowired
	    private UserServiceImpl userService;

//	    @GetMapping
//	    public List<User> getAllUsers() {
//	        return userRepository.findAll();
//	    }

	 @PostMapping("/add")
	    public boolean addUser(@RequestBody User user) {
		 System.out.println("USERRRRRRR-->"+user.toString());
	    	boolean b =userService.saveUser(user);
	    	if(b) {
	    		System.out.println("User Added Successfully");
	    	}
	    	else {
	    		System.out.println("User Not added");
	    	}
			return b;
	    	
	    }
	 @GetMapping("/allUsers")
	 public List<User> getData() {
		 List<User> allUserList= userService.getAllUser();
		 return allUserList;
	 }

}
