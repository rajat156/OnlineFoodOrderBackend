package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.TodayDeals;

@Repository
public interface TodayDealsRepo extends JpaRepository<TodayDeals, Integer>{

}
