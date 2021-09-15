package com.lt.business;

import java.util.Scanner;

import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;

public class UserImplService extends User implements UserInterface {
	User user = new User();
	Student student;

	@Override
	public User manageUser(String username, String password) {
		System.out.println("Manage User--->>");
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
//		List<Student> list = new ArrayList<>();
//		System.out.println("Adding List of Students");
//		list.add(new Student(101, "Biswarup", "m", 101, 1, "cse"));
//		list.add(new Student(102, "Akshay", "m", 102, 2, "cse"));
//		list.add(new Student(103, "Akhilesh", "m", 103, 3, "cse"));
//		list.add(new Student(104, "Nikita", "f", 104, 4, "cse"));
//		list.add(new Student(105, "Bhabani", "m", 105, 5, "mechanical"));
//		list.add(new Student(106, "Srinivas", "m", 106, 6, "mca"));
//		System.out.println("Print the List of Student Details : - > " + list);
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

	UserDAO userDao = new UserDAO();

	@Override
	public void createUser(User user) {
		userDao.createUser(user);

	}

}
