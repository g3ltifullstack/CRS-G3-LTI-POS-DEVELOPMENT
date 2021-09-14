package com.lt.bean;

public class Professor extends User {

	private int professorId;
	private String professorName;
	private String department;

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Professor() {
		super();
	}

	public Professor(int professorId, String professorName, String department) {
		super();
		this.professorId = professorId;
		this.professorName = professorName;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", professorName=" + professorName + ", department="
				+ department + "]";
	}

}
