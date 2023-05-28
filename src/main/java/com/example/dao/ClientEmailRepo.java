package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.ClientEmail;

@Repository
public interface ClientEmailRepo extends JpaRepository<ClientEmail, Integer> {

}
