package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.ConfirmOrder;

@Repository
public interface ConfirmOrderRepo extends JpaRepository<ConfirmOrder, Integer>{

	public	List<ConfirmOrder> findAllByCustomerIdOrderByDataDesc(String customerId);

	@Query(value="select * from confirm_order where data like %:date% order by data desc",nativeQuery = true)
	public List<ConfirmOrder> findAllByData(@Param("date") String date);
	
}
