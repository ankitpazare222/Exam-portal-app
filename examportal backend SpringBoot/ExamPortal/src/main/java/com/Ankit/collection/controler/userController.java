package com.Ankit.collection.controler;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.collection.model.role;
import com.Ankit.collection.model.user;
import com.Ankit.collection.model.usersrole;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.userservice;
import com.Ankit.collection.service.impl.UserServiceImpl;

@RestController
@RequestMapping (value = "/user")
@CrossOrigin(origins = "http://localhost:4200")
public class userController {
	@Autowired
	private userservice userservicee;
	
	@Autowired
	private UserServiceImpl userserviceimpl;
	
	
	@PostMapping (value = "/")
	public user createuser( @RequestBody user users) throws Exception {
		users.setProfile("default.png");
		Set<usersrole> roles=new HashSet<>();
		role roless=new role();
		roless.setRoleID(45L);
		roless.setRoleName("normal");
		
		usersrole userrole1=new usersrole();
		userrole1.setUser(users);
		userrole1.setRole(roless);
		roles.add(userrole1);
		return userservicee.createusr(users, roles);
		
	}
	
	@PutMapping(value = "/")
	public user updatequiz(@RequestBody user user) {
		return userservicee.updateUserByID(user);
		
	}
	
	
	@GetMapping(value = "/{username}")
	public user getuser( @PathVariable ("username") String username) {
		return this.userservicee.getuser(username);
	}
	@DeleteMapping(value = "/{userID}")
	public void deleteuser(@PathVariable ("userID") Long userID) {
		this.userservicee.deleteuser(userID);
	}
	
	@GetMapping (value = "/all")
	public Iterable<user> getalluser(){
		return this.userservicee.getallUser();
	}
	
	@GetMapping(value = "/id/{userID}")
	public user getextraDeatilsID(@PathVariable ("userID") Long userID) {
		return userservicee.getextraDeatilsID(userID);
		
	}
	
	// ✅ Upload Resume
    @PutMapping("/uploadResume/{id}")
    public ResponseEntity<String> uploadResume(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
        	userserviceimpl.uploadResume(id, file);
            return ResponseEntity.ok("Resume uploaded successfully for student ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // ✅ Download Resume
    @GetMapping("/downloadResume/{id}")
    public ResponseEntity<Resource> downloadResume(@PathVariable Long id) {
        try {
            byte[] data = userserviceimpl.downloadResume(id);
            String fileName = userserviceimpl.getFileName(id);
            String fileType = userserviceimpl.getFileType(id);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(fileType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(new ByteArrayResource(data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
	

}
