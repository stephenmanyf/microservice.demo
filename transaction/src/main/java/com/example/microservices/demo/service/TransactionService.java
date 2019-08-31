package com.example.microservices.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.demo.entity.Transaction;
import com.example.microservices.demo.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo txRepo;
	
	public Optional<Transaction> getTransactionById(long id) {
		return this.txRepo.findById(id);
	}
	
	public Transaction addTransaction(Transaction tx) {
		if (tx.getId() != null) {
			throw new IllegalArgumentException("Transaction ID is not empty.");
		}
		return this.txRepo.save(tx);
	}
	
	public Transaction updateTransaction(Transaction tx) {
		if (tx.getId() == null) {
			throw new IllegalArgumentException("Transaction ID is empty");
		}
		return this.txRepo.save(tx);
	}
	
	public void removeTransaction(Transaction tx) {
		if (tx.getId() == null) {
			throw new IllegalArgumentException("Transaction ID is empty");
		}
		
		this.txRepo.deleteById(tx.getId());
	}
	
	public List<Transaction> getAllTransactions() {
		return this.txRepo.findAll();
	}
}
