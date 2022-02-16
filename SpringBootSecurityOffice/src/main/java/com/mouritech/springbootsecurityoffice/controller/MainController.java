package com.mouritech.springbootsecurityoffice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.springbootsecurityoffice.entity.Staff;
import com.mouritech.springbootsecurityoffice.exception.StaffNotFoundException;
import com.mouritech.springbootsecurityoffice.service.StaffService;

@RestController
public class MainController {
	
	@GetMapping("/admin")
	public String admin() {
		return "<h2> Welcome Admin!!!!</h2>";
	}
	
	@GetMapping("/manager")
	public String user() {
		return "<h2> Welcome manager !</h2>";
	}
	
	
	@GetMapping("/all")
	public String all() {
		return "<h2> Welcome EveryOne!</h2>";
	}
	
	@Autowired
	StaffService staffService;
	
	@PostMapping("staff")
	public Staff insertStaff(@RequestBody Staff newStaff) {
		
		return staffService.insertStaff(newStaff);
		
	}
	
	@GetMapping("staff")
	public List<Staff> showAllStaffs(){
		return staffService.showAllStaffs();
		
	}
	
	@GetMapping("staff/{sid}")
	public Staff showStaffById(@PathVariable("sid") Long staffid) throws StaffNotFoundException{
		return staffService.showStaffById(staffid);
		
	}
	
	@PutMapping("updatestaff/{sid}")
	public Staff updateStaffById(@PathVariable("sid") Long staffid,@RequestBody Staff staff) throws StaffNotFoundException{
		return staffService.updateStaffById(staffid,staff);
		
	}
	@PutMapping("updatesalary/{sid}")
	public Staff updateSalaryById(@PathVariable("sid") Long staffid,@RequestBody Staff staff) throws StaffNotFoundException{
		return staffService.updateStaffById(staffid,staff);
		
	}
	
	@DeleteMapping("staff/{sid}")
	public String deleteStaffById(@PathVariable("sid") Long staffid) throws StaffNotFoundException{
		 staffService.deleteStaffById(staffid);
		 return "deleted the staff";
		
	}


}