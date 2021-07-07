package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.DriverInfo;

public interface DriverInfoRepository extends MongoRepository<DriverInfo, Long> {

	 DriverInfo findByDriverNumber(Long long1);

	 DriverInfo findByDriverId(Long long1);
}
