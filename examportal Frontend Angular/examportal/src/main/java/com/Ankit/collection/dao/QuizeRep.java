package com.Ankit.collection.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ankit.collection.model.exam.Category;
import com.Ankit.collection.model.exam.Quiz;
@Repository
public interface QuizeRep extends JpaRepository<Quiz, Long> {
	
	public List<Quiz> findBycategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c,Boolean b);

}
