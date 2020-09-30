package com.java.spring.repository;


import com.java.spring.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Student , String>   {



}
