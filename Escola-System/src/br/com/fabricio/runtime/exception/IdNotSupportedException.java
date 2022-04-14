package br.com.fabricio.runtime.exception;

public class IdNotSupportedException extends RuntimeException{	
	private static final long serialVersionUID = 1L;
	
	public IdNotSupportedException() {
		super("this id is not supported", new Throwable("try to put an invalid id"));
	}
	
	public IdNotSupportedException(String msg) {
		super(msg);
	}
	
	public IdNotSupportedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
	

