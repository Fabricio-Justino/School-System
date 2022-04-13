package br.com.fabricio.util;

import br.com.fabricio.model.SchoolClass;

public interface TeacherProtocol extends Comparable<TeacherProtocol>, Logable{
	
	// getters 
	
	public String getMatter();
	
	public String getName();
	
	// other methods
	
	public void giveGrade(SchoolClass sclass, StudentProtocol student, double grade);
	
	
	// default methods
	
	@Override
	default int compareTo(TeacherProtocol other) {
		return this.getName().compareTo(other.getName());
	}
}
