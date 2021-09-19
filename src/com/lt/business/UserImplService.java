package com.lt.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.NotificationType;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.jdbc.AdminJdbc;

public class UserImplService extends User implements UserInterface {
	User user = new User();
	UserDAO userDao = new UserDAOImpl();
	private static Logger logger = Logger.getLogger(UserImplService.class);
	AdminInterface admin = new AdminImplService();

	Student student;

	@Override
	public User validateUser(String username, String password) { // bh bh
		logger.debug("Manage User--->>");
		User user = userDao.validateUser(username, password); // bh bh
		if (user == null)
			logger.info("No user Found!!");
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

////business logic separately and data separately ..client layer limit
//	@Override
//	public void displayStudents() {
//		logger.info("display student method");
//		StudentDAO studentDAO = new StudentDAO();
//		studentDAO.signUpStudent(student);
//	}

	@Override
	public void displayProfessors() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void signUp() {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter userID");
//		int userId = sc.nextInt();
//
//		System.out.println("Enter userName");
//		String userName = sc.next();
//
//		System.out.println("Enter password");
//		String password = sc.next();
//		System.out.println("Reached-->>");
//		if (userId != 0 && userName != null && password != null) {
//			System.out.println("Got it");
//			user.setUserId(userId);
//			user.setUserName(userName);
//			user.setUserPassword(password);
//			logger.info("end reached");
//
//		}
//		System.out.println("limit");
//		sc.close();
//
//	}

	@Override
	public void login() {
		logger.info("Enter userName");
		Scanner sc = new Scanner(System.in);
		String userName = sc.next();
		logger.info("Enter password");
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

	// display details of all admins
	@Override
	public void displayAdmins() {
		logger.info("**************LIST OF ADMINS****************");

		List<Admin> admins = userDao.displayAdmins();

		admins.stream().forEach(user -> {
			if (user.getGender().equals("M"))
				user.setName("Mr " + user.getName());
			else
				user.setName("Ms " + user.getName());
		});
		System.out.println("USER ID          NAME          PHONE NUMBER      ");
		for (Admin admin : admins) {
			logger.info(String.format("%-15d | %-15s | % -15d\n", admin.getAdminId(), admin.getName(),
					admin.getPhoneNumber()));

		}
		logger.info("***********************************************");

	}

	@Override
	public void displayStudents() {
		// TODO Auto-generated method stub
		
	}

}
