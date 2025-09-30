package com.Ankit.collection.controler;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.QuizService;

@RestController
@RequestMapping(value = "/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {
	
	@Autowired
	private QuizService quizeservicee;
//	 addquiz
	@PostMapping(value = "/")
//	public ResponseEntity<?> add(@RequestBody Quiz quiz){
//		return ResponseEntity.ok(quizeservicee.addQuiz(quiz));
//	}
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizeservicee.addQuiz(quiz);
	}
	

//	update quiz
	@PutMapping(value = "/")
	public Quiz updatequiz(@RequestBody Quiz quiz) {
		return quizeservicee.updatequiz(quiz);
		
	}
//	get all quizes
	@GetMapping(value = "/")
	public Set<Quiz> getallquizess(){
		return quizeservicee.getallquizess();
	}
//	
//	get quize by ID
	@GetMapping(value = "/{quizId}")
	public Quiz getquizbyID(@PathVariable ("quizId") Long quizID) {
		return quizeservicee.getquizbyID(quizID);
	}
//	
	@DeleteMapping(value = "/{quizId}")
	public void deleteQuiz(@PathVariable ("quizId") Long quizID) {
		 quizeservicee.deleteQuiz(quizID);
	}
	
	@GetMapping(value = "/category/{cid}")
	public List<Quiz> getQuizesOfCategory(@PathVariable ("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		return this.quizeservicee.getQuizessOfCategory(category);
		
	}
	
//	get actice quizess
	@GetMapping(value = "/active")
	public List<Quiz> getActiceQuizes(){
		return quizeservicee.getActiveQuizess();
	}
	
	@GetMapping(value = "/category/active/{cid}")
	public List<Quiz> getActiceQuizesandcategory(@PathVariable ("cid") Long cid ){
		Category category =new Category();
		category.setCid(cid);
		return quizeservicee.getActiveQuizessOfCategory(category);
	}
	
	
	

}
