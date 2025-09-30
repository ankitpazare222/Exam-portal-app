package com.Ankit.collection.controler;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.collection.config.Jwtutil;
import com.Ankit.collection.model.JwTRequest;
import com.Ankit.collection.model.JwtResponse;
import com.Ankit.collection.model.user;
import com.Ankit.collection.service.impl.UserDetailServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationmagersss;
	
	@Autowired
	private UserDetailServiceImpl userdetailsservicesssImpl;
	
	@Autowired
	private Jwtutil Jwtutiless;
	
	@PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwTRequest jwtRequest) throws Exception {
        try {
            // Assuming 'authenticate' is a method that handles authentication
            // and throws UserNotFoundException if the user is not found.
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
            // If authentication is successful, proceed with token generation logic here.
            // For example:
            // String token = jwtUtil.generateToken(jwtRequest.getUsername());
            // return ResponseEntity.ok(new JwtResponse(token));
//            return ResponseEntity.ok("Token generated successfully (replace with actual token response)");

        } catch (BadCredentialsException  e) {
            e.printStackTrace();
            throw new Exception("User not found ");
        }
        UserDetails userDetails = this.userdetailsservicesssImpl.loadUserByUsername(jwtRequest.getUsername()); 

        String token = this.Jwtutiless.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
	
	
	private void authenticate(String username, String password) throws Exception {
	    try {
	    	authenticationmagersss.authenticate(
	            new UsernamePasswordAuthenticationToken(username, password)
	        );
	    } catch (DisabledException e) {
	        throw new Exception("USER DISABLED: " + e.getMessage());
	    } catch (BadCredentialsException e) {
	        throw new Exception("INVALID CREDENTIALS: " + e.getMessage());
	    }
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/current-user")
	public user getCurrentUser(Principal principal) {
		return ((user)this.userdetailsservicesssImpl.loadUserByUsername(principal.getName()));
	}

}
