package br.com.fabricio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fabricio.runtime.exception.IdNotSupportedException;
import br.com.fabricio.util.SchoolClassProtocol;
import br.com.fabricio.util.StudentProtocol;
import br.com.fabricio.util.TeacherProtocol;

public class SchoolClass implements SchoolClassProtocol {
	private String id;

	private List<StudentProtocol> students;
	private List<TeacherProtocol> teachers;

	public SchoolClass(String id) {
		this.id = idValidation(id);
		
		this.students = new ArrayList<>();
		this.teachers = new ArrayList<>();

	}

	public void addTeacher(TeacherProtocol teacher) {
		this.teachers.add(teacher);
		this.students.forEach(student -> student.addMatter(teacher.getMatter()));
	}

	public void addStudent(StudentProtocol student) {
		this.students.add(student);
		this.teachers.forEach(teacher -> student.addMatter(teacher.getMatter()));
	}

	// getters

	public String getId() {
		return this.id;
	}

	// setters

	@Override
	public void setId(String id) {
		if (this.id == null) {
			this.id = idValidation(id);
		}
	}

	// utils

	private Optional<TeacherProtocol> findTeacher(String matter) {
		return this.teachers.stream().filter(t -> t.getMatter().equals(matter)).findFirst();
	}

	private Optional<TeacherProtocol> findTeacher(TeacherProtocol teacher) {
		return this.teachers.stream().filter(t -> t.equals(teacher)).findFirst();
	}

	private Optional<StudentProtocol> findStudent(long id) {
		return this.students.stream().filter(s -> s.getId() == id).findFirst();
	}

	private Optional<StudentProtocol> findTeacher(StudentProtocol student) {
		return this.students.stream().filter(s -> s.equals(student)).findFirst();
	}

	@Override
	public String idValidation(String id) {
		if (id == null || id.isBlank())
			throw new IdNotSupportedException("id não pode ser em branco");
		return id;
	}

}
