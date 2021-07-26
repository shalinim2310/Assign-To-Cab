package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.CabInfo;

public interface CabInfoRepository extends MongoRepository<CabInfo, String> {

	List<CabInfo> findByCabModel(String cabModel);

	List<CabInfo> findByIsDeleted(int i);

	List<CabInfo> findByCabModelAndIsDeleted(String cabModel, int i);

}
