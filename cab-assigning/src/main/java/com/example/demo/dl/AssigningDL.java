package com.example.demo.dl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.bo.AssigningBO;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.Source;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.CabInfoRepository;
import com.example.demo.repo.DestinationRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeInfoRepository;
import com.example.demo.repo.SourceRepository;
import com.example.demo.repo.TripCabInfoRepository;

@Service(value = "cabInfoService")
public class AssigningDL {

	@Autowired
	private CabInfoRepository cabRepo;

	@Autowired
	private DriverInfoRepository driverRepo;

	@Autowired
	private EmployeeInfoRepository empRepo;

	@Autowired
	private BookingRequestRepository reqRepo;

	@Autowired
	private TripCabInfoRepository tripRepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private SourceRepository repo1;

	@Autowired
	private DestinationRepository repo2;

	// -------------------------------------------Today's Request page starts
	// here------------------------------------//

	@Autowired
	private MongoTemplate template;

	public BookingRequest addRequest(BookingRequest booking) {
		return this.reqRepo.save(booking);
	}

	public List<BookingRequest> findAllBooks() {
		return this.reqRepo.findAll();
	}

	public List<BookingRequest> filterRequests(Query dynamicQuery) {
		return this.template.find(dynamicQuery, BookingRequest.class, "BookingRequest");
	}

	public Long deleteRequest(Long bookingID) {
		// TODO Auto-generated method stub
		return this.reqRepo.deleteByBookingId(bookingID);
	}

	public List<Source> findAllSources() {
		// TODO Auto-generated method stub
		return this.repo1.findAll();
	}

	public Source addSource(Source source) {
		// TODO Auto-generated method stub
		return this.repo1.save(source);
	}

	public List<Destination> findAllDestinations() {
		// TODO Auto-generated method stub
		return this.repo2.findAll();
	}

	public Destination addDestination(Destination dest) {
		// TODO Auto-generated method stub
		return this.repo2.save(dest);
	}

	public Long getCount() {
		// TODO Auto-generated method stub
		return this.reqRepo.findAll().stream().filter(e -> e.getStatus().equals("Booked")).count();
	}

	public List<BookingRequest> findAllBooking(Query query) {
		// TODO Auto-generated method stub
		return this.template.find(query, BookingRequest.class, "BookingRequest");
	}

	public List<BookingRequest> searchByName(Query query) {
		// TODO Auto-generated method stub
		return this.template.find(query, BookingRequest.class, "BookingRequest");
	}

	// -------------------------------------------Today's Request page ends
	// here------------------------------------//

	// ----------------------------------------Assign To Cab pop up starts
	// here---------------------------------//

	// Find All CabModel with only distinct value as a list
	public Set<String> findAllCabModel(int i) {

		List<CabInfo> cabInfo = this.cabRepo.findByIsDeleted(i);

		Set<String> cabModel = new HashSet<>();

		for (CabInfo eachCab : cabInfo) {

			String oneCab = eachCab.getCabModel();

			cabModel.add(oneCab);
		}

		return cabModel;
	}

	// Find all CabInfo
	public List<CabInfo> findAllCabInfo() {

		return this.cabRepo.findAll();
	}

	// Save CabInfo
	public CabInfo save(CabInfo entity) {

		return this.cabRepo.save(entity);
	}

	// Find CabInfo by cabModel
	public List<CabInfo> findByCabModel(String cabModel) {

		return this.cabRepo.findByCabModel(cabModel);
	}

	// Find all DriverDetails
	public List<DriverInfo> findAllDriverInfo() {

		return this.driverRepo.findAll();
	}

	// Save DriverInfo
	public DriverInfo save(DriverInfo entity) {

		return this.driverRepo.save(entity);
	}

	// Find all Employee Details
	public List<EmployeeInfo> findAllEmployeeInfo() {

		return this.empRepo.findAll();
	}

	// Save Employee Info
	public EmployeeInfo save(EmployeeInfo entity) {

		return this.empRepo.save(entity);
	}

	// Find all Booking Request Details
	public List<BookingRequest> findAllBookingReq() {

		return this.reqRepo.findAll();
	}

	// Save BookingRequest
	public BookingRequest save(BookingRequest entity) {

		return this.reqRepo.save(entity);
	}

	// Find all Trip Details
	public List<TripCabInfo> findAllTrips() {

		return this.tripRepo.findAll();
	}

	// Save Trip Details
	public TripCabInfo save(TripCabInfo entity) {

		return this.tripRepo.save(entity);
	}

	// Get Cab number by cab model, destination, timeslot and selected number of
	// employee's
	
	public List<AssigningBO> findCabNumber(String cabModel, Integer selected, String destination, String timeSlot) {

       List<CabInfo> cabList = cabRepo.findByCabModelAndIsDeleted(cabModel,0);

		List<AssigningBO> availableCabs = new ArrayList<>();

		for (CabInfo eachCab : cabList) {

			System.out.println(eachCab.getCabNumber());

			List<TripCabInfo> tripCabAssigned = tripRepo.findByCabNumber(eachCab.getCabNumber());

			int totalSeats = eachCab.getTotalSeats();

			LocalTime time = LocalTime.parse(timeSlot);

			Optional<DriverInfo> driver1 = driverRepo.findById(eachCab.getDriverId());
			DriverInfo driver = null;
			if(!driver1.isEmpty())
			   driver = driver1.get();

			if (tripCabAssigned == null && totalSeats >= selected) {
				availableCabs.add(new AssigningBO(eachCab.getCabNumber(), driver.getDriverName(),
						driver.getDriverNumber(), destination, time, eachCab.getTotalSeats(), eachCab.getTotalSeats(),
						0, null, null, null));
			}

			else {
				int count = 0;

				for (TripCabInfo eachCabInfo : tripCabAssigned) {

					if (eachCabInfo.getStatus().equals("Reached")) {
						count++;
					}

				}

				if (count == tripCabAssigned.size() && totalSeats >= selected) {
					availableCabs.add(new AssigningBO(eachCab.getCabNumber(), driver.getDriverName(),
							driver.getDriverNumber(), destination, time, eachCab.getTotalSeats(),
							eachCab.getTotalSeats(), 0, null, null, null));
				}

			}

			for (TripCabInfo eachTrip : tripCabAssigned) {
				int remainingSeats = eachTrip.getRemainingSeats();
				String dest = eachTrip.getDestination();
				LocalTime time1 = eachTrip.getTimeSlot();
				if (remainingSeats >= selected && dest.equals(destination) && time1.equals(time)
						&& (eachTrip.getStatus().equalsIgnoreCase("Assigned"))) {
					availableCabs.add(new AssigningBO(eachTrip.getCabNumber(), driver.getDriverName(),
							driver.getDriverNumber(), destination, time1, eachTrip.getTotalSeats(),
							eachTrip.getRemainingSeats(), eachTrip.getAllocatedSeats(), null, null, null));
				}
			}

		}
		return availableCabs;
	}

	
	
	
	// To update and save in the Trip cab info , update in Booking Request table
	public AssigningBO storeTrip(AssigningBO info) {
		System.out.println(info.getCabNumber());
		System.out.println(tripRepo.findIfTripExists(info.getCabNumber()));
		TripCabInfo trip = tripRepo.findIfTripExists(info.getCabNumber());
		DriverInfo driver = driverRepo.findByDriverNumber(info.getDriverNumber());
		
		TripCabInfo newTrip;
		if (trip != null) {
			
			String status = trip.getStatus();
			// System.out.println(trip.getAllocatedSeats());
			// System.out.println(info.getAllocatedSeats());
			
		
			
		  if (status.equals("Reached")) {
				newTrip = new TripCabInfo();
				newTrip.setTripCabId(tripRepo.count() + 1);
				newTrip.setCabNumber(info.getCabNumber());
				newTrip.setDriverId(driver.getDriverId());
				newTrip.setSource(info.getSource());
				newTrip.setDestination(info.getDestination());
				newTrip.setDateOfTravel(info.getDateOfTravel());
				newTrip.setTimeSlot(info.getTimeSlot());
				newTrip.setTotalSeats(info.getTotalSeats());
				newTrip.setRemainingSeats(info.getTotalSeats() - info.getAllocatedSeats());
				newTrip.setAllocatedSeats(info.getAllocatedSeats());
				newTrip.setStatus("Assigned");
				tripRepo.save(newTrip);
				updateRequest(info.getEmpList(), newTrip.getTripCabId());
			
		
			} else {
				trip.setAllocatedSeats(trip.getAllocatedSeats() + info.getAllocatedSeats());
				trip.setRemainingSeats(trip.getRemainingSeats() - info.getAllocatedSeats());
				tripRepo.save(trip);
				updateRequest(info.getEmpList(), trip.getTripCabId());
			}
		} else {
			newTrip = new TripCabInfo();
			newTrip.setTripCabId(tripRepo.count() + 1);
			newTrip.setCabNumber(info.getCabNumber());
			newTrip.setDriverId(driver.getDriverId());
			newTrip.setSource(info.getSource());
			newTrip.setDestination(info.getDestination());
			newTrip.setDateOfTravel(info.getDateOfTravel());
			newTrip.setTimeSlot(info.getTimeSlot());
			newTrip.setTotalSeats(info.getTotalSeats());
			newTrip.setRemainingSeats(info.getTotalSeats() - info.getAllocatedSeats());
			newTrip.setAllocatedSeats(info.getAllocatedSeats());
			newTrip.setStatus("Assigned");
			tripRepo.save(newTrip);
			updateRequest(info.getEmpList(), newTrip.getTripCabId());
			// System.out.println("New trip info : ");
		}
		return info;
	}

	// To update the Booking Request table
	public boolean updateRequest(List<BookingRequest> req, Long tripCabId) {
		for (BookingRequest eachReq : req) {

			BookingRequest bookReq = reqRepo.findByEmployeeId(eachReq.getEmployeeId());
			bookReq.setStatus("Assigned");
			bookReq.setTripCabId(tripCabId);

			reqRepo.save(bookReq);
			System.out.println(bookReq);
		}

		return true;

	}
  
	
	
	// code to check if status is not cancelled
	public boolean checkEmpStatusBeforeAssignment(List<BookingRequest> empList) {
		boolean result = false;

		for (BookingRequest emp : empList) {

			String empId = emp.getEmployeeId();
			BookingRequest req = reqRepo.findByBookingId(emp.getBookingId());
		//	BookingRequest req = reqRepo.findByEmployeeId(empId);

			// If more than one admins are assigning at a time, so checking the status
			// whether it is Assigned already
			if(req==null) {
				result=true;
			} 
//			else {
//			if(emp.getTimeSlot().equals(req.getTimeSlot()) && emp.getDestination().equalsIgnoreCase(req.getDestination()) && !emp.getBookingTime().equals(req.getBookingTime())) {
//					
//				}
//			}
//		if (req.getStatus().equalsIgnoreCase("Cancelled") || req.getStatus().equalsIgnoreCase("Assigned")) {
//				result = true;
//			}
//			

		}

		return result;

	}
	
	


	// ----------------------------------------Assign To Cab pop up ends
	// here---------------------------------//

}
