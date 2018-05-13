package br.com.bjbraz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8196997378642661331L;

	public UserNotFoundException(String userId) {
		super("could not find user '" + userId + "'.");
	}
}
