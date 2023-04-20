package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Admin;
import com.example.Service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
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
			}
		}
		if(flag)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
