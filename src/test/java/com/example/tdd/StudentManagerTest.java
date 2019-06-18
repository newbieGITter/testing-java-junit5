package com.example.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentManagerTest {

	private StudentManager manager;

	@BeforeEach
	public void setup() {
		manager = new StudentManager();
	}

	@Test
	public void addOneStudent() {
		// Given
		Student student = givenStudent(1l, "Jack");

		// When
		manager.addStudent(student);

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(1);
	}

	@Test
	public void addMultipleStudents() {
		// Given
		Student jack = givenStudent(1l, "Jack");
		Student mark = givenStudent(2l, "Mark");
		Student tim = givenStudent(3l, "Tim");

		// When
		manager.addStudent(jack);
		manager.addStudent(mark);
		manager.addStudent(tim);

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(3);
		Assertions.assertThat(manager.getStudents().get(0).getName()).isEqualTo("Jack");
		Assertions.assertThat(manager.getStudents().get(1).getName()).isEqualTo("Mark");
		Assertions.assertThat(manager.getStudents().get(2).getName()).isEqualTo("Tim");
	}

	@Test
	public void removeOneStudent_fromMultipleStudentsList() {
		// Given
		Student jack = givenStudent(1l, "Jack");
		Student mark = givenStudent(2l, "Mark");
		Student tim = givenStudent(3l, "Tim");

		manager.addStudent(jack);
		manager.addStudent(mark);
		manager.addStudent(tim);

		// When
		manager.removeStudent("Mark");

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(2);
		Assertions.assertThat(manager.getStudents().get(0).getName()).isEqualTo("Jack");
		Assertions.assertThat(manager.getStudents().get(1).getName()).isEqualTo("Tim");
	}

	@Test
	public void removeFirstStudent_fromMultipleStudentList() {
		// Given
		Student jack = givenStudent(1l, "Jack");
		Student mark = givenStudent(2l, "Mark");
		Student tim = givenStudent(3l, "Tim");

		manager.addStudent(jack);
		manager.addStudent(mark);
		manager.addStudent(tim);

		// When
		manager.removeStudent("Jack");

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(2);
		Assertions.assertThat(manager.getStudents().get(0).getName()).isEqualTo("Mark");
		Assertions.assertThat(manager.getStudents().get(1).getName()).isEqualTo("Tim");
	}

	@Test
	public void removeMoreThan1Student_fromMultipleStudentsList() {
		// Given
		Student jack = givenStudent(1l, "Jack");
		Student mark = givenStudent(2l, "Mark");
		Student tim = givenStudent(3l, "Tim");

		manager.addStudent(jack);
		manager.addStudent(mark);
		manager.addStudent(tim);

		// When
		manager.removeStudent("Jack", "Tim");

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(1);
		Assertions.assertThat(manager.getStudents().get(0).getName()).isEqualTo("Mark");
	}

	@Test
	public void removeAllStudents_fromMultipleStudentsList() {
		// Given
		Student jack = givenStudent(1l, "Jack");
		Student mark = givenStudent(2l, "Mark");
		Student tim = givenStudent(3l, "Tim");

		manager.addStudent(jack);
		manager.addStudent(mark);
		manager.addStudent(tim);

		// When
		manager.removeStudent("Tim", "Jack", "Mark");

		// Then
		Assertions.assertThat(manager.getStudents().size()).isEqualTo(0);
	}

	private Student givenStudent(long id, String name) {
		return new Student(id, name);
	}

}
