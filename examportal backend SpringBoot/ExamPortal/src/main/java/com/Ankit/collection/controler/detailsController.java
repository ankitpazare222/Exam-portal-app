package com.Ankit.collection.controler;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.Ankit.collection.model.UserDetails;
import com.Ankit.collection.model.UserInfo;
//import com.Ankit.collection.model.extraDeatils;
import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.detailsService;

@RestController
@RequestMapping(value = "/details")
@CrossOrigin(origins = "http://localhost:4200")
public class detailsController {
	
	@Autowired
	private detailsService detailsService;
	
	@PostMapping(value = "/")
	public ResponseEntity<?>adddetails(@RequestBody UserInfo details){
		UserInfo details1=	this.detailsService.addextraDeatils(details);
		return ResponseEntity.ok(details1);
	}
	
	
//	update
	@PutMapping(value = "/")
	public UserInfo Updatedetails(@RequestBody UserInfo details) {
		return detailsService.UpdateextraDeatils(details);
	}
	
//	get all deatils
	@GetMapping(value = "/")
	public Set<UserInfo> getallextraDeatils(){
		return detailsService.getallextraDeatils();
	}

	

}
