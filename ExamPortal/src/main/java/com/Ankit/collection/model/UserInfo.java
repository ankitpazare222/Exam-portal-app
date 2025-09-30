package com.Ankit.collection.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "User_info")
public class UserInfo {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long Student_ID;
	
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
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonBackReference
	    private user user;

		public UserInfo(Long student_ID, String higher_Education, String graduation_Year, String specialization,
				String percentage, String university, String job, String primary_Skill, String enter_Key_Skills,
				String training_Status, String linkedIn, String fileName, String fileType, byte[] resumeData,
				com.Ankit.collection.model.user user) {
			super();
			Student_ID = student_ID;
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
			this.user = user;
		}

		public UserInfo() {
			super();
		}

		public Long getStudent_ID() {
			return Student_ID;
		}

		public void setStudent_ID(Long student_ID) {
			Student_ID = student_ID;
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

		public user getUser() {
			return user;
		}

		public void setUser(user user) {
			this.user = user;
		}
	    
	    
}
