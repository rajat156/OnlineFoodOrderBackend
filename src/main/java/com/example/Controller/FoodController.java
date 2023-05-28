	package com.example.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Client;
import com.example.Entity.Food;
import com.example.Entity.TodayDeals;
import com.example.Service.ClientService;
import com.example.Service.FoodService;
import com.example.Service.TodayDealsService;
import com.example.dao.FoodRepo;

@RestController
@CrossOrigin("*")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private ClientService clientService;
	
	
	@Autowired
	private TodayDealsService todayDealsService;
	
	@GetMapping("/getAllFood/{item}")
	public List<Food> getAllFood(@PathVariable("item") String item){
		
		return this.foodService.findAllByItem(item);
	}
	
	@PostMapping("/saveRecord")
	public Client saveRecord(@RequestBody Client client)
	{
		Food findById = this.foodService.findById(Integer.parseInt(client.getItemId()));
		client.setFood(findById);
		return this.clientService.saveRecord(client);
	}
	
	@GetMapping("/getRecord/{id}")
	public List<Food> getRecord(@PathVariable("id") String customerId) {
		 List<Client> clientByCustomerId = this.clientService.getClientByCustomerId(customerId);
		 		clientByCustomerId =	clientByCustomerId.stream().filter(item-> item.isFlag()!=true).collect(Collectors.toList());
		 List<Food> list = new ArrayList<>();
		 for(Client client: clientByCustomerId) {
			 list.add(this.foodService.findById(Integer.parseInt(client.getItemId())));
		 }
		 return list;
	}
	
	@GetMapping("/getClientRecord/{id}")
	public List<Client> getClientRecord(@PathVariable("id") String customerId){
		 List<Client> clientByCustomerId = this.clientService.getClientByCustomerId(customerId);
	 		clientByCustomerId =	clientByCustomerId.stream().filter(item-> item.isFlag()!=true).collect(Collectors.toList());
	 		return clientByCustomerId;
	}
	
	
	@GetMapping("/searchFood/{food}")
	public List<Food> getSearchFood(@PathVariable("food") String food){
		return this.foodService.findAllSearchFood(food);
		
	}
	
	@GetMapping("/deleteClientRecord/{id}")
	public String deleteClientRecord(@PathVariable("id") String id) {
		this.clientService.deleteRecord(Integer.parseInt(id));
		return "";
	}

	@GetMapping("/todayDeals")
	public List<TodayDeals> getTodayDeals(){
		return this.todayDealsService.getTodayDeals();
	}
}
