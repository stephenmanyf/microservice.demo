package com.example.microservices.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.demo.entity.Transaction;
import com.example.microservices.demo.service.TransactionService;

@RestController
@RequestMapping("/v1")
public class TransactionController {
	
	@Autowired
	private TransactionService txService;

	@PostMapping
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction tx) {
		Transaction result = txService.addTransaction(tx);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		return new ResponseEntity<>(this.txService.getAllTransactions(), HttpStatus.OK);
	}
}
