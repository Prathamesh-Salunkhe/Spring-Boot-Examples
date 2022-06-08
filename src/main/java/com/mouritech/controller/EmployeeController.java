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

import com.mouritech.exception.BusinessException;
import com.mouritech.exception.ControllerException;
import com.mouritech.model.Employee;
import com.mouritech.service.EmployeeService;

@Controller
public class EmployeeController extends BusinessException {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
			Employee emp = employeeService.addEmployee(employee);
			return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce = new ControllerException("610","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployees(){
		try {
		List<Employee> emp = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
		}
		catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce = new ControllerException("610","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<?> geEmptById(@PathVariable("id") Long id){
		try {
		Employee emp = employeeService.getEmpById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce = new ControllerException("610","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable ("id") Long id){
		try {
		 employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("610","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp= employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}

}
