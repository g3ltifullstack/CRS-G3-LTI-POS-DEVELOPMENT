package com.lt.bean;

public class Student extends User {

	private int studentId;
	private String name;
	private String gender;
	private int phoneNumber;
	private int semester;
	private String branch;

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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", semester=" + semester + ", branch=" + branch + "]";
	}

	public Student(int studentId, String name, String gender, int phoneNumber, int semester, String branch) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.semester = semester;
		this.branch = branch;
	}

}
