package com.example.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManager {

	private List<Student> students = new ArrayList<>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(String... names) {
		// This does not work when we want to remove first element from the
		// list.
		// for (Student stu : students) {
		// if(stu.getName().equalsIgnoreCase(name)){
		// students.remove(stu);
		// }
		// }

		// So we should use Iterator when we want to remove an element while
		// iterating
		for (String name : names) {
			Iterator<Student> it = students.iterator();
			while (it.hasNext()) {
				if (it.next().getName().equalsIgnoreCase(name)) {
					it.remove();
				}
			}

		}
	}

}
