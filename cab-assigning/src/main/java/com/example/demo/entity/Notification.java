package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.UUID;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Notification")
public class Notification {

	
	@Id	
	Long notificationNum;
	Long bookingId;
	
	long tripCabId;
	
	String employeeId;
	String role;
	String status;
	Long notificationId;
	LocalDateTime generatedTime;
	int isRead;
	LocalDateTime readTime;
	String createdBy;
	LocalDateTime createdDate;
	String modifiedBy;
	LocalDateTime modifiedDate;
	int isDeleted;
}
