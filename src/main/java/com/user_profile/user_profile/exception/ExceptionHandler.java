package com.user_profile.user_profile.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.user_profile.user_profile.dto.ExceptionResponse;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException ex, WebRequest web) {
		Instant time = Instant.now();
		String message = ex.getMessage();
		String path = web.getDescription(false);
		Integer status = HttpStatus.NO_CONTENT.value();
		return ResponseEntity.badRequest().body(new ExceptionResponse(time, message, path, status));
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistsException ex, WebRequest web) {
		Instant time = Instant.now();
		String message = ex.getMessage();
		String path = web.getDescription(false);
		Integer status = HttpStatus.BAD_REQUEST.value();
		return ResponseEntity.badRequest().body(new ExceptionResponse(time, message, path, status));
	}
}
