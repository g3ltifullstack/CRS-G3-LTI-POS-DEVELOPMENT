package com.lt.bean;

public class Course {

	private int courseId;
	private String courseTitle;
	private String courseDescription;
	private String branch;
	private int credits;

	private int catalogId;
	private int semester;

	/**
	 * Default Constructor
	 */
	public Course() {

	}

	/**
	 * Parameterized constructor
	 */

	public Course(int courseId, String courseTitle, String courseDescription, String branch, int credits, int catalogId,
			int semester) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
		this.branch = branch;
		this.credits = credits;
		this.catalogId = catalogId;
		this.semester = semester;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

}
