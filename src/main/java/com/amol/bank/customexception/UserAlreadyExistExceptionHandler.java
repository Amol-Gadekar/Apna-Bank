package com.amol.bank.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAlreadyExistExceptionHandler {
	
	@ExceptionHandler(value = {UserAlreadyExistException.class})
	public ResponseEntity<Object> handleUserAlreadyExistException(
			UserAlreadyExistException userAlreadyExistException){
		
		UserExistException userExistException = new UserExistException(
				userAlreadyExistException.getMessage(),
				userAlreadyExistException.getCause(),
				HttpStatus.NOT_ACCEPTABLE);
		
		return new ResponseEntity<>(userExistException, HttpStatus.NOT_ACCEPTABLE);
		
	}
	
}
