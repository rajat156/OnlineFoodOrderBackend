package com.example.Controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Client;
import com.example.Entity.ClientEmail;
import com.example.Entity.ConfirmOrder;
import com.example.Service.ClientEmailService;
import com.example.Service.ClientService;
import com.example.Service.ConfirmOrderService;


@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientEmailService clientEmailService;
	
	@Autowired
	private ConfirmOrderService confirmOrderService;

	@GetMapping("/totalBill/{customerId}")
	public Integer totalBill(@PathVariable("customerId") String customerId) {
		return this.clientService.getBillById(customerId);
	}
	
	@PostMapping("/setClientEmail")
	public ClientEmail setEmail(@RequestBody ClientEmail clientEmail)  {
		return this.clientEmailService.setEmail(clientEmail);
	}
	
	@GetMapping("/submitOrder/{customerId}")
	public ResponseEntity<String> submitOrder(@PathVariable("customerId") String customerId) {
		List<Client> clientByCustomerId = this.clientService.getClientByCustomerId(customerId);
		clientByCustomerId = clientByCustomerId.stream().filter(item-> item.isFlag()!=true).collect(Collectors.toList());
		ConfirmOrder confirmOrder = new ConfirmOrder();
		confirmOrder.setCustomerId(customerId);
		confirmOrder.setClient(clientByCustomerId);
		//confirmOrder.setData(new Date(System.currentTimeMillis()));
		confirmOrder.setData(new java.util.Date());
		Integer billById = this.clientService.getBillById(customerId);
		confirmOrder.setBill(billById);
		if(billById == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 String submitOrder = this.confirmOrderService.submitOrder(confirmOrder);
	 	clientByCustomerId.stream()
	 					.forEach(item -> item.setFlag(true));
	 	this.clientService.saveAllRecord(clientByCustomerId);
	 	return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/customerHistory/{customerId}")
	public List<ConfirmOrder> getHistory(@PathVariable("customerId") String customerId) {
		return this.confirmOrderService.getHistory(customerId);
	}
}
