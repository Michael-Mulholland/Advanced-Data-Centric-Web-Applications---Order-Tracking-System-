package com.sales.exceptions;

// https://mkyong.com/java/java-custom-exception-examples/

public class ErrorGreaterThanQuantity extends RuntimeException{

	// generated serial version ID
	private static final long serialVersionUID = -3950344764121374907L;

	public ErrorGreaterThanQuantity(String message){
		super(message);
	}
}
