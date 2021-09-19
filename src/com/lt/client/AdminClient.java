package com.lt.client;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
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
import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.NotificationImplService;
import com.lt.business.NotificationInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.constants.NotificationType;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.jdbc.AdminJdbc;

public class AdminClient {

	public void adminMenu(Admin adminClientPage) throws SQLException {
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
		System.out.println("5. Display users");
		System.out.println("6. Logout");

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
			// delete the user
		case 3:
			user = new User();

			System.out.println(("Enter UserId of user to be deleted"));
			System.out.println("Enter UserId");
			int userID = sc.nextInt();
			user.setUserId(userID);
			userDao.deleteUser(userID, SQLConstantQueries.DELETE_USER);
			System.out.println("Admin with Id= " + userID + " deleted !");

			break;
		case 4:

			approveStudent();
			break;
		// view user details
		case 5:
			// view admin details
			admin.displayAdmins();
			break;

		case 6:
			System.out.println("Succesfully logged out as on " + currentDate);
			break;
		}
		
		sc.close();

	}

	
	public List<Student> displayAwaitingAdmissionOfStudents() {
		AdminInterface adminInterface = new AdminImplService();

		List<Student> pendingStudentsList = adminInterface.displayAwaitingAdmissionOfStudents();
		if (pendingStudentsList.size() == 0) {
			return pendingStudentsList;
		}
		System.out.println(String.format("% 20s |% 20s |% 20s |% 20s", "UserId", "StudentId", "Name", "Gender"));
		for (Student student : pendingStudentsList) {
			System.out.println(String.format("% 20s |% 20d |% 20s |% 20s", student.getUserId(), student.getStudentId(),
					student.getName(), student.getGender().toString()));
		}
		return pendingStudentsList;
	}

	// Method to approve a Student using Student's ID

	
	public void approveStudent() throws SQLException {
		AdminInterface adminInterface = new AdminImplService();


		List<Student> studentList = displayAwaitingAdmissionOfStudents();
		if (studentList.size() == 0) {
			return;
		}
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student's ID:");
		int studentUserIdApproval = sc.nextInt();
		NotificationInterface notification = new NotificationImplService();
		try {
			adminInterface.approveStudent(studentUserIdApproval, studentList);
			// send notification from system
			notification.sendNotification(NotificationType.REGISTRATION_APPROVAL, studentUserIdApproval, null, 0);

		} catch (StudentNotFoundForApprovalException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}


}
