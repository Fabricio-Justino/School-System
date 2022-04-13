package br.com.fabricio.util;

import br.com.fabricio.model.Student;

public class Teste {
	
	private static void println(Object c) {
		System.out.println(c);
	}

	public static void main(String[] args) {
		Student fabricio = new Student("fabricio");
		fabricio.setPassword("kskaskdksdK1@");
		fabricio.setPassword("kskaskdksd1K@");
		println(fabricio);
	}

}
