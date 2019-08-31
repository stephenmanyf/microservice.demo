package com.example.microservices.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.demo.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
}
