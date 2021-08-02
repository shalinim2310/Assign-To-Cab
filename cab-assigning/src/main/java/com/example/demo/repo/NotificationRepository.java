package com.example.demo.repo;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, Long> {

}
