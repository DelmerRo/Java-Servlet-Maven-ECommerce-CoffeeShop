package com.educacionIt.javase.KillaCoffee.service;

public interface UserAuthenticationService {

	void signup(String userName, String password);

	boolean authenticateUser(String userName, String password);
}

