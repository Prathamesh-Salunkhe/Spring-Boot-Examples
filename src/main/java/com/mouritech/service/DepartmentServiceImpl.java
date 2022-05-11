package com.mouritech.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.entity.Department;
import com.mouritech.repository.DepartmentRepository;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		Department dept=departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !" ".equalsIgnoreCase(department.getDepartmentName())) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !" ".equalsIgnoreCase(department.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && !" ".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		
		
		return departmentRepository.save(dept);
	}


	
	//delete
	@Override
	public void deleteDepartmentById(Long departmentId) {

		departmentRepository.deleteById(departmentId);
	}
	

}
