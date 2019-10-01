package com.example.microservices.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** temp **/
@Component
public class IamSecurityManager {
	private String clientSecret;
	
	private static String accessToken;
	private static String refreshToken;


	public String getClientSecret() {
		return clientSecret;
	}

	@Value("${keycloak.credentials.secret}")
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void printSecret() {
		System.out.println("The secret : " + clientSecret);
	}
}
