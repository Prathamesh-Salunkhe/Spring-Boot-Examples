package com.mouritech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mouritech.entity.Department;

@Service
public interface DepartmentService {
	
	
	
	//save
	 Department saveDepartment(Department department);
	
	//read
	List<Department> fetchDepartmentList();
	
	//update
	Department updateDepartment(Department department, Long departmentId);

	
	
	//delete
	void deleteDepartmentById(Long departmentId);

}
