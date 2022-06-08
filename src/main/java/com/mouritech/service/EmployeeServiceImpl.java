package com.mouritech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.exception.BusinessException;
import com.mouritech.model.Employee;
import com.mouritech.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
			if(employee.getFirstName().isEmpty() || employee.getFirstName().length()==0 && employee.getLastName().isEmpty() || employee.getLastName().length()==0  ) {
		        throw new BusinessException("601","Please send proper name");
			}
		try {
		    Employee emp = employeeRepository.save(employee);
		    return emp;
	    }catch(IllegalArgumentException e) {
			throw new BusinessException("602","Given employee is null"+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603","Something Went Wrong In Service Layer While Saving The Data"+e.getMessage());
		    }
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emplist = null;
		try {
			 emplist = employeeRepository.findAll();
		}catch (Exception e) {
			throw new BusinessException("605","Something Went Wrong In Service Layer While Fetching All Employees"+e.getMessage());
		}
			if(emplist.isEmpty()) 
				throw new BusinessException("604","List is empty, we do not have any data in DB");
			
		    return emplist;
		
		
	}

	@Override
	public Employee getEmpById(Long id) {
		try {
		 return employeeRepository.findById(id).get();
		 
		}catch(IllegalArgumentException e) {
			throw new BusinessException("606","Given employee id is null, plese send saved id"+e.getMessage());
			
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("607","Given employee id does not exist in DB"+e.getMessage());
		}
	}

	@Override
	public void deleteEmployeeById(Long id) {
		try {
			
			employeeRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608","Given employee id is null, please send id to delete "+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("609","Something Went Wrong In Service Layer While Deleting Employee "+e.getMessage());
		}
		
	}

	
	
	
}
