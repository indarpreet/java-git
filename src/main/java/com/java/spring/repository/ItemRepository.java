package com.java.spring.repository;

import com.java.spring.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item , Integer> {
    
}
