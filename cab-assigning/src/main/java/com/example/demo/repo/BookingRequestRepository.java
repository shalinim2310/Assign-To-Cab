package com.example.demo.repo;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.BookingRequest;

public interface BookingRequestRepository extends MongoRepository<BookingRequest, Long> {

	BookingRequest findByBookingId(Long bookingID);

	@Query("{employeeId: ?0, status: Booked}")
	BookingRequest findByEmployeeId(String string);
	
	@Query("{employeeId: ?0}")
	BookingRequest findByEmployeeIdAndStatus(String empId);

	LocalDate findByCreatedDate();


	@Query(value= "{bookingId:?0}",delete=true)
	Long deleteByBookingId(Long bookingID);
	
	 //add booking id instead of booking time
//    @Query("{employeeId : ?0, bookingTime : ?1, status : Booked}")
//    BookingRequest findByBookin(String empId, LocalTime bookingTime);



}
