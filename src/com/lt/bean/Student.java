package com.lt.bean;

public class Student {

	private int studentId;
	private String name;
	private String gender;
	private int phoneNumber;
	private int semester;
	private String branch;
	private int userId;
	private boolean isApproved;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Student(int studentId, String name, String gender, int phoneNumber, int semester, String branch, int userId,
			boolean isApproved) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.semester = semester;
		this.branch = branch;
		this.userId = userId;
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", semester=" + semester + ", branch=" + branch + ", userId=" + userId + "]";
	}

	

	public Student() {
		super();
	}
}
