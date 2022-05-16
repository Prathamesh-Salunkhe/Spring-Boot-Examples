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
	private StudentRepository studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
		 
	}

	@Override
	public List<Student> fetchStudent() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long studId) {
		Student std = studentRepo.getByStudId(studId);
		return std;
	}

	@Override
	public Student updateStudent(Student student, Long studId) {
		Student stud=studentRepo.findById(studId).get();
		if(Objects.nonNull(student.getStudName()) && !" ".equalsIgnoreCase(student.getStudName())) {
			stud.setStudName(student.getStudName());
		}
		if(Objects.nonNull(student.getStudDept()) && !"".equalsIgnoreCase(student.getStudDept())) {
			stud.setStudDept(student.getStudDept());
		}
		if(Objects.nonNull(student.getStudAge())&& !"".equalsIgnoreCase(student.getStudAge())) {
			stud.setStudAge(student.getStudAge());
		}
		return studentRepo.save(student);
	}

	@Override
	public String deleteStudent(Long studId) {
		
		 studentRepo.deleteById(studId);
		 return "Student has deleted Successfully";
	}

}
