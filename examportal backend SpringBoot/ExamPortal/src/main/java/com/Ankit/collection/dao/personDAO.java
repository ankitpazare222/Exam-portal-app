package com.Ankit.collection.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ankit.collection.model.person;

@Repository
public interface personDAO extends CrudRepository<person, Integer> {
	
	

}
