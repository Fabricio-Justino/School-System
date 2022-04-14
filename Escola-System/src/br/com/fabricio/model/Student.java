package br.com.fabricio.model;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.fabricio.runtime.exception.IdNotSupportedException;
import br.com.fabricio.runtime.exception.MapException;
import br.com.fabricio.runtime.exception.PasswordException;
import br.com.fabricio.util.StudentProtocol;
import br.com.fabricio.util.TeacherProtocol;

public class Student implements StudentProtocol {
	private Long id;

	private Password password;
	private Email email;
	private String name;

	private Map<String, Set<Double>> grade;
	private Map<String, DoubleSummaryStatistics> statics;

	public Student(String name) {
		this.name = name;
		this.grade = new HashMap<>();
		this.statics = new HashMap<>();
	}

	// private methods

	private void updateSummary(String matter) {
		DoubleSummaryStatistics collect;
		collect = this.grade.get(matter).stream().collect(Collectors.summarizingDouble(Double::doubleValue));

		this.statics.put(matter, collect);
	}

	// override methods

	// getters

	@Override
	public double getAverageGradeOf(String matter) {
		return this.statics.get(matter).getAverage();
	}

	@Override
	public double getLowerGradOf(String matter) {
		return this.statics.get(matter).getMin();
	}

	@Override
	public double getHigherGradeOf(String matter) {
		return this.statics.get(matter).getMax();
	}

	@Override
	public Email getEmail() {
		return this.email;
	}

	@Override
	public Password getPassword() {
		return this.password;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Collection<Double> getGrade(String matter) {
		return this.grade.get(matter);
	}

	@Override
	public String getName() {
		return this.name;
	}

	// setters

	@Override
	public void setId(Long id) {
		if (this.id == null) {
			this.id = idValidation(id);
		}
	}

	@Override
	public void setPassword(String password) {
		if (this.password == null) {
			this.password = new Password(password);
		} else {
			throw new PasswordException("a senha já foi definida", new Throwable("try to set another password"));
		}
	}

	@Override
	public void setEmail(String email) {
		if (this.email == null) {
			this.email = new Email(email);
		} else {
			throw new IllegalAccessError("o e-mail já foi definido");
		}
	}

	// additions methods

	@Override
	public void addMatter(String matter) {
		if (!this.grade.containsKey(matter)) {
			this.grade.put(matter, new HashSet<>());
		}
	}

	@Override
	public void addgrade(TeacherProtocol teacher, double grade) {
		if (!this.grade.containsKey(teacher.getMatter())) {
			throw new MapException(String.format("%s não da aula para o/a %s", teacher, this));
		}
		this.grade.get(teacher.getMatter()).add(grade);
		this.updateSummary(teacher.getMatter());
	}

	// remove methods

	@Override
	public void removeMatter(String matter) {
		if (this.grade.containsKey(matter)) {
			this.grade.remove(matter);
		}
	}

	// logabl

	@Override
	public String changePassword(String password, String lastPassword) {
		if (lastPassword.equals(password))
			throw new PasswordException("a nova senha não pode ser igual a antiga");
		if (lastPassword.equals(this.password.get()))
			throw new PasswordException("senha incorreta");
		this.password = new Password(password);
		return password;
	}

	@Override
	public String changeEmail(String email, String password) {
		if (!password.equals(this.password.get()))
			throw new PasswordException("senha incorreta");

		this.email = new Email(email);
		return email;
	}

	// java lang override

	@Override
	public String toString() {
		return String.format("aluno: %s [%s] password: %s", this.getName(), this.getId(), getPassword().get());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StudentProtocol student) {
			return (this.getId() == student.getId()) && this.getName().equals(student.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() * Math.round(this.getId() / 2);
	}
	
	// utils
	
	@Override
	public Long idValidation(Long id) {
		if (id < 0) throw new IdNotSupportedException("id não pode ser negativo");
		
		return id;
	}

}
