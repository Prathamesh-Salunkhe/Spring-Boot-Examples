package com.mouritech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.model.Employee;
import com.mouritech.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	
	
	
}
