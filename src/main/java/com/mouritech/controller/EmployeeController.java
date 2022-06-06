package com.mouritech.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.entity.Employee;
import com.mouritech.service.EmployeeService;

@RestController
@Transactional
public class EmployeeController {
	
	@Autowired
	public EmployeeService empService;
	
	@PostMapping("/AddEmployee")
	public String addEmp(@RequestBody Employee employee) {
		return empService.addEmp(employee);
	}
	
	
	  @PostMapping("/AddMultipleEmployees") 
	  public String addAll(@RequestBody List<Employee> employee) {
		  return empService.addAll(employee); 
		  
	  }
	  
	  @DeleteMapping("/DeleteById/{id}")
	  public String deleteEmpById(@PathVariable int id) { 
		  return empService.deleteEmpById(id); 
		  
	  }
	  
	  @GetMapping("getEmpById/{id}") 
	  public Employee getEmpById(@PathVariable int id){ 
		  return empService.getEmpById(id); 
		  
	  }
//	  
//	  @PutMapping("/update") public String update(@RequestBody Employee employee) {
//	  return empService.update(employee); }
//	 
}
