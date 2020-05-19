package com.sales.exceptions;

// https://mkyong.com/java/java-custom-exception-examples/

public class ErrorNoCustProd extends RuntimeException{
	
	// generated serial version ID
	private static final long serialVersionUID = 3710641773388882251L;

	public ErrorNoCustProd(String message){
		super(message);
	}
}
