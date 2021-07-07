package com.example.demo.entity;



import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level=AccessLevel.PRIVATE)
public class TimeSlot {
	
	LocalTime timeSlot;

}