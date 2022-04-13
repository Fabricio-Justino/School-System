package br.com.fabricio.util;

import java.util.Collection;

public interface StudentProtocol extends Comparable<StudentProtocol>, Logable{
	
	
	public void addgrade(TeacherProtocol teacher, double grade);
	
	public void addMatter(String matter);
	
	public void removeMatter(String matter);
	
	// getters
	
	public double getAverageGradeOf(String matter);
	
	public double getLowerGradOf(String matter);
	
	public double getHigherGradeOf(String matter);
	
	public long getId();
	
	public String getName();
	
	public Collection<Double> getGrade(String matter);
	
	// default methods
	
	@Override
	default int compareTo(StudentProtocol other) {
		return this.getName().compareTo(other.getName());
	}
	
}
