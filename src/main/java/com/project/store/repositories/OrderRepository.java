package com.project.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.store.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
