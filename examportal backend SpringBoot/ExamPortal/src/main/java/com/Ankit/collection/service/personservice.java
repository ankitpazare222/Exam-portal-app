package com.Ankit.collection.service;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.collection.dao.personDAO;
import com.Ankit.collection.model.person;
//import com.Ankit.ticketbooking.model.ticket;

@Service
public class personservice {

	@Autowired
	private personDAO persondao;
	
//	save all method
	
	public Iterable<person> getallperson(){
		return persondao.findAll();
	}
	
	public Iterable<person> saveAllperson(Iterable<person> personlist){
		return persondao.saveAll(personlist);
	}
	
//	find all by id
	public Iterable<person>findperson(java.util.List<Integer> personID){
		return persondao.findAllById(personID);
		
	}
}
