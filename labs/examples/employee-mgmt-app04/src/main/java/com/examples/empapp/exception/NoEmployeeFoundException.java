package com.examples.empapp.exception;

public class NoEmployeeFoundException extends Exception {

	private static final long serialVersionUID = -7277394574176420043L;
	
	public NoEmployeeFoundException()
	{
		super();
	}
	
	public NoEmployeeFoundException(String message)
	{
		super(message);
	}
	
	public NoEmployeeFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
