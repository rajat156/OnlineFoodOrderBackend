package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Food;
import com.example.dao.FoodRepo;

@Service
public class FoodService {

	@Autowired
	private FoodRepo foodRepo;
	
	public List<Food> getFoodByItem(){
		return this.foodRepo.findAll();
	}

	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return this.foodRepo.findAll();
	}

	public List<Food> findAllByItem(String item) {
		// TODO Auto-generated method stub
		return this.foodRepo.findAllByItem(item);
	}
	
	public List<Food> findAllSearchFood(String food) {
		return this.foodRepo.searchRecord(food);
	}

	public Food findById(int id) {
		// TODO Auto-generated method stub
		Optional<Food> findById = this.foodRepo.findById(id);
		return findById.get();
	}

	public void saveFood(Food food) {
		// TODO Auto-generated method stub
		this.foodRepo.saveAndFlush(food);
	}

	public void deleteFood(int id) {
		// TODO Auto-generated method stub
		Optional<Food> findById = this.foodRepo.findById(id);
		this.foodRepo.delete(findById.get());
	}

	public List<Food> getTodayOffer() {
		// TODO Auto-generated method stub
		return this.foodRepo.findAllByItem("TODAYMEALS");
	}
}
