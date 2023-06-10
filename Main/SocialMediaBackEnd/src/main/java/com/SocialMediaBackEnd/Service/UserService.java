package com.SocialMediaBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User save(User newUser) {
		return userRepo.save(newUser);
	}
	
}
