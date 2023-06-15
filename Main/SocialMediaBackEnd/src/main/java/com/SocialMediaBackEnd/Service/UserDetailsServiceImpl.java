package com.SocialMediaBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Repository.UserRepository;
import com.SocialMediaBackEnd.Security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userOpt = userRepo.findByUsername(username);
		if (userOpt == null) {
			throw new UsernameNotFoundException("Username and or password was incorrect.");
		}
//		User user = new User();
//		CustomSecurityUser user = new CustomSecurityUser();
//		user.setUsername(userOpt.get().getUsername());
//		user.setPassword(passwordEncoder.encode(userOpt.get().getPassword()));
//		user.setId(userOpt.get().getId());
		return new CustomSecurityUser(userOpt);
	}

}
