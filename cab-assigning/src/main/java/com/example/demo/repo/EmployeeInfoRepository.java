package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.EmployeeInfo;

public interface EmployeeInfoRepository extends MongoRepository<EmployeeInfo, Integer> {

}
