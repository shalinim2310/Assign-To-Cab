package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Document(collection="bookingRequest")
public class BookingRequest {

	@Id
	Integer bookingId;
	Integer employeeId;
	String employeeName;
	String source;
	String destination;
    String dropPoint;	
    LocalTime bookingTime;
	LocalTime timeSlot;
	Boolean addedManually;
	Integer tripId;
	LocalTime startTime;
	LocalTime reachedTime;
	String complaintDescription;
	String remarks;
	String status;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	int isDeleted;
}
