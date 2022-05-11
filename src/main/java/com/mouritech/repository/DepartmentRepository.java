package com.mouritech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.entity.Department;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findById(Long departmentId);

	//Department saveAll(Department dept);

	
}
