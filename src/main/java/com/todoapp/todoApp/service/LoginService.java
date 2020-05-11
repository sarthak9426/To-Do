package com.todoapp.todoApp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userId, String password)
	{
		return userId.equalsIgnoreCase("user") && password.equalsIgnoreCase("pass");
	}
}
