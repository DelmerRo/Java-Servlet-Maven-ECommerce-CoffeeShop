package com.educacionIt.javase.KillaCoffee.service.impl;

import com.educacionIt.javase.KillaCoffee.model.dao.UserDao;
import com.educacionIt.javase.KillaCoffee.model.dao.impl.UserDaoImpl;
import com.educacionIt.javase.KillaCoffee.model.entity.User;
import com.educacionIt.javase.KillaCoffee.service.UserAuthenticationService;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserAuthenticationServiceImpl implements UserAuthenticationService{

	private final UserDao userDao;
	
	public UserAuthenticationServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public void signup(String userName, String password) {
		String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		User newUser = new User(userName, hashedPassword);
		userDao.create(newUser);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		try {
			User user = userDao.findByUserName(userName);
			return BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()) != null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
