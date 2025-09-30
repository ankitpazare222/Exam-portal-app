package com.Ankit.collection.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Ankit.collection.dao.QuestionsRepo;
import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Question;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.QuestionService;

import io.jsonwebtoken.io.IOException;
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionsRepo questionrepooo;
	

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		 return questionrepooo.save(question);
	}
	
	 @Override
	    public void importQuestions(MultipartFile file) throws Exception {
	        List<Question> questions = new ArrayList<>();

	        // Example for CSV parsing (replace with Excel parser if needed)
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	            String line;
	            br.readLine(); // skip header
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                if (data.length >= 6) {
	                    Question question = new Question();
	                    question.setContent(data[0]);
	                    question.setOption1(data[1]);
	                    question.setOption2(data[2]);
	                    question.setOption3(data[3]);
	                    question.setOption4(data[4]);
	                    question.setAnswer(data[5]);
	                    questions.add(question);
	                }
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to parse file", e);
	        }

	        questionrepooo.saveAll(questions);
	    }
//	public void importQuestions(MultipartFile file) throws IOException {
//	    List<Question> questions = ExcelHelper.parseExcel(file.getInputStream());
//	    questionRepository.saveAll(questions);
//	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionrepooo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(questionrepooo.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		return questionrepooo.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return questionrepooo.findByQuiz(quiz);
	}

	
//	ye extra me bnaye
	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		Question question=new Question();
		question.setQuesId(questionId);
		questionrepooo.delete(question);
		
	}

}
