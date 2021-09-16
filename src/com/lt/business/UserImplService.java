package com.lt.business;

import java.util.Scanner;

import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.jdbc.AdminJdbc;

public class UserImplService extends User implements UserInterface {
	User user = new User();
	UserDAO userDao = new UserDAOImpl();

	Student student;

	@Override
	public User validateUser(String username, String password) { // bh bh
		System.out.println("Manage User--->>");
		User user = userDao.validateUser(username, password); //bh bh
		if (user == null)
			System.out.println("No user Found!!");
		return user;

	}

	@Override
	public Student fetchStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin fetchAdmin(int adminId) {
		AdminJdbc adminjdbc = new AdminJdbc();
		return adminjdbc.fetchAdmin(adminId);
	}

	@Override
	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

//business logic separately and data separately ..client layer limit
	@Override
	public void displayStudents() {
		System.out.println("display student method");
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.signUpStudent(student);
	}

	@Override
	public void displayProfessors() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAdmins() {
		// TODO Auto-generated method stub

	}

	@Override
	public void signUp() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter userID");
		int userId = sc.nextInt();

		System.out.println("Enter userName");
		String userName = sc.next();

		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("Reached-->>");
		if (userId != 0 && userName != null && password != null) {
			System.out.println("Got it");
			user.setUserId(userId);
			user.setUserName(userName);
			user.setUserPassword(password);
			System.out.println("end reached");

		}
		System.out.println("limit");
		sc.close();

	}

	@Override
	public void login() {
		System.out.println("Enter userName");
		Scanner sc = new Scanner(System.in);
		String userName = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		if (userName != null && password != null) {
			user.setUserName(userName);
			user.setUserPassword(password);

		}
		sc.close();

	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);

	}

	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAdmin(int adminId, Admin admin) {
		// TODO Auto-generated method stub

	}

}
