package com.lt.business;

import java.util.List;

import com.lt.DAO.RegisterCourseDAOImpl;
import com.lt.DAO.RegisterCourseDAOInterface;
import com.lt.bean.Student;


public class SemisterRegisterationImplService implements SemisterRegisterationInterface  {

	RegisterCourseDAOInterface registrationDao= new RegisterCourseDAOImpl();

	// checks if student has selected exactly  4 courses or not
	public boolean checkCourseSelectionStatus(Student student) {
		return registrationDao.numberOfCoursesSelected(student);
	}

	// submit registration for student
	public void submitRegistration (Student student) {
		registrationDao.submitRegistration (student);
	}

	// generate student registration details and store them in database
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId){
		registrationDao.generateRegistrationReciept(student, payableAmount, payModeId);
	}

	// display studentID of students enrolled in a course
	public void displayRegisteredStudentsInCourse(int courseId){
		System.out.println("*********************STUDENTS ENROLLED******************************");	
		System.out.println("STUDENT ID");
		List<Integer> students = registrationDao.displayRegisteredStudentsInCourse(courseId);
		
		students.forEach(student -> System.out.println(student));

	}

}
