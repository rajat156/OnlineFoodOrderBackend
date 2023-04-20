package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Admin;
import com.example.dao.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	public Admin saveAdmin(Admin admin) {
		return this.adminRepo.saveAndFlush(admin);
	}
	
	public List<Admin> getAdmin(){
		return this.adminRepo.findAll();
	}
}
