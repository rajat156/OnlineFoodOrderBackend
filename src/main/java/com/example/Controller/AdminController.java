package com.example.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Entity.Booking;
import com.example.Entity.Client;
import com.example.Entity.ConfirmOrder;
import com.example.Entity.Food;
import com.example.Service.AdminService;
import com.example.Service.BookingService;
import com.example.Service.ClientService;
import com.example.Service.ConfirmOrderService;
import com.example.Service.FoodService;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ConfirmOrderService confirmOrderService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return this.adminService.saveAdmin(admin);
	}
	
	@GetMapping("/getAdmin")
	public List<Admin> getAdmin(){
		return this.adminService.getAdmin();
	}
	
	@PostMapping("/checkAdmin")
	public ResponseEntity<Admin> checkAdmin(@RequestBody Admin admin){
		List<Admin> admin2 = this.adminService.getAdmin();
		boolean flag=true;
		for(Admin admin1:admin2) {
			if(admin1.getEmail().equals(admin.getEmail()) && admin1.getPassword().equals(admin.getPassword())) {
				flag=false;
				break;
			}
		}
		if(flag)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	
	@GetMapping("/todayOrder")
	public List<ConfirmOrder> getTodayOrder(){
			return  this.confirmOrderService.getTodayOrder();
			
	}
	
	@PostMapping("/saveFood")
	public ResponseEntity<String> addItem(@RequestBody Food food){
	
		if(food.getItem()==null)
			food.setItem("TODAYMEALS");
		this.foodService.saveFood(food);
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/getAllFoodForAdmin")
	public List<Food> getAllFood(){
		return this.foodService.findAll();
	}
	
	@DeleteMapping("/deleteFoodFromTable/{id}")
	public ResponseEntity<String>  deleteFood(@PathVariable("id") int id){
		this.foodService.deleteFood(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@PutMapping("/markOrderComplete")
	public  ResponseEntity<String> markOrderComplete(@RequestBody Integer integer){
		this.confirmOrderService.markOrderComplete(integer);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/getAllTodayOffer")
	public List<Food> getTodayOffer(){
		return this.foodService.getTodayOffer();
	}
	
	@PostMapping("/submitBookingRequest")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
		booking.setRequestDate(new Date());
		Booking setBooking = this.bookingService.setBooking(booking);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
	}
	
	@GetMapping("/getAllBookingRequest")
	public List<Booking> getAllBookingRequest(){
		return this.bookingService.getAllBookingRequest();
	}
	
	@GetMapping("/rejectBookingRequest/{data}")
	public ResponseEntity<String> rejectBookingRequest(@PathVariable("data") int id){
		this.bookingService.rejectBookingRequest(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/acceptBookingRequest/{data}")
	public ResponseEntity<String> acceptBookingRequest(@PathVariable("data") int id){
		this.bookingService.acceptBookingRequest(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/completeBookingRequest/{data}")
	public ResponseEntity<String> completeBookingRequest(@PathVariable("data") int id){
		this.bookingService.completeBookingRequest(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
}
