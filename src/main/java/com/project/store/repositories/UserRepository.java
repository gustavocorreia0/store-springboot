package com.project.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
