package com.mouritech.springbootsecurityoffice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.springbootsecurityoffice.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}

