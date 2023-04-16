package com.amol.bank.customexception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExistException {

	private String messege;
	private Throwable throwable;
	private HttpStatus httpStatus;
	
}
