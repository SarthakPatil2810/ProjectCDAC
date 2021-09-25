package com.app.exc_handler;

import java.time.LocalDateTime;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custome_exception.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // to tell spring container following class contain centralized exception
					// handler methods;
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// how to tell sc that following method acts as the exception handling method
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		System.out.println("in handle Run time Exception " + e);
		ErrorResponse resp = new ErrorResponse("Something went wrong !!!!!!", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyDataException(EmptyResultDataAccessException e) {
		System.out.println("in handle  Exception " + e);
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleUserHandlingException(UserHandlingException e) {
		System.out.println("in handle user Handling Exception " + e);
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("in handle invalid meth args"); 
		System.out.println(ex.getBindingResult().getFieldErrors());
		StringBuilder sb = new StringBuilder("Validartion Errors :");
		ex.getBindingResult().getFieldErrors().forEach(e -> sb.append("  "+e.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(sb.toString(), LocalDateTime.now()));
	}

}
