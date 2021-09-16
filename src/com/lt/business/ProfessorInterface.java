package com.lt.business;

import java.util.List;

import com.lt.bean.Professor;
import com.lt.bean.Student;

public interface ProfessorInterface {
	
	public void provideGrade(int studentid,Student student);
	public List<Student> displayRegisteredStudent();
	public void selectCourse(int courseId ,Professor professor);
	public void displaySelectedCoursesProfessor(Professor professor);



}
