package com.project.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.Category;
import com.project.store.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long Id) {
		Optional<Category> category = categoryRepository.findById(Id);
		return category.get();
	}
	
}
