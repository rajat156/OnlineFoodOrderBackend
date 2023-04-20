package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Client;
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
}
