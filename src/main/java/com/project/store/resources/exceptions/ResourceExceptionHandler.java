package com.project.store.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.store.services.exceptions.DatabaseException;
import com.project.store.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND; 
		StandardError httpError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(httpError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request){
		String error = "Database Error";
		HttpStatus status = HttpStatus.BAD_REQUEST; 
		StandardError httpError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(httpError);
	}
}
