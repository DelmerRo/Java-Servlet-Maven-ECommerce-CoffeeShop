package com.educacionIt.javase.KillaCoffee.model.dao;

import com.educacionIt.javase.KillaCoffee.exception.UserNotFoundException;
import com.educacionIt.javase.KillaCoffee.model.entity.User;

public interface UserDao {
	boolean create(User user);

	User findByUserName(String userName)throws UserNotFoundException;
}
