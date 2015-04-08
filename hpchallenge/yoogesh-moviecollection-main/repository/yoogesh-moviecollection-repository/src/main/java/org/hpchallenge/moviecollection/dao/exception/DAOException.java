/**
 * 
 */
package org.hpchallenge.moviecollection.dao.exception;

/**
 * A top level custom exception for DAO layer
 *  
 * @author yoogesh.sharma
 * @since 1.0
 *
 */
public class DAOException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Throwable e){
		super(e);
	}
	
	public DAOException(String message , Throwable e){
		super(message, e);
	}


}
