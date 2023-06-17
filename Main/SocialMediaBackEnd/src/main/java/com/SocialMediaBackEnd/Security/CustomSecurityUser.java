package com.SocialMediaBackEnd.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SocialMediaBackEnd.Domain.Authority;
import com.SocialMediaBackEnd.Domain.User;

//@Component
public class CustomSecurityUser extends User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3948787477194083135L;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public CustomSecurityUser() {}
	
	public CustomSecurityUser(User user) {
		this.setAuthority(user.getAuthority());
		this.setChannel(user.getChannel());
		this.setId(user.getId());
		this.setLastName(user.getLastName());
		this.setMessage(user.getMessage());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new Authority("ROLE_USER"));
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
