package com.lt.client;

import java.sql.SQLException;
import java.time.LocalDateTime;

import java.util.Scanner;

import com.lt.DAO.AdminDAO;
import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.CourseDAO;
import com.lt.DAO.CourseDAOImpl;
//import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Course;

import com.lt.bean.User;
//import com.lt.business.AdminImplService;

import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.constants.SQLConstantQueries;

import com.lt.exception.CourseNotFoundException;

public class AdminClient {
	Scanner sc = new Scanner(System.in);

	public void adminMenu(Admin adminClientPage) throws SQLException {

		UserInterface admin = new UserImplService();
		CourseDAO courseDAO = new CourseDAOImpl();
		AdminDAO adminDAO = new AdminDAOImpl();
		Admin adminUser = new Admin();
		User user = new User();
		Course course = new Course();
		LocalDateTime localDateTime = LocalDateTime.now();

		/**
		 * Method to Create Admin Menu
		 */
		System.out.println("Succesfully logged in as ADMIN on " + localDateTime);
		while (true) {
			System.out.println(
					"**************************************Welcome to the Application as an ADMIN************************************");
			System.out.println(
					"****************************************************************************************************************");

			System.out.println("*****ADMIN MENU*****");
			System.out.println("Choose an Operation");
			System.out.println("********************");
			System.out.println("1. Create user");
			System.out.println("2. Update user");
			System.out.println("3. Delete user");
			System.out.println("4. Display users");
			System.out.println("5. Add course to Catalog");
			System.out.println("6. Delete course from Catalog");
			System.out.println("7. Logout");
			System.out.println("********************");
			Scanner sc = new Scanner(System.in);
			UserDAO userDao = new UserDAOImpl();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			System.out.println("Your choice is: " + choice);
			switch (choice) {
			case 1:

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
				// creating the admin
				adminDAO.createAdmin(adminUser);
				System.out.println("Thanks your User has been registred now in our Database");
				continue;

			case 2:

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
				// Updating the user
				userDao.updateUser(userId, user);
				System.out.println("updated user successfully");
				continue;

			case 3:

				System.out.println(("Enter UserId of user to be deleted"));
				System.out.println("Enter UserId");
				int userID = sc.nextInt();
				user.setUserId(userID);
				// Deleting the user
				userDao.deleteUser(userID, SQLConstantQueries.DELETE_USER);
				System.out.println("Admin with Id= " + userID + " deleted !");
				continue;

			case 4:

				admin.displayAdmins();
				continue;

			case 5:
				System.out.println("Enter catalogId");
				course.setCatalogId(sc.nextInt());
				System.out.println("Enter Course ID");
				int courseId = sc.nextInt();
				course.setCourseId(courseId);
				System.out.println("Enter Course Title");
				course.setCourseTitle(sc.next());
				System.out.println("Enter Course Description ");
				course.setCourseDescription(sc.next());
				System.out.println("Enter Semester");
				course.setSemester(sc.nextInt());
				System.out.println("Enter Branch ");
				course.setBranch(sc.next());
				System.out.println("Enter credits");
				course.setCredits(sc.nextInt());
				// course added in the database
				courseDAO.insertCourse(course);
				System.out.println("Course with Id= " + courseId + " added Successfully !");
				continue;

			case 6:
				System.out.println("Enter CourseId of course to be deleted");
				int courseIdToBeDeleted = sc.nextInt();
				// course deleted from database
				try {
					courseDAO.deleteCourse(courseIdToBeDeleted);
					System.out.println("Course with Id= " + courseIdToBeDeleted + " deleted Successfully !");

				} catch (CourseNotFoundException e) {
					System.out.println(e.getMessage());
				}
				continue;
			case 7:
				System.out.println("Succesfully logged out as on " + localDateTime);
				continue;

			default:
				System.out.println("********Wrong Choice********");
			}
			sc.close();
		}
	}

}
