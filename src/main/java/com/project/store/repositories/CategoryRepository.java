package com.project.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.store.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
