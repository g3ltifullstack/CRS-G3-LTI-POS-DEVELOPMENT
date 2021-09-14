package com.lt.client;

import java.util.Date;
import java.util.Scanner;

import com.lt.DAO.AdminDAO;
import com.lt.DAO.ProfessorDAO;
import com.lt.DAO.StudentDAO;
import com.lt.DAO.UserDAO;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

public class AdminClient {

	public void adminMenu() {
		UserInterface admin = new UserImplService();
		Admin adminRole = new Admin();
		Date currentDate = new Date();
		// display contents of Admin client landing page
		System.out.println("Succesfully logged in as ADMIN on " + currentDate);

		System.out.println("Welcome " + adminRole.getName());
		System.out.println("Choose an option");
		System.out.println("1. Create user");
		System.out.println("2. Update user");
		System.out.println("3. Delete user");
		System.out.println("4. Add a new Course");
		System.out.println("5. Delete Course");
		System.out.println("6. Display users");
		System.out.println("7. Logout");

//		System.out.println("Welcome to Admin Portal ---> ");
//		System.out.println("Choose an Option ");
//		System.out.println("1. SignUp ");
//		System.out.println("2. Login ");
//		System.out.println("3. Manage Password ");
//		System.out.println("4. Exit ");
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();
		switch (choice) {
		// create a new user
		case 1:
			User user = new User();
			UserDAO userDao = new UserDAO();

			System.out.println("Enter UserId");
			int userId = sc.nextInt();
			user.setUserId(userId);
			System.out.println("Enter Username");
			user.setUserName(sc.next());
			System.out.println("Enter Password");
			user.setUserPassword(sc.next());

			System.out.println("Enter Profile ");
			System.out.println("1. Student");
			System.out.println("2. Professor");
			System.out.println("3. Admin");
			int profileOption = sc.nextInt();
			switch (profileOption) {
			// if user is a student
			case 1:

				user.setRoleId(1);
				userDao.createUser(user);
				Student student = new Student();
				student.setStudentId(userId);
				System.out.println("Enter Name");
				student.setName(sc.next());
				System.out.println("Enter gender");
				student.setGender(sc.next());
				System.out.println("Enter Phone Number");
				student.setPhoneNumber(sc.nextInt());
				System.out.println("Enter Semester");
				student.setSemester(sc.nextInt());
				System.out.println("Enter Branch");
				student.setBranch(sc.next());

				// create student
				StudentDAO studentDAO = new StudentDAO();
				studentDAO.signUpStudent(student);
				break;

			case 2:
				ProfessorDAO professorDAO = new ProfessorDAO();
				user.setRoleId(2);
				userDao.createUser(user);
				Professor professor = new Professor();
				System.out.println("Enter ID");
				professor.setProfessorId(sc.nextInt());
				System.out.println("Enter Name");
				professor.setProfessorName(sc.next());
				System.out.println("Enter Department");
				professor.setDepartment(sc.next());
				// create professor
				professorDAO.createProfessor(professor);
				break;

			// if user is an admin
			case 3:
				AdminDAO adminDAO = new AdminDAO();
				user.setRoleId(3);
				userDao.createUser(user);
				Admin newAdmin = new Admin();
				System.out.println("Enter ID");
				newAdmin.setAdminId(sc.nextInt());
				System.out.println("Enter Name");
				newAdmin.setName(sc.next());
				System.out.println("Enter gender");
				newAdmin.setGender(sc.next());
				System.out.println("Enter Phone Number");
				newAdmin.setPhoneNumber(sc.nextInt());
				// create admin
				adminDAO.createAdmin(newAdmin);
				break;
			}

		}
		sc.close();

	}

}
