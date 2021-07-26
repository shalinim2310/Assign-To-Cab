package com.example.demo.entity;

 

import java.time.LocalDateTime;

 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

 

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

 

@Document(collection = "EmployeeDetails")
public class EmployeeInfo {
	
	@Id
	String employeeId;
	
	String employeeName;
	String employeeMail;
	long phoneNumber;
	
	int isAdmin;
	int isBlocked;
	LocalDateTime blockedDate;
	String domain;
	String domainLead;
	String projectName;
	String projectLead;
	String createdBy;
	LocalDateTime createdDate;
	String modifiedBy;
	LocalDateTime modifiedDate;
	int isDeleted;
	
	
}