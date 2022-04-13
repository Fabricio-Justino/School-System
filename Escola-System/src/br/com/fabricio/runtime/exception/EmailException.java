package br.com.fabricio.runtime.exception;

public class EmailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmailException() {
		super("email was denied", new Throwable("supplied email is incorrect"));
	}
	
	public EmailException(String msg) {
		super(msg);
	}
	
	public EmailException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
