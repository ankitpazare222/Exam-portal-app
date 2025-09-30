package com.Ankit.collection.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Ankit.collection.model.exam.Question;
import com.Ankit.collection.model.exam.Quiz;
import com.Ankit.collection.service.QuestionService;
import com.Ankit.collection.service.QuizService;

@RestController
@RequestMapping(value = "/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
	
	@Autowired
	private QuestionService questionservicess;
	
	@Autowired
	private QuizService quizeservicesss;
	
//	add question
	@PostMapping (value = "/")
	public Question addQuestion(@RequestBody Question question) {
		return questionservicess.addQuestion(question);
		
		
	}
 
//	update question
	@PutMapping(value = "/")
    public Question updateQuestion(@RequestBody Question question) {
		return questionservicess.updateQuestion(question);
    }
	 @PostMapping("/bulk-upload")
	    public ResponseEntity<?> uploadQuestions(@RequestParam("file") MultipartFile file) {
	        try {
	        	questionservicess.importQuestions(file);
	            return ResponseEntity.ok("Bulk questions uploaded successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
	        }
	    }

//	get all question
	@GetMapping(value = "/")
    public Set<Question> getQuestions(){
    	return questionservicess.getQuestions();
    }
	
//	find ques by ID
	@GetMapping(value = "/{QuesID}")
    public Question getQuestion(@PathVariable ("QuesID") Long questionId) {
		return questionservicess.getQuestion(questionId);
	}

//    public Set<Question> getQuestionsOfQuiz(Quiz quiz){
//    	
//    }
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {

	    // Quiz fetch karo service layer se
	    Quiz quiz = this.quizeservicesss.getquizbyID(qid);
	    
	    // Quiz ke questions le lo (Set<Question>)
	    Set<Question> questions = quiz.getQuestions();

	    // Set ko List me convert karo for shuffling and sublisting
	    List list = new ArrayList<>(questions);

	    // Agar list ka size numberOfQuestions se bada hai to slice karo
	    if (list.size() > Integer.parseInt(quiz.getNumberofQue())) {
	        list = list.subList(0, Integer.parseInt(quiz.getNumberofQue()+1));
	    }

	    // Shuffle the list to randomize question order
	    Collections.shuffle(list);

	    // Return the final list
	    return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAmin(@PathVariable("qid") Long qid) {

		Quiz quiz=new Quiz();
		quiz.setqID(qid);
		
		Set<Question> questionquize=this.questionservicess.getQuestionsOfQuiz(quiz);
	   
	    // Return the final list
	    return ResponseEntity.ok(questionquize);
	}


	
//	dellete by ID
    @DeleteMapping(value = "/{QuesID}")
    public void deleteQuestion( @PathVariable ("QuesID") Long questionId) {
    	 questionservicess.deleteQuestion(questionId);
    }

}
