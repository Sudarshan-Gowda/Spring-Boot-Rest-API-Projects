package com.star.sud.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 7352892799153131604L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
