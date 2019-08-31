package com.example.microservices.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.microservices.demo.entity.Account;
import com.example.microservices.demo.service.AccountService;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
	}
	
	private void initData() {
		Account account1 = new Account("100-10000", 0.0d); 
		account1 = this.accountService.saveAccount(account1);
		
		Account account2 = new Account("100-10001", 1000.0d); 
		account2 = this.accountService.saveAccount(account2);
	}
}
