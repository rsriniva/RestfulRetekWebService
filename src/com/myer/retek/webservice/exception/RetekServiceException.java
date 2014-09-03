package com.myer.retek.webservice.exception;

/**
 * An application specific exception class used to wrap other exceptions.
 * 
 * @author Richard Riviere
 * @version 1.0.0
 * @since 27 Aug 2014
 */
public class RetekServiceException extends Exception {

	private static final long serialVersionUID = -9220290825294924298L;

	/**
	 * Create a RetekServiceException with a message.
	 * 
	 * @param message
	 */
	public RetekServiceException(String message) {
		super(message);
	}
	
	/**
	 * Create a RetekServiceException with a message and throwable.
	 * 
	 * @param message
	 * @param cause
	 */
	public RetekServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	          
}
