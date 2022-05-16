package com.mouritech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_info")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10000L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studId;
	private String studName;
	private String studDept;
	private String studAge;

	public Student() {
		
	}

	public Student(Long studId, String studName, String studDept, String studAge) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studDept = studDept;
		this.studAge = studAge;
	}

	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudDept() {
		return studDept;
	}

	public void setStudDept(String studDept) {
		this.studDept = studDept;
	}

	public String getStudAge() {
		return studAge;
	}

	public void setStudAge(String studAge) {
		this.studAge = studAge;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studDept=" + studDept + ", studAge="
				+ studAge + "]";
	}
	
	
}
