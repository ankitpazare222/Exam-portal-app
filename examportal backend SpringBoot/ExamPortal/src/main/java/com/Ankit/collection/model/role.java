package com.Ankit.collection.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "roles")
public class role {
	@Id
	
	private Long roleID;
	private String roleName;
	public Long getRoleID() {
		return roleID;
	}
	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public role(Long roleID, String roleName) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
	}
	public role() {}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<usersrole> userRoless= new HashSet<usersrole>();
	public Set<usersrole> getUserRoless() {
		return userRoless;
	}
	public void setUserRoless(Set<usersrole> userRoless) {
		this.userRoless = userRoless;
	}
	

}
