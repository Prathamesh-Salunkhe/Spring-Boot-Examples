package com.mouritech.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.entity.Student;
import com.mouritech.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		Student stud=studentRepository.getById(id);
		return stud;
	
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		Student stud=studentRepository.findById(id).get();	
		
		if(Objects.nonNull(student.getFirstName())&& ! "".equalsIgnoreCase(student.getFirstName())){
			stud.setFirstName(student.getFirstName());
		}
		
		if(Objects.nonNull(student.getLastName())&& ! "".equalsIgnoreCase(student.getLastName())){
			stud.setLastName(student.getLastName());
		}
		
		if(Objects.nonNull(student.getEmail())&& ! "".equalsIgnoreCase(student.getEmail())){
			stud.setEmail(student.getEmail());
		}
		
		return studentRepository.save(student);
	}

	@Override
	public String deleteStudentById(Long id) {
	    studentRepository.deleteById(id);
	    
		return "Student Has deleted";
	}

}
