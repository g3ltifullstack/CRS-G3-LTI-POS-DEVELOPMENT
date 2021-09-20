package com.lt.client;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lt.DAO.AdminDAO;
import com.lt.DAO.CourseDAO;
import com.lt.DAO.CourseDAOImpl;
//import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.ProfessorDAO;
import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.DAO.UserDAOImpl;
import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
//import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.NotificationImplService;
import com.lt.business.NotificationInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.constants.NotificationType;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.jdbc.AdminJdbc;

public class AdminClient {
	Scanner sc = new Scanner(System.in);

	public void adminMenu(Admin adminClientPage) throws SQLException {

		UserInterface admin = new UserImplService();
		Date currentDate = new Date();
		CourseDAO courseDAO = new CourseDAOImpl();

		LocalDateTime localDateTime = LocalDateTime.now();
		// display contents of Admin client landing page
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
			System.out.println("4. Approve user");
			System.out.println("5. Display users");
			System.out.println("6. view course in Catalog");
			System.out.println("7. Add course to Catalog");
			System.out.println("8. Delete course from Catalog");
			System.out.println("9. Logout");
			System.out.println("********************");

			Scanner sc = new Scanner(System.in);
			UserDAO userDao = new UserDAOImpl();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			System.out.println("Your choice is: " + choice);
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
				break;
			case 3:
				user = new User();

				System.out.println(("Enter UserId of user to be deleted"));
				System.out.println("Enter UserId");
				int userID = sc.nextInt();
				user.setUserId(userID);
				// delete the user

				userDao.deleteUser(userID, SQLConstantQueries.DELETE_USER);
				System.out.println("Admin with Id= " + userID + " deleted !");

				break;
			case 4:

//				approveStudent();
//				break;
				// view user details
			case 5:
				// view admin details
				admin.displayAdmins();
				break;

			case 6:
//				viewCoursesInCatalogue();
//				break;

			case 7:
				Course course = new Course();
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

			case 8:
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
			case 9:
				System.out.println("Succesfully logged out as on " + currentDate);
				break;

			default:
				System.out.println("********Wrong Choice********");
			}
			sc.close();

		}

	}

//	public List<Student> displayAwaitingAdmissionOfStudents() {
//		AdminInterface adminInterface = new AdminImplService();
//
//		List<Student> pendingStudentsList = adminInterface.displayAwaitingAdmissionOfStudents();
//		if (pendingStudentsList.size() == 0) {
//			return pendingStudentsList;
//		}
//		System.out.println(String.format("% 20s |% 20s |% 20s |% 20s", "UserId", "StudentId", "Name", "Gender"));
//		for (Student student : pendingStudentsList) {
//			System.out.println(String.format("% 20s |% 20d |% 20s |% 20s", student.getUserId(), student.getStudentId(),
//					student.getName(), student.getGender().toString()));
//		}
//		return pendingStudentsList;
//	}

	// Method to approve a Student using Student's ID

//	public void approveStudent() throws SQLException {
//		AdminInterface adminInterface = new AdminImplService();
//       
//		List<Student> studentList = displayAwaitingAdmissionOfStudents();
//		if (studentList.size() == 0) {
//			return;
//		}
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter Student's ID:");
//		int studentUserIdApproval = sc.nextInt();
//		NotificationInterface notification = new NotificationImplService();
//		try {
//			adminInterface.approveStudent(studentUserIdApproval, studentList);
//			// send notification from system
//			notification.sendNotification(NotificationType.REGISTRATION_APPROVAL, studentUserIdApproval, null, 0);
//
//		} catch (StudentNotFoundForApprovalException e) {
//			System.out.println(e.getMessage());
//		}
//		sc.close();
//	}
//

}
