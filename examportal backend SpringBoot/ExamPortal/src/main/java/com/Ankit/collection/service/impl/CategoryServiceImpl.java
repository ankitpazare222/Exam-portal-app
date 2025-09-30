package com.Ankit.collection.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankit.collection.dao.CategoryRepo;
import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.service.CetegoryService;
@Service
public class CategoryServiceImpl implements CetegoryService {
	
	@Autowired
	private CategoryRepo categoryrepooo;

	@Override
	public Category addCategory(Category catogory) {
		// TODO Auto-generated method stub
		return categoryrepooo.save(catogory);
	}

	@Override
	public Category UpdateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryrepooo.save(category);
	}

	@Override
	public Set<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(categoryrepooo.findAll());
	}

	@Override
	public Category getCategoryById(Long categoryID) {
		// TODO Auto-generated method stub
		return categoryrepooo.findById(categoryID).get();
	}

	@Override
	public void deleteCategory(Long categoryID) {
		
		Category category=new Category();
		category.setCid(categoryID);
		categoryrepooo.delete(category);
		// TODO Auto-generated method stub
		
	}

}
