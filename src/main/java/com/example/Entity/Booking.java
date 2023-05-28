package com.example.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String customerName;
	private String number;
	private Date date;
	private java.util.Date requestDate;
	private boolean status;
	private boolean completeStatus;
	private java.util.Date completeDate;
	private boolean reject;
	
	
	
	
	public boolean isReject() {
		return reject;
	}
	public void setReject(boolean reject) {
		this.reject = reject;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(boolean completeStatus) {
		this.completeStatus = completeStatus;
	}
	public java.util.Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(java.util.Date completeDate) {
		this.completeDate = completeDate;
	}
	public java.util.Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(java.util.Date requestDate) {
		this.requestDate = requestDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
