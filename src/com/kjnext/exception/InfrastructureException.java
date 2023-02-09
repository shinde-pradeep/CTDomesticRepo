package com.kjnext.exception;


/**
 * This exception is used to mark (fatal) failures in infrastructure 
 * and system code.
 *
 * @author kiran
 */
public class InfrastructureException extends RuntimeException {
	
	private static final long serialVersionUID = 208L;

	public InfrastructureException() {
	}

	public InfrastructureException(String message) {
		super(message);
	}

	public InfrastructureException(String message, Throwable cause) {
		super(message, cause);
	}

	public InfrastructureException(Throwable cause) {
		super(cause);
	}
}
