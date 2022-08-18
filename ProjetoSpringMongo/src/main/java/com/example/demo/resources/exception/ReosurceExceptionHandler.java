package com.example.demo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exception.objectNotFoundException;

@ControllerAdvice
public class ReosurceExceptionHandler {
	
	@ExceptionHandler(objectNotFoundException.class)
	public ResponseEntity<StamdartError>objectNotFound(objectNotFoundException e , HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StamdartError err = new StamdartError(System.currentTimeMillis(), status.value(), "nao encontrado",e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
