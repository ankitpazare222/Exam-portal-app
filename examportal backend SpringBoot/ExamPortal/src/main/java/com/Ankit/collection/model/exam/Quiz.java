package com.Ankit.collection.model.exam;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Quiz")
public class Quiz {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long qID;
	
	private String title;
	
	private String description;
	
	private String maxMarks;
	
	private String NumberofQue;
	
	private Boolean active=false;
	
	@OneToMany (mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question>questions =new HashSet<>()	;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Quiz() {
		super();
	}

	public Quiz(String title, String description, String maxMarks, String numberofQue, Boolean active) {
		super();
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		NumberofQue = numberofQue;
		this.active = active;
	}

	public Long getqID() {
		return qID;
	}

	public void setqID(Long qID) {
		this.qID = qID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumberofQue() {
		return NumberofQue;
	}

	public void setNumberofQue(String numberofQue) {
		NumberofQue = numberofQue;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	
	
	
}
