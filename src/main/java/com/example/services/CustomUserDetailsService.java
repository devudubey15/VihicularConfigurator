package com.example.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	private String password;
	public void setPassword(String password)
	{
		this.password=password;
		System.out.println("password is set"+password);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loaduserbyname method");
		return new User(username,password,new ArrayList<>());
	}

}
