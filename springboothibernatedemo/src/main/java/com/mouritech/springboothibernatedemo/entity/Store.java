package com.mouritech.springboothibernatedemo.entity;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "store_info")
@EntityListeners(AuditingEntityListener.class)
public class Store {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id",length = 64)
	private String storeId;
	
	@Column(name="store_name")
	private String storeName;
	
	@Column(name="store_city")
	private String storeCity;
	
	
	@Column(name="store_country")
	private String storeCountry;

	@Column(name="store_mail")
	private String storeMail;
	
	@Column(name="store_contactno")
	private String storeContactNo;
	
	@Column(name="store_startdate")
	@LastModifiedDate
	private Date storeStartDate;


   public Store() {
	   
	   
   }


public Store( String storeCity, String storeCountry, String storeMail, String storeContactNo,
		Date storeStartDate) {
	super();
	this.storeCity = storeCity;
	this.storeCountry = storeCountry;
	this.storeMail = storeMail;
	this.storeContactNo = storeContactNo;
	this.storeStartDate = storeStartDate;
}


public Store(String storeName, String storeCity) {
	super();
	this.storeName = storeName;
	this.storeCity = storeCity;
}


public String getStoreId() {
	return storeId;
}


public void setStoreId(String storeId) {
	this.storeId = storeId;
}


public String getStoreName() {
	return storeName;
}


public void setStoreName(String storeName) {
	this.storeName = storeName;
}


public String getStoreCity() {
	return storeCity;
}


public void setStoreCity(String storeCity) {
	this.storeCity = storeCity;
}


public String getStoreCountry() {
	return storeCountry;
}


public void setStoreCountry(String storeCountry) {
	this.storeCountry = storeCountry;
}


public String getStoreMail() {
	return storeMail;
}


public void setStoreMail(String storeMail) {
	this.storeMail = storeMail;
}


public String getStoreContactNo() {
	return storeContactNo;
}


public void setStoreContactNo(String storeContactNo) {
	this.storeContactNo = storeContactNo;
}


public Date getStoreStartDate() {
	return storeStartDate;
}


public void setStoreStartDate(Date storeStartDate) {
	this.storeStartDate = storeStartDate;
}


@Override
public String toString() {
	return "Store [storeId=" + storeId + ", storeName=" + storeName + ", storeCity=" + storeCity + ", storeCountry="
			+ storeCountry + ", storeMail=" + storeMail + ", storeContactNo=" + storeContactNo + ", storeStartDate="
			+ storeStartDate + "]";
}
   
}  
