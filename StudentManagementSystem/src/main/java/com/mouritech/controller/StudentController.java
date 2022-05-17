package com.mouritech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student s=null;
		try {
			s=this.studentService.saveStudent(student);
			System.out.println(student);
			return (ResponseEntity<Student>) ResponseEntity.of(Optional.of(s));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/getAll")
	 public ResponseEntity<List<Student>> getAllStudent(){
     List<Student> list=studentService.getAllStudent();
     if(list.size()<=0) {
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
     return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		 Student student= studentService.getStudentById(id);
		 if(student ==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(student));
		
	}
	
	@PutMapping("/update/{Id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("Id") Long id ) {
		return studentService.updateStudent(student, id);
   }
	
	@DeleteMapping("deleteById/{Id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("Id") Long id) {
	try {
		this.studentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	}
}