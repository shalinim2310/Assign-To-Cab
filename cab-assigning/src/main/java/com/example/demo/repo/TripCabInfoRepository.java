package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.TripCabInfo;

public interface TripCabInfoRepository extends MongoRepository<TripCabInfo, Integer> {
	
	List<TripCabInfo> findByCabNumber(String cabNumber);
	
	@Query("{cabNumber:?0},{status:Assigned}")
	TripCabInfo findIfTripExists(String cabNumber);
	
}
