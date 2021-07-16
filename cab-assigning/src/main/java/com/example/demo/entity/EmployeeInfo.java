package com.example.demo.entity;


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
@Document(collection="employeeInfo")
public class EmployeeInfo {

	@Id
	String employeeId;
	String employeeName;
	String employeeMail;
	Integer phoneNumber;
	boolean isAdmin;
	boolean isBlocked;
	String domain;
	String domainLead;
	String projectName;
	String projectLead;
	
}
