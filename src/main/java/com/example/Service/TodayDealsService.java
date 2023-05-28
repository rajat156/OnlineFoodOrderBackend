package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.TodayDeals;
import com.example.dao.TodayDealsRepo;

@Service
public class TodayDealsService {

	@Autowired
	private TodayDealsRepo todayDealsRepo;
	
	public TodayDeals saveTodayDeals(TodayDeals todayDeals) {
		return this.todayDealsRepo.saveAndFlush(todayDeals);
	}
	
	public List<TodayDeals> getTodayDeals(){
		return this.todayDealsRepo.findAll();
	}
}
