package com.mouritech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mouritech.model.Employee;
@Service
public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long id);

	public void deleteEmployeeById(Long id);

	

	

	
}
