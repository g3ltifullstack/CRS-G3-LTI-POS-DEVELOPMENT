package com.lt.bean;

/**
 * @author Biswarup
 *
 */
public class Student {

	private int studentId;
	private String name;
	private String gender;
	private int phoneNumber;
	private int semester;
	private String branch;
	private int userId;
	private boolean isApproved;

	/**
	 * @return user id
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return user id
	 */
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return phone number
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return semester
	 */
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	/**
	 * @return branch
	 */
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/**
	 * @return user id
	 */
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 * @param studentId
	 * @param name
	 * @param gender
	 * @param phoneNumber
	 * @param semester
	 * @param branch
	 * @param userId
	 * @param isApproved
	 */
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

	

	/**
	 * deafult constructor
	 */
	public Student() {
		super();
	}
}
