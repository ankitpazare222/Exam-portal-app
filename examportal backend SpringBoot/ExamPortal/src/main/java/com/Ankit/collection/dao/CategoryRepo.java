package com.Ankit.collection.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ankit.collection.model.exam.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
	
	

}
