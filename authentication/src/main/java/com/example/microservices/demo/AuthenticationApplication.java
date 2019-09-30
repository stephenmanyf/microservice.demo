package com.example.microservices.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationApplication {

	@PostConstruct
	void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Hong_Kong"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
