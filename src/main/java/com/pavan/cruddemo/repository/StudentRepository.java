package com.pavan.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.cruddemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
