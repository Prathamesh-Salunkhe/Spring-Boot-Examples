package com.mouritech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.entity.Student;
import com.mouritech.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studService;
	
	@PostMapping("/createStudent")
	public Student addStudent(@RequestBody Student student) {
		return studService.addStudent(student);
	}
	
	@GetMapping("/readAll")
	public List<Student> fetchStudent(){
		return studService.fetchStudent();
	}
	
	@GetMapping("/getById/{Id}")
	public Student getStudentById(@PathVariable("Id") Long studId) {
		return studService.getStudentById(studId);
		
	}
	
	@PutMapping("/update/{Id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("Id") Long studId ) {
		return studService.updateStudent(student, studId);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String deleteStudent(@PathVariable("Id") Long studId) {
		studService.deleteStudent(studId);
		return "Student has deleted successfully";
	}
}
