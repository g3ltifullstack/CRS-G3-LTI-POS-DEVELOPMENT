package com.lt.business;

import com.lt.bean.Student;

public interface SemisterRegisterationInterface {
	
public void submitRegistration (Student student);
	
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public void displayRegisteredStudentsInCourse(int courseId);


}
