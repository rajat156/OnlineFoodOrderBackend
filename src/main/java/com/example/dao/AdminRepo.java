package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
