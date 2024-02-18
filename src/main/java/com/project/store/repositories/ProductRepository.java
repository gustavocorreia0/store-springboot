package com.project.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.store.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
