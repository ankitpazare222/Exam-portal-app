package com.Ankit.collection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Ankit.collection.dao.userRepo;
import com.Ankit.collection.model.user;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private userRepo userrepooo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user users= this.userrepooo.findByUsername(username);
		
		if (users == null) {
			System.out.println("no users found lala");
		    throw new UsernameNotFoundException("User not found with username: " + username);
		}
  		return users;
	}

}
