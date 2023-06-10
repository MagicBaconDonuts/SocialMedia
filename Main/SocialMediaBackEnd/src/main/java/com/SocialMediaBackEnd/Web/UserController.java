package com.SocialMediaBackEnd.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Repository.UserRepository;
import com.SocialMediaBackEnd.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	User newUser(@RequestBody User newUser) {
		return userService.save(newUser);
	}
}
