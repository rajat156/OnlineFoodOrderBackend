package com.example.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Client;
import com.example.Entity.ConfirmOrder;
import com.example.dao.ClientRepo;

@Service
public class ClientService {

	@Autowired
	private ClientRepo clientRepo;
	
	public List<Client> getClientByCustomerId(String customerId){
		return this.clientRepo.findAllByCustomerId(customerId);
	}
	
	public Client saveRecord(Client client) {
		return this.clientRepo.saveAndFlush(client);
	}
	
	public void deleteRecord(int id) {
		this.clientRepo.deleteById(id);
	}

	public Integer getBillById(String customerId) {
		// TODO Auto-generated method stub
		List<Client> findAllByCustomerId = this.clientRepo.findAllByCustomerId(customerId);
		findAllByCustomerId = 	findAllByCustomerId.stream().filter(item -> item.isFlag()!=true).collect(Collectors.toList());
		int totalBill = 0;
		for(Client client : findAllByCustomerId) {
			String price = client.getFood().getPrice();
			totalBill+=Integer.parseInt(price);
		}
		return totalBill;
	}

	public void saveAllRecord(List<Client> clientByCustomerId) {
		// TODO Auto-generated method stub
		this.clientRepo.saveAllAndFlush(clientByCustomerId);
	}


}
