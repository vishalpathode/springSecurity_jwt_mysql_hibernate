package com.pro.jwt.JwtSpringsecurity.domain;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -942141428228473433L;
	
	private String message;
	private String status;
	
	public Response(String message, String internalServerError) {
		super();
		this.message = message;
		this.status = internalServerError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
