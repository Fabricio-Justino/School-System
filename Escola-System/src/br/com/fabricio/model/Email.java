package br.com.fabricio.model;

import br.com.fabricio.runtime.exception.EmailException;

public class Email {
	private final String email;
	
	public Email(String email) {
		validation(email);
		this.email = email;
	}
	
	public String get() {
		return email;
	}
	
	private void validation(String email) {
		String pattern = "^[0-9a-zA-Z.].+@[a-z].+.com";
		if(!email.matches(pattern)) {
			String msg = "e-mail está com formato inválido";
			throw new EmailException(msg);
		}
	}
}
