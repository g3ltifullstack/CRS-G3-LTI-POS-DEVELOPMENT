package com.lt.business;

import java.io.IOException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.StudentNotFoundForApprovalException;

public interface AdminInterface {
	public void addProfessor(); //addCourseCatalog() 
	public void generateReportCard(); 
	public List<Course> publishResult() throws IOException;
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException;
	public List<Student> displayAwaitingAdmissionOfStudents();
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @param courseList : Courses available in the catalog
	 * @throws CourseNotFoundException 
	 * @throws CourseNotDeletedException 
	 */
	public void deleteCourse(String courseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 * @param courseList : Courses available in the catalog
	 */
	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException;

	/**
	 * Method to get list of courses in catalog
	 * @param catalogId
	 * @return List of courses in catalog
	 */
	public List<Course> viewCourses();

}
