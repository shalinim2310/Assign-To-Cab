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
@Document(collection="tripCabInfo")
public class TripCabInfo {

	@Id
	Integer tripCabId;
	
	String cabNumber;
	Long driverId;
	String cabModel;
	String source;
	String destination;
    String dropPoint;	
	LocalDate dateOfTravel;
	LocalTime timeSlot;
	Integer totalSeats;
	Integer remainingSeats;
	Integer allocatedSeats;
	String status;
	LocalTime startTime;
	LocalTime endTime;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	Integer isDeleted;
}
