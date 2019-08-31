package com.example.microservices.demo.controller;

import java.util.List;

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
@RequestMapping("/v1")
public class AccountController {
	private static final Logger logger = LogManager.getLogger(AccountController.class);
//	private static final Logger logger = LogManager.getLogger("CONSOLE_JSON_APPENDER");
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable long id) {
		logger.debug("getAccountById - id: {}", () -> id);
		Account account = this.accountService.getAccountById(id).orElse(null);
		
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	private List<Account> getAllAccounts() {
		logger.debug("getAllAccounts");
		List<Account> result = this.accountService.getAllAccounts();
		return result;
	}
	
	@GetMapping
	public ResponseEntity<Object> getAccount(@RequestParam(name="accountNo", required=false) String accountNo) {
		logger.debug("getAccount - accountNo: {}", () -> accountNo);
		
		Object result;
		
		if (accountNo != null && accountNo != "") {
			result = this.getAccountByAccountNo(accountNo);
		} else {
			result = this.getAllAccounts();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	private Account getAccountByAccountNo(@RequestParam(name="accountNo") String accountNo) {
		logger.debug("getAccountByAccountNo - accountNo: {}", () -> accountNo);
		Account account = this.accountService.getAccountByAccountNo(accountNo).orElse(null);
		
		return account;
	}
	
	@PostMapping
	public ResponseEntity<Object> openAccount(@RequestBody Account account) {
		logger.debug("openAccount - account: {}", () -> account);
		
		Account result = this.accountService.saveAccount(account);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
