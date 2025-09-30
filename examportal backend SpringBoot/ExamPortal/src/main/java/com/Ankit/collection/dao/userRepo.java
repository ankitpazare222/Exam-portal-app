package com.Ankit.collection.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.collection.model.user;

public interface userRepo extends JpaRepository<user, Long> {
	public user findByUsername(String  username);

}
