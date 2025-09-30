package com.Ankit.collection.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.collection.dao.QuizeRep;
import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	private QuizeRep quizerepooo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		// TODO Auto-generated method stub
		return quizerepooo.save(quiz);
	}

	@Override
	public Quiz updatequiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizerepooo.save(quiz);
	}

	@Override
	public Set<Quiz> getallquizess() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(quizerepooo.findAll());
	}

	@Override
	public Quiz getquizbyID(Long quizID) {
		// TODO Auto-generated method stub
		return quizerepooo.findById(quizID).get();
	}

	@Override
	public void deleteQuiz(Long quizID) {
		this.quizerepooo.deleteById(quizID); 
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Quiz> getQuizessOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizerepooo.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizess() {
		// TODO Auto-generated method stub
		return this.quizerepooo.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizessOfCategory(Category c) {
		// TODO Auto-generated method stub
		return this.quizerepooo.findByCategoryAndActive(c, true);
	}
	
//	get active quizes
	
	
	

}
