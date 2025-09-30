package com.Ankit.collection.service;

import java.util.Set;

import com.Ankit.collection.model.exam.Category;

public interface CetegoryService {
	
	public Category addCategory(Category catogory);
	
	public Category UpdateCategory(Category category);
	
	public Set<Category> getAllCategory();
	
	public Category getCategoryById(Long categoryID);
	
	public void deleteCategory(Long categoryID );

}
