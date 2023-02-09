package com.kjnext.exception;

// Log4J Imports
import org.apache.log4j.Logger;

/**
 * Exception Class to handle all exceptions where object does 
 * not exists match the given user criteria.
 * 
 * @author kiran
 */
public class ObjectNotFoundException extends Exception {
	
	private static final long serialVersionUID = 10222426500001L;

	private static Logger logger = Logger.getLogger("ObjectNotFoundException.class");

	public ObjectNotFoundException() {
		
	}

	public ObjectNotFoundException(String message) {
		super(message);
		logger.error(message, this);
	}

	public ObjectNotFoundException(Throwable cause) {
		super(cause);
		logger.error(cause.getMessage(), this);
	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		logger.error(message, this);
	}
	
	
	
	
}
