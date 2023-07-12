package com.SocialMediaBackEnd.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SocialMediaBackEnd.Domain.Authority;
import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Repository.AuthorityRepository;
import com.SocialMediaBackEnd.Repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthorityRepository authorityRepo;

	public User save(User newUser) {
		
		User user = userRepo.save(newUser);
		Authority authority = new Authority();
		authority.setUser(user);
		authority.setAuthority("ROLE_USER");
		userRepo.save(user);
		authorityRepo.save(authority);
		return user;
	}
	
}
