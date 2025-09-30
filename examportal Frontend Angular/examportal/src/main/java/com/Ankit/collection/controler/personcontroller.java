package com.Ankit.collection.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.collection.model.person;
import com.Ankit.collection.service.personservice;
@RestController
@RequestMapping (value = "/person")
public class personcontroller {

	
	@Autowired 
	private personservice personservvvic;
	
	@GetMapping(value = "/all")
	public Iterable<person> getall(){
		return personservvvic.getallperson();
	}
	@PostMapping(value = "/savall")
	public Iterable<person> saveAllperson(@RequestBody Iterable<person> personlist){
		return personservvvic.saveAllperson(personlist);
	}
	
	
	
}
