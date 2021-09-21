package com.lt.business;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.DAO.AdminDAO;
import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Student;
import com.lt.bean.User;

public class UserImplService extends User implements UserInterface {
	User user = new User();
	UserDAO userDao = new UserDAOImpl();
	private static Logger logger = Logger.getLogger(UserImplService.class);

	Student student;

	@Override
	public User validateUser(String username, String password) {
		logger.info("*******Validating the User********");
		User user = userDao.validateUser(username, password);
		if (user == null)
			logger.info("No user Found!!");
		return user;

	}

	@Override
	public Admin fetchAdmin(int adminId) {
		AdminDAO adminDAO = new AdminDAOImpl();
		return adminDAO.fetchAdmin(adminId);
	}

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
			System.out.println(String.format("%-15d | %-15s | % -15d\n", admin.getAdminId(), admin.getName(),
					admin.getPhoneNumber()));

		}
		logger.info("***********************************************");

	}

}
