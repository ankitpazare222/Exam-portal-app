package com.Ankit.collection.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="tbl_person")
public class person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "prtson_ID")
	private Integer personID;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname ;
	
	@Column(name = "age")
	private Integer age ;
	
	@Column(name = "created_date")
	private Date createddate ;
	
	@Column(name = "email")
	private String email ;

	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public person(String firstname, String lastname,   String email,Integer age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.createddate = new Date();
		this.email = email;
	}
	
	public person() {}

	@Override
	public String toString() {
		return "person [personID=" + personID + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", createddate=" + createddate + ", email=" + email + "]";
	}
	
	
	

}
