package com051.crudoperation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidEmpException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidEmpException() {
		this.message = "";
	}

	public InvalidEmpException(String message) {
		super();
		this.message = message;
	}


	@Override
	public String toString() {
		return "Invalid Emp ID: "+this.message;
	}

}
