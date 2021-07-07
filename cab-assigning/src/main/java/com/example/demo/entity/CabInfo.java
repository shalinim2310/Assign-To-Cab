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
@Document(collection="cabInfo")
public class CabInfo {

	@Id
	String cabNumber;

	Long driverId;
	String cabModel;
	Integer totalSeats;
	String insuranceNumber;
	LocalDate expiryDate;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	Integer isDeleted;
}
