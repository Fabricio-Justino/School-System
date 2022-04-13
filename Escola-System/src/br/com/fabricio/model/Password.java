package br.com.fabricio.model;

import br.com.fabricio.runtime.exception.PasswordException;

public class Password {
	
	private final String password;
	
	public Password(String password) {
		validation(password);
		this.password = password;
	}
	
	public String get() {
		return this.password;
	}
	
	private void validation(String password) {
		String pattern = "(?=.*\\W)(?=.*\\d)(?=.*[a-zA-Z]).{8,}";
		if(!password.matches(pattern)) {
			String msg = "senha deve conter 8 digitos e (1 letra) - (1 número) - (1 caracter especial ex: {%, @, #})";
			throw new PasswordException(msg, new Throwable("password had a wrong format"));
		} 
	}
}
