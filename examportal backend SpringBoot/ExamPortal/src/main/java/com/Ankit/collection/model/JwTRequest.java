package com.Ankit.collection.model;

public class JwTRequest {

	String username;
	String password;
	public JwTRequest() {
		super();
	}
	public JwTRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
