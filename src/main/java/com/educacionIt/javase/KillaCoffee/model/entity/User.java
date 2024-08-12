package com.educacionIt.javase.KillaCoffee.model.entity;

public class User {
private Long id;
private  String userName;
private String password;

public User(String userName, String password) {
	this.userName = userName;
	this.password = password;
}
public String getUserName() {
	return userName;
}

private void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

private void setPassword(String password) {
	this.password = password;
}

}
