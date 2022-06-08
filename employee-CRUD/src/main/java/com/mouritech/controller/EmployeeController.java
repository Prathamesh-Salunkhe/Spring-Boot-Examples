package com.mouritech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mouritech.model.Employee;
import com.mouritech.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> emp = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> geEmptById(@PathVariable("id") Long id){
		Employee emp = employeeService.getEmpById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable ("id") Long id){
		 employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp= employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}

}
