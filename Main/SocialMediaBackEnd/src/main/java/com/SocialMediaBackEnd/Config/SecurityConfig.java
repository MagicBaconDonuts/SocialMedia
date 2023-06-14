package com.SocialMediaBackEnd.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService);
//			.inMemoryAuthentication()
//			.withUser("123")
//			.password("password")
//			.roles("USER", "ADMIN");
	}
	
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			super.configure(http);
//			http.csrf().disable()
//			.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
//			.anyRequest()
//			.hasAnyRole("USER")
//			.and()
//		.formLogin()
//		.loginPage("/login")
//		.defaultSuccessUrl("/dashboard")
//		.permitAll();
		}
}
