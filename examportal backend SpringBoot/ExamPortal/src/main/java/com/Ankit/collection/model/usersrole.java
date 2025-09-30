package com.Ankit.collection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class usersrole {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long usersroleid;
	
	
	@ManyToOne (fetch =  FetchType.EAGER)
	private user User;
	
	@ManyToOne
	private role role;

	public usersrole() {
		super();
	}

	public Long getUsersroleid() {
		return usersroleid;
	}

	public void setUsersroleid(Long usersroleid) {
		this.usersroleid = usersroleid;
	}

	public user getUser() {
		return User;
	}

	public void setUser(user user) {
		User = user;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}
	

}
