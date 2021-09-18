package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.DAO.ProfessorDaoImpl;
import com.lt.DAO.ProfessorDaoInterface;
import com.lt.DAO.StudentDAO;

import com.lt.DAO.UserDaoImpl;
import com.lt.DAO.UserDaoInterface;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.ProfessorClient;


public class UserImplService extends User implements UserInterface {
	private static Logger logger = Logger.getLogger(UserImplService.class);
	User user = new User();
	Student student;
	UserDaoInterface userdao1=new UserDaoImpl();

	@Override
	public User manageUser(String username, String password) {
		logger.debug("Manage User--->>");
		if (username != null && password != null) {
			System.out.println("Set Username:->");
			user.setUserName(username);
			System.out.println("Set Password:->");
			user.setUserPassword(password);
		}
		return user;
	}

	@Override
	public Student fetchStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin fetchAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}
UserDaoInterface userdao=new UserDaoImpl();
	@Override
	public Professor fetchProfessor(int professorId) {
		return userdao1.fetchProfessor(professorId);
		}
	

//business logic separately and data separately ..client layer limit
	@Override
	public void displayStudents() {
		System.out.println("display student method");
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.signUpStudent(student);
//		
	}
	ProfessorDaoInterface prfd= new ProfessorDaoImpl(); 
	@Override
	public void displayProfessors() {
		
		List<Professor> professors = prfd.professorDetails();

		professors.stream().forEach(professor -> {
			if(professor.getGender().equals("female"))
				professor.setUserName("Ms "+ professor.getProfessorName() );
			else
				professor.setUserName("Mr "+ professor.getProfessorName() );
		});

		logger.info("PROFESSOR ID      NAME            PHONE NUMBER      DESIGNATION   ");
		for(Professor professor: professors) {
			System.out.println(professor.getProfessorId()+"         "+professor.getProfessorName()+"          "+professor.getGender()+"        "+professor.getDepartment()+" "+professor.getEmail());

		}
		
	}
	


	@Override
	public void displayAdmins() {
		// TODO Auto-generated method stub

	}

	@Override
	public void signUp() {
			}

	
	Professor professor=new Professor();
	ProfessorClient professorClient=new ProfessorClient(); 

	/*
	 * public void login() { System.out.println("Enter userName"); Scanner sc = new
	 * Scanner(System.in); String userName = sc.next();
	 * System.out.println("Enter password"); String password = sc.next(); if
	 * (userName != null && password != null) { user.setUserName(userName);
	 * user.setUserPassword(password);
	 * 
	 * } sc.close();
	 * 
	 * }
	 */

	@Override
	public void updateProfessor() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User validateUser(String userid, String password) {
		User user= userdao1.validateUser(userid, password)	;
		if(user==null)
			logger.debug("user not available");;
		return user;

	}


	
	

}
