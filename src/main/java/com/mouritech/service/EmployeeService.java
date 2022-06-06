package com.mouritech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.entity.Employee;
import com.mouritech.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository repo;
	
	public String addEmp(Employee employee) {
		repo.save(employee);
		return "Employee Saved";
	}
	
	public String addAll(List<Employee> employee) {
		repo.saveAll(employee);
		return "Added all Employees";
	}
	
	public String deleteEmpById(int id) {
		Optional<Employee> employee= repo.findById(id);
		repo.deleteById(id);
		return "Employee Deleted Successfully";
	}
	
	public Employee getEmpById(int id) {
		Employee employee=repo.getById(id);
		
		return employee;
		
	}
	
	public String update(Employee employee) {
		repo.save(employee);
		return "Employee updated";
		
	}
}
