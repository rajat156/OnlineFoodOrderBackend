package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

	public List<Client> findAllByCustomerId(String customerId);

}
