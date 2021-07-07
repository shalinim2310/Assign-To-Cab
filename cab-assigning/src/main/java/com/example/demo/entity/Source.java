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
@Document(collection="source")
public class Source {
	
	@Id
	int sourceID;
	String source;
	

}