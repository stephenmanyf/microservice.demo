package com.example.microservices.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.demo.entity.Account;
import com.example.microservices.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	private static final Logger logger = LogManager.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable long id) {
		logger.debug("getAccountById - id: {}", () -> id);
		Account account = this.accountService.getAccountById(id).orElse(null);
		
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Account> getAccountByAccountNo(@RequestParam(name="accountNo") String accountNo) {
		logger.debug("getAccountByAccountNo - accountNo: {}", () -> accountNo);
		Account account = this.accountService.getAccountByAccountNo(accountNo).orElse(null);
		
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> openAccount(@RequestBody Account account) {
		logger.debug("openAccount - account: {}", () -> account);
		
		Account result = this.accountService.saveAccount(account);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
