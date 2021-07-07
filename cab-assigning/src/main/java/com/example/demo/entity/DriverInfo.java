package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Document(collection="driverInfo")
public class DriverInfo {

	@Id
	Long driverId;
	String driverName;
	String password;
	Long driverNumber;
	String licenseNumber;
    LocalDate expiryDate; 
    String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	Integer isDeleted;
	
}
