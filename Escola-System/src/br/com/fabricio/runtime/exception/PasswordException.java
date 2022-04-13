package br.com.fabricio.runtime.exception;

public class PasswordException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PasswordException() {
		super("password was denied", new Throwable("supplied password is incorrect"));
	}
	
	public PasswordException(String msg) {
		super(msg);
	}
	
	public PasswordException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
