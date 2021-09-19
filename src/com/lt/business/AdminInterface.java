package com.lt.business;

import java.io.IOException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.exception.StudentNotFoundForApprovalException;

public interface AdminInterface {
	public void addProfessor(); //addCourseCatalog() 
	public void generateReportCard(); 
	public void addCourse();
	public void dropCourse();
	public List<Course> publishResult() throws IOException;
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException;
	public List<Student> displayAwaitingAdmissionOfStudents();

}
