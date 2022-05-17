package com.mouritech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mouritech.entity.Student;

@Service
public interface StudentService {
	
	//add Student
	Student saveStudent(Student student);
	
	//get all students
	List<Student> getAllStudent();
	
	//get by id
	Student getStudentById(Long id);

	
	//update
	Student updateStudent(Student student, Long id);
	
	//delete
	String deleteStudentById(Long id);

	

}
