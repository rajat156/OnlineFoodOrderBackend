package com.example.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Booking;
import com.example.dao.Bookingdao;

@Service
public class BookingService {

	@Autowired
	private Bookingdao bookingdao;
	
	public Booking setBooking(Booking booking) {
		return  this.bookingdao.saveAndFlush(booking);
	}

	public List<Booking> getAllBookingRequest() {
		// TODO Auto-generated method stub
		return this.bookingdao.findAllByOrderByRequestDateDesc();
	}

	public void rejectBookingRequest(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> findById = this.bookingdao.findById(id);
			Booking booking = findById.get();
			booking.setReject(true);
			booking.setCompleteDate(new Date());
			this.bookingdao.saveAndFlush(booking);
	}

	public void acceptBookingRequest(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> findById = this.bookingdao.findById(id);
		Booking booking = findById.get();
		booking.setStatus(true);
		this.bookingdao.saveAndFlush(booking);
	}

	public void completeBookingRequest(int id) {
		// TODO Auto-generated method stub
		Optional<Booking> findById = this.bookingdao.findById(id);
		Booking booking = findById.get();
		booking.setCompleteStatus(true);
		booking.setCompleteDate(new Date());
		this.bookingdao.saveAndFlush(booking);
	}
}
