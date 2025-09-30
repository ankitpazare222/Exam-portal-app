package com.Ankit.collection.controler;

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
import com.Ankit.collection.service.CetegoryService;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	@Autowired
	private CetegoryService categoryservicess;
//	 add category
	@PostMapping(value = "/")
	public ResponseEntity<?>addCategory(@RequestBody Category catogory){
		Category category1=	this.categoryservicess.addCategory(catogory);
		return ResponseEntity.ok(category1);
	}

//	get category
	@GetMapping(value = "/{categoryID}")
	public Category getCategoryById(@PathVariable("categoryID") Long categoryID) {
		
		return categoryservicess.getCategoryById(categoryID);
		
	}
	
//	get all category
	@GetMapping(value = "/")
	public Set<Category> getAllCategory(){
		return categoryservicess.getAllCategory();
	}
	
//	update
	@PutMapping(value = "/")
	public Category UpdateCategory(@RequestBody Category category) {
		return categoryservicess.UpdateCategory(category);
	}
	
//	delete catogry
	@DeleteMapping(value = "/{categoryId}")
	public void deleteCategory(@PathVariable  ("categoryId") Long categoryID) {
		categoryservicess.deleteCategory(categoryID);
	}
	
	
}
