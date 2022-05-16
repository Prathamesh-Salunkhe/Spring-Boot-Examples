package com.mouritech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.entity.Student;
import com.mouritech.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public String addStudent(Student student) {
		repo.save(student);
		return "Student information is added";
	}
	
	public String addStudents(List<Student> student) {
		repo.saveAll(student);
		return "All students are saved";
		
	}
	
	public String deleteStudent(int id) {
		Student student=repo.getById(id);
		repo.delete(student);
		return "Student is deleted";
	}
	
	public String updateStudent(Student student) {
		repo.save(student);
		return "Student info is updated";
	}
	
	public String getStudent(int id) {
		repo.getById(id);
		return "get by id";
	
	}

}
