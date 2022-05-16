package com.mouritech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByStudId(Long studId);

	Student getByStudId(Long studId);
	

}
