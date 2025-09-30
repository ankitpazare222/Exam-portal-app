package com.Ankit.collection.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Ankit.collection.model.exam.Quiz;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Users")
public class user implements UserDetails {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private  String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String Aadhar_no;
	private String phone;
	private boolean enabled=true;
	private String profile;
	
	private  String Higher_Education;
	private String Graduation_Year;
	private String Specialization;
	private String Percentage;
	private String University;
	
	
	private  String Job;
	private String Primary_Skill;
	private String Enter_Key_Skills;
	private String Training_Status;
	private String LinkedIn;
	
	
	  private String fileName;
	    private String fileType;

	    @Lob   // BLOB in DB
	    private byte[] resumeData;
	
	
	@OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="User" )
	
	@JsonIgnore
	private static Set<usersrole> userroles =new HashSet<usersrole>();
	

	
	
	
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	@JsonManagedReference
	private Set<UserInfo> UserInfo = new LinkedHashSet<>();
	
	
	public static Set<usersrole> getUserroles() {
		return userroles;
	}
	public void setUserroles(Set<usersrole> userroles) {
		this.userroles = userroles;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public  String getUsername() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public user() {
		
	}
	
	
	

	
	public String getHigher_Education() {
		return Higher_Education;
	}
	public void setHigher_Education(String higher_Education) {
		Higher_Education = higher_Education;
	}
	public String getGraduation_Year() {
		return Graduation_Year;
	}
	public void setGraduation_Year(String graduation_Year) {
		Graduation_Year = graduation_Year;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public String getUniversity() {
		return University;
	}
	public void setUniversity(String university) {
		University = university;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public String getPrimary_Skill() {
		return Primary_Skill;
	}
	public void setPrimary_Skill(String primary_Skill) {
		Primary_Skill = primary_Skill;
	}
	public String getEnter_Key_Skills() {
		return Enter_Key_Skills;
	}
	public void setEnter_Key_Skills(String enter_Key_Skills) {
		Enter_Key_Skills = enter_Key_Skills;
	}
	public String getTraining_Status() {
		return Training_Status;
	}
	public void setTraining_Status(String training_Status) {
		Training_Status = training_Status;
	}
	public String getLinkedIn() {
		return LinkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		LinkedIn = linkedIn;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getResumeData() {
		return resumeData;
	}
	public void setResumeData(byte[] resumeData) {
		this.resumeData = resumeData;
	}
	public Set<UserInfo> getUserInfo() {
		return UserInfo;
	}
	public void setUserInfo(Set<UserInfo> userInfo) {
		UserInfo = userInfo;
	}
	
	public user(String username, String password, String firstName, String lastName, String email, String gender,
			String aadhar_no, String phone, boolean enabled, String profile, String higher_Education,
			String graduation_Year, String specialization, String percentage, String university, String job,
			String primary_Skill, String enter_Key_Skills, String training_Status, String linkedIn, String fileName,
			String fileType, byte[] resumeData, Set<com.Ankit.collection.model.UserInfo> userInfo) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		Aadhar_no = aadhar_no;
		this.phone = phone;
		this.enabled = enabled;
		this.profile = profile;
		Higher_Education = higher_Education;
		Graduation_Year = graduation_Year;
		Specialization = specialization;
		Percentage = percentage;
		University = university;
		Job = job;
		Primary_Skill = primary_Skill;
		Enter_Key_Skills = enter_Key_Skills;
		Training_Status = training_Status;
		LinkedIn = linkedIn;
		this.fileName = fileName;
		this.fileType = fileType;
		this.resumeData = resumeData;
		UserInfo = userInfo;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set=new HashSet<>();
		this.userroles.forEach(usersrole ->{
			set.add(new Authority(usersrole.getRole().getRoleName()));
		});
		return set;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAadhar_no() {
		return Aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		Aadhar_no = aadhar_no;
	}
	
	
	
	
	

	
}
