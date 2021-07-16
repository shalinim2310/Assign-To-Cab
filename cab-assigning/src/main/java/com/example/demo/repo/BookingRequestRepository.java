package com.example.demo.repo;


import java.time.LocalDate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.BookingRequest;

public interface BookingRequestRepository extends MongoRepository<BookingRequest, Integer> {

	BookingRequest findByBookingId(Integer integer);

	@Query("{employeeId: ?0}, {status: booked}")
	BookingRequest findByEmployeeId(String string);
	
	@Query("{employeeId: ?0}")
	BookingRequest findByEmployeeIdAndStatus(String empId);

	LocalDate findByCreatedDate();


	@Query(value= "{bookingId:?0}",delete=true)
	Long deleteByBookingId(Integer bookingID);



}
