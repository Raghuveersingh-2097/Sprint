package com.cg.healthyfy.exception;

public class PaymentAmountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * Create PaymentAmountException object without error message
	 */
	/**
	 * Create PaymentAmountException object with error message
	 */
	 public PaymentAmountException(String errMsg){
		super(errMsg);
	}
}
