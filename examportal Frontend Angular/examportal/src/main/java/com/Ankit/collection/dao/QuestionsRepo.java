package com.Ankit.collection.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.collection.model.exam.Question;
import com.Ankit.collection.model.exam.Quiz;

public interface QuestionsRepo  extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);
	

}
