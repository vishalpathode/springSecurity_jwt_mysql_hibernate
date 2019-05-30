package com.pro.jwt.JwtSpringsecurity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.pro.jwt.JwtSpringsecurity.domain.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<Response> handleRuntinmeException(RuntimeException r){
		
		return new ResponseEntity<Response>(new Response(r.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString()),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {Forbidden.class})
	public ResponseEntity<Response> handleForbiddenException(Forbidden f){
		
		return new ResponseEntity<Response>(new Response(f.getMessage(),HttpStatus.FORBIDDEN.toString()),HttpStatus.FORBIDDEN);
	}
}
