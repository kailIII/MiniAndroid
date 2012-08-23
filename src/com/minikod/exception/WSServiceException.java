package com.minikod.exception;

public class WSServiceException extends Exception {

	private static final long serialVersionUID = -1350545448779887303L;

	public WSServiceException() {

	}

	public WSServiceException(String message) {
		super(message);
	}

	public WSServiceException(Throwable exception) {
		super(exception);
	}

}
