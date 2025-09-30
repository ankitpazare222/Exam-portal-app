package com.Ankit.collection.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;

public interface QuizService {

	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updatequiz(Quiz quiz);
	
	public Set<Quiz> getallquizess();
	
	public Quiz getquizbyID(Long quizID);
	
	public void deleteQuiz(Long quizID);
	
	public List<Quiz> getQuizessOfCategory(Category category);
	
	public List<Quiz> getActiveQuizess();
	
	public List<Quiz> getActiveQuizessOfCategory( Category c);
	
	
	
	
	
}
