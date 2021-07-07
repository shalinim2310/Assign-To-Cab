package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level=AccessLevel.PRIVATE)
public class DropPoint {
	
	String dropPoint;

}
