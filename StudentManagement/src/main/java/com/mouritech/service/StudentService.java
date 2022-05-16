package com.mouritech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mouritech.entity.Student;

@Service
public interface StudentService {
	
	//add
	 Student addStudent(Student student);
	 
	 //read
	 List<Student> fetchStudent();
	 
	 //get by id
	 Student getStudentById(Long studId);
	 
	 
	 //update
	 Student updateStudent(Student student,Long studId);
	 
	 //delete
	 String deleteStudent(Long studId);



	 
	 
	

}
