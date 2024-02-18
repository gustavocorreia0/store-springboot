package com.project.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.store.entities.Product;
import com.project.store.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long Id) {
		Optional<Product> product = productRepository.findById(Id);
		return product.get();
	}
	
}
