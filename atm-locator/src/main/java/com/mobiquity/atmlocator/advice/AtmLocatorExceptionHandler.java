package com.mobiquity.atmlocator.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This is a global exception class,when ever exception occurs in our application,
 * send information to client
 * @author tbabu
 *
 */
@RestControllerAdvice
public class AtmLocatorExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> methodArgumentNotValidException(Exception ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
