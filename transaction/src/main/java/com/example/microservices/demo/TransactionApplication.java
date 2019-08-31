package com.example.microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.microservices.demo.entity.Transaction;
import com.example.microservices.demo.service.TransactionService;

@SpringBootApplication
public class TransactionApplication implements CommandLineRunner {

	@Autowired
	private TransactionService txService;
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
	}

	private void initData() {
		Transaction tx = new Transaction(null, 0L, 1L, 1000.0d, "HKD");
		this.txService.addTransaction(tx);
	}
}
