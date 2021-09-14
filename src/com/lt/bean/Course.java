package com.lt.bean;

public class Course {

	private int courseId;
	private String courseName;
	private String courseDescription;
	private double courseFee;
	private long professorId;
	private long noOfStudent;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	public long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}
	public long getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(long noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	
}
