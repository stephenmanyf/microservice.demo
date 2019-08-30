package com.example.microservices.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.demo.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	public Optional<Account> findByAccountNo(String accountNo);
}
