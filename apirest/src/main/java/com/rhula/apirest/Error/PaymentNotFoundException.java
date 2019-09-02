package com.rhula.apirest.Error;

public class PaymentNotFoundException extends RuntimeException{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Payment Not Found Exception
	 */

	    public PaymentNotFoundException(String message) {
	        super(message);
	    }
	}



