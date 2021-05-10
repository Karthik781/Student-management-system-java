package com.sms.exception;

public class InvalidContactException extends RuntimeException {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Contact number has to be 10 digits.";
	}
	
}
