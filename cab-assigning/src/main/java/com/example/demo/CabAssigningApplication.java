package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.Destination;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.DropPoint;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.Source;
import com.example.demo.entity.TimeSlot;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRequestRepository;
import com.example.demo.repo.CabInfoRepository;
import com.example.demo.repo.DestinationRepository;
import com.example.demo.repo.DriverInfoRepository;
import com.example.demo.repo.EmployeeInfoRepository;
import com.example.demo.repo.SourceRepository;
import com.example.demo.repo.TripCabInfoRepository;

@SpringBootApplication
public class CabAssigningApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabAssigningApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			CabInfoRepository cabRepo;
			
			@Autowired
			DriverInfoRepository driverRepo;
			
			@Autowired
			EmployeeInfoRepository empRepo;
			
			@Autowired
			BookingRequestRepository reqRepo;
			
			@Autowired
			SourceRepository repo1;
			
			@Autowired
			DestinationRepository repo2;
//			@Autowired
//			TripCabInfoRepository tripRepo;
		

			public void run(String... args) throws Exception{
			
//				System.out.println(reqRepo.findByEmployeeIdAndBookingTime("AVI_103", LocalTime.of(14, 55, 19)));
//				DriverInfo driver1= new DriverInfo(Long.valueOf(2222L),"Pradeep A","Pradeep#2222",Long.valueOf(9987655434L),"LCN2312",LocalDate.of(2021, 10, 30),"Pradeep A",LocalDate.now(),null,null,0);
//				this.driverRepo.save(driver1);
//		
//				
//				CabInfo cab1= new CabInfo("TN8K0000",driver1.getDriverId(),"Swift",6,"INNO4567",LocalDate.of(2022, 10, 10),"Pradeep A",LocalDate.now(),null,null,0);
//				this.cabRepo.save(cab1);
////				
//				EmployeeInfo emp1= new EmployeeInfo("704","Lisha","lisha@abc.com",Long.valueOf(996421234L),true,false,"UXD","Shyam","Hotel Service Application","Shyam","Ram",LocalDateTime.now(),null,null,false);
//				this.empRepo.save(emp1);
//
//				BookingRequest req1= new BookingRequest(1113,emp1.getEmployeeId(),emp1.getEmployeeName(),"Alpha City","Tambaram","Medavakkam",LocalTime.now(),LocalTime.of(22, 30),0,null,null,null,null,null,"booked","Ram",LocalDate.of(2021, 07,20),null,null,0);
//				
//				this.reqRepo.save(req1);
				
//				
//				TripCabInfo trip1= new TripCabInfo(401,cab1.getCabNumber(),driver1.getDriverId(),cab1.getCabModel(),
//						"Alpha City","Tambaram","Medavakkam","23-06-2021","10 pm",cab1.getTotalSeats(),1,13,"Assigned",
//						null,null,null,null,null,null,0);
//			this.tripRepo.save(trip1);	
				
				
				
//				Before LocalDate and Time was changed	
//				
//				DriverInfo driver1= new DriverInfo(Long.valueOf(111), "Naveen Kumar", "naveen@111",Long.valueOf(9887654320L),"KR876534", LocalDate.of(2022,12, 23),"Ram",LocalDate.of(2023,12,12),null,null,0);
//				this.driverRepo.save(driver1);
//				
//				
//				CabInfo cab1= new CabInfo("TN01KR1625", driver1.getDriverId(), "Tavera",10,"IN2341298", LocalDate.of(2023,12,12),"Ram",LocalDate.of(2023,12,12),null,null,0);
//				this.cabRepo.save(cab1);
				
				
//				Source source1=new Source(101,"Alpha City");
//				repo1.save(source1);
//				
//				Source source2=new Source(102,"Bayline Info City");
//				repo1.save(source2);
//				
//				DropPoint point1=new DropPoint("Shollinganallur");
//				DropPoint point2=new DropPoint("Medavakkam");
//				DropPoint point3=new DropPoint("Camp Road");
//				DropPoint point4=new DropPoint("Thoraipakkam");
//				DropPoint point5=new DropPoint("Tharamani");
//				DropPoint point6=new DropPoint("Madipakkam");
//				List<DropPoint> list1=new ArrayList<>();
//				List<DropPoint> list2=new ArrayList<>();
//				list1.add(point1);
//				list1.add(point2);
//				list1.add(point3);
//				list2.add(point4);
//				list2.add(point5);
//				list2.add(point6);
//				
//				TimeSlot slot1=new TimeSlot(LocalTime.of(21, 30,00));
//				TimeSlot slot2=new TimeSlot(LocalTime.of(20, 30,00));
//				TimeSlot slot3=new TimeSlot(LocalTime.of(00, 00,00));
//				TimeSlot slot4=new TimeSlot(LocalTime.of(20, 00,00));
//				TimeSlot slot5=new TimeSlot(LocalTime.of(22, 00,00));
//				TimeSlot slot6=new TimeSlot(LocalTime.of(22, 30,00));
//				TimeSlot slot7=new TimeSlot(LocalTime.of(01, 30,00));
//				TimeSlot slot8=new TimeSlot(LocalTime.of(01, 00,00));
//				List<TimeSlot> list3=new ArrayList<>();
//				list3.add(slot1);
//				list3.add(slot2);
//				list3.add(slot3);
//				list3.add(slot4);
//				list3.add(slot5);
//				list3.add(slot6);
//				list3.add(slot7);
//				
//				Destination dest1=new Destination(12122,"Tambaram",list1,list3);
//				repo2.save(dest1); 
//				
//				Destination dest2=new Destination(12123,"Velacherry",list2,list3);
//				repo2.save(dest2); 
//				
//				
//				
//				
			}
		};
	}
}
