package br.com.fabricio.util;

import br.com.fabricio.model.Email;
import br.com.fabricio.model.Password;

public interface Logable {

	public void setEmail(String email);

	public void setPassword(String password);
	
	public Email getEmail();
	
	public Password getPassword();
	
	public String changePassword(String password, String lastPassword);
	
	public String changeEmail(String email, String passWord);
	
	// default methods 
	
	public default void changeLogin(String password, String email, String lastPassword) {
		changeEmail(email, lastPassword);
		changePassword(password, lastPassword);
	}
}
