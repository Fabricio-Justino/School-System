package br.com.fabricio.util;

public interface Identifiable<T> {
	
	public T getId();
	
	public T idValidation(T id);
	
	public void setId(T id);
}
