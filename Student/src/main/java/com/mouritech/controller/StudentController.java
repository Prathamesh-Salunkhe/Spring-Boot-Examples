package com.mouritech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.entity.Student;
import com.mouritech.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PostMapping("/bulkAdd")
	public String addStudents(@RequestBody List<Student> stdent) {
		return studentService.addStudents(stdent);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping("getStudentById/{id}")
	public String getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
}
