package com.educacionIt.javase.KillaCoffee.web.dto;

public record AuthUsers(String userName) {
public boolean isValid() {
	return userName != null;
}
}
