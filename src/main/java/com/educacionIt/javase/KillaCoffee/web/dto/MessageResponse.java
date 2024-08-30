package com.educacionIt.javase.KillaCoffee.web.dto;

public record MessageResponse(String message, boolean error) {
public boolean isError() {
	return error;
}
}
