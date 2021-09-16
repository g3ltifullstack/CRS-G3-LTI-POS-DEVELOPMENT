package com.lt.client;

import java.util.Date;
import java.util.Scanner;

import com.lt.DAO.AdminDAO;
import com.lt.DAO.ProfessorDAO;
import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.jdbc.AdminJdbc;

public class AdminClient {

	public void adminMenu(Admin adminClientPage) {
		UserInterface admin = new UserImplService();
		Admin adminRole = new Admin();
		Date currentDate = new Date();
		// display contents of Admin client landing page
		System.out.println("Succesfully logged in as ADMIN on " + currentDate);

		System.out.println("Choose an option");
		System.out.println("1. Create user");
		System.out.println("2. Update user");
		System.out.println("3. Delete user");
		System.out.println("4. Approve user");

		System.out.println("5. Add a new Course");
		System.out.println("6. Delete Course");

		System.out.println("7. Display users");
		System.out.println("8. Logout");

		Scanner sc = new Scanner(System.in);
		UserDAO userDao = new UserDAOImpl();

		int choice = sc.nextInt();
		switch (choice) {
		// create a new user
		case 1:
			User user = new User();
			Admin adminUser = new Admin();
			// for creating we need inputs from user

			System.out.println("Enter adminid");
			int adminid = sc.nextInt();
			adminUser.setAdminId(adminid);
			System.out.println("Enter Name");
			adminUser.setName(sc.next());
			System.out.println("Enter Gender");
			adminUser.setGender(sc.next());
			System.out.println("Enter Phone number");
			adminUser.setPhoneNumber(sc.nextLong());
			System.out.println("Enter userid ");

			int userid = sc.nextInt();
			adminUser.setUserId(userid);
			System.out.println("Creating your User-> ");
			AdminJdbc adminJdbc1 = new AdminJdbc();

			adminJdbc1.createAdmin(adminUser);
			System.out.println("Thanks your User has been registred now in our Database");

			break;

//			// update an existing user
		case 2:
			user = new User();

			System.out.println("Enter UserId");
			int userId = sc.nextInt();
			user.setUserId(userId);
			System.out.println("Enter Username");
			user.setUserName(sc.next());
			System.out.println("Enter Password");
			user.setUserPassword(sc.next());
			System.out.println("Enter roleId");
			user.setRoleId(sc.nextInt());
			System.out.println("updating user");
			// update user
			userDao.updateUser(userId, user);
			System.out.println("updated user successfully");

		case 8:
			System.out.println("Succesfully logged out as on " + currentDate);
			break;
		}
		sc.close();

	}

}
