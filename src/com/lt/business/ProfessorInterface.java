package com.lt.business;

import java.util.List;

import com.lt.bean.Professor;
import com.lt.bean.Student;

public interface ProfessorInterface {
	public void selectCourse(int courseId, Professor professor);

	public void viewCourse(Professor professor);

	public List<Student> displayRegisteredStudent();

}
