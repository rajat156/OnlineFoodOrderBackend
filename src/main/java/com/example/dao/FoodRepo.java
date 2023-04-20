package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Entity.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer>{

	public List<Food> findAllByItem(String item);

	@Query(value="select * from Food where food_name like %:f%",nativeQuery = true)
	public List<Food> searchRecord(@Param("f") String food);

}
