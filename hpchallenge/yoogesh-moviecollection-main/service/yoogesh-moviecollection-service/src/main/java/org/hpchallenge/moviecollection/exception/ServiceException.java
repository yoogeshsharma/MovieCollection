/**
 * 
 */
package org.hpchallenge.moviecollection.exception;

/**
 * A top-level exception for Service Layer
 * 
 * @author yoogesh.sharma
 *
 */
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable e){
		super(e);
	}
	
	public ServiceException(String message, Throwable e){
		//super(message , e);
	}
	
}
