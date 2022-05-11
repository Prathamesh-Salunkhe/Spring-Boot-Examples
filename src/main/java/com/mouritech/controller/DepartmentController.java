package com.mouritech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.entity.Department;
import com.mouritech.service.DepartmentService;

@Controller
@RestController
@RequestMapping("/Dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/saveDept")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/GetDepartment")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
		
	}

	@PutMapping("/Department/{id}")
	public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId);
	}
	
	@DeleteMapping("/Department/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		 departmentService.deleteDepartmentById(departmentId);
		 return "Department has deleted Successfully";
		
	}
}
