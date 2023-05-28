package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Booking;

@Repository
public interface Bookingdao extends JpaRepository<Booking, Integer>{

	public List<Booking> findAllByOrderByDateDesc();

	public List<Booking> findAllByOrderByRequestDateDesc();

}
