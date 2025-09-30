package com.Ankit.collection.service;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.Ankit.collection.model.exam.Question;
import com.Ankit.collection.model.exam.Quiz;

public interface QuestionService {
	
	 public Question addQuestion(Question question);

	    public Question updateQuestion(Question question);

	    public Set<Question> getQuestions();

	    public Question getQuestion(Long questionId);

	    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

	    public void deleteQuestion(Long questionId);
	    public void importQuestions(MultipartFile file) throws Exception;

}
