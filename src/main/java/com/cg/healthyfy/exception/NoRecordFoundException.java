package com.cg.healthyfy.exception;

public class NoRecordFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * Create NoRecordFoundException object without error message
	 */
	/**
	 * Create NoRecordFoundException object with error message
	 */
	 public NoRecordFoundException(String errMsg){
		super(errMsg);
	}
}
