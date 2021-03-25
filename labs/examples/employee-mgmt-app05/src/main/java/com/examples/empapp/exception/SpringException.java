package com.examples.empapp.exception;

public class SpringException extends RuntimeException {
	private String errorMsg;

	public SpringException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
