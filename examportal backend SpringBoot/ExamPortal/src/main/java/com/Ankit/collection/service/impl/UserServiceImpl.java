package com.Ankit.collection.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Ankit.collection.dao.rolerepo;
import com.Ankit.collection.dao.userRepo;
import com.Ankit.collection.model.user;
import com.Ankit.collection.model.usersrole;
import com.Ankit.collection.service.userservice;
@Service
public class UserServiceImpl implements userservice{

	@Autowired
	private userRepo userRepoo;
	@Autowired
	private rolerepo roleRepoo;
	@Override
	public user createusr(user users, Set<usersrole> userroles) throws Exception {
		
		user local = this.userRepoo.findByUsername(users.getUsername());
		if (local != null) {
		    System.out.println("User is already there !!");
		    throw new Exception("User already present !!");
		} else {
		    // user create
		    for (usersrole ur : userroles) {
		    	roleRepoo.save(ur.getRole());
		    }

		    users.getUserroles().addAll(userroles);
		    local = this.userRepoo.save(users);
		}
		// TODO Auto-generated method stub
		return local;
	}
	@Override
	public user getuser(String username) {
		
		// TODO Auto-generated method stub
		return this.userRepoo.findByUsername(username);
	}
	@Override
	public void deleteuser(Long userID) {
		 this.userRepoo.deleteById(userID);
		// TODO Auto-generated method stub
		
	}
	@Override
	public Iterable<user> getallUser() {
		
		// TODO Auto-generated method stub
		return this.userRepoo.findAll();
	}
	@Override
	public user getextraDeatilsID(Long userID) {
		// TODO Auto-generated method stub
		return userRepoo.findById(userID).get();
	}
	@Override
	public user updateUserByID(user userID) {
		// TODO Auto-generated method stub
		return userRepoo.save(userID);
	}
	
	
	 public user uploadResume(Long userID, MultipartFile file) throws IOException {
	        Optional<user> optionalStudent = userRepoo.findById(userID);

	        if (optionalStudent.isPresent()) {
	        	user student = optionalStudent.get();
	            student.setFileName(file.getOriginalFilename());
	            student.setFileType(file.getContentType());
	            student.setResumeData(file.getBytes());
	            return userRepoo.save(student);
	        } else {
	            throw new RuntimeException("Student not found with ID: " + userID);
	        }
	    }
	 
	 

	    // Download Resume
	    public byte[] downloadResume(Long userID) {
	    	user student = userRepoo.findById(userID)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + userID));

	        return student.getResumeData();
	    }

	    // Get File Name + Type
	    public String getFileName(Long userID) {
	    	user student = userRepoo.findById(userID)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + userID));

	        return student.getFileName();
	    }

	    public String getFileType(Long userID) {
	    	user student = userRepoo.findById(userID)
	                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + userID));

	        return student.getFileType();
	    }
	
	
	
	

}
