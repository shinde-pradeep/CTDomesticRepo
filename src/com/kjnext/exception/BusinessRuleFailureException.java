/**
 * 
 */
package com.kjnext.exception;

import org.apache.log4j.Logger;

/**
 * @author kiran
 *
 */
public class BusinessRuleFailureException extends BusinessException {
	
	private static final long serialVersionUID = 205L;
	private static Logger logger = Logger.getLogger(BusinessRuleFailureException.class);
	private String[] messages = null;

	public BusinessRuleFailureException() {
		
	}

	public BusinessRuleFailureException(String message) {
		super(message);
		logger.error(message, this);
	}

	public BusinessRuleFailureException(Throwable cause) {
		//super(cause);
		logger.error(cause.getMessage(), this);
	}

	public BusinessRuleFailureException(String message, Throwable cause) {
		//super(message, cause);
		logger.error(message, this);
	}
	
	public BusinessRuleFailureException(String[] messageList) {
		//super(message);
		setMessages(messageList);
		for (int count=0; count<messageList.length; count++) {
			logger.error(messageList[count]);
		}
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
