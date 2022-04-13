package br.com.fabricio.util.observer;

public interface Observer {
	
	public void subscribe(Observable observable);
	
	public Observable unsubscribe(Observable observable);
	
	public void notifyChanges(Object ...args);
}
