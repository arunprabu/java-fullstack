package com.examples.empapp.exception;

public class LoginException extends RuntimeException {
	private String errorMsg;

	public LoginException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
