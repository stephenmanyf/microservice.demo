package com.example.microservices.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.demo.entity.Account;
import com.example.microservices.demo.repository.AccountRepo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AccountService {
	@Autowired
	private AccountRepo accountRepo;
	
	public Optional<Account> getAccountByAccountNo(String accountNo) {
		return accountRepo.findByAccountNo(accountNo);
	}
	
	public Optional<Account> getAccountById(long id) {
		return accountRepo.findById(id);
	}
	
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}
}
