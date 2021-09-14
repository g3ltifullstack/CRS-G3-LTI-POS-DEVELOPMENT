package com.lt.client;

import java.util.Scanner;

import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

public class StudentClient {
	public void studentMenu() {
		Boolean isExecuted = false;
		while (!isExecuted) {
			UserInterface student = new UserImplService();
			System.out.println("Welcome to Student Portal ---> ");
			System.out.println("Choose an Option ");
			System.out.println("1. SignUp ");
			System.out.println("2. Login ");
			System.out.println("3. Manage Password ");
			System.out.println("4. Exit ");
			Scanner sc = new Scanner(System.in);
			int userRole = sc.nextInt();
			switch (userRole) {
			case 1:
				System.out.println("SignUp Portal");
				// user sign up method
				student.signUp();
				isExecuted = true;
				System.out.println("Signed up Successfully");
				break;

			case 2:
				System.out.println("Login Portal");
				// user login method
				student.login();
				isExecuted = true;
				System.out.println("Logged in Successfully");
				break;

			case 3:
				System.out.println("Manage User Portal");
				System.out.println("Enter UserName: ");
				String userName = sc.next();
				System.out.println("Enter Password: ");
				String password = sc.next();
				// Manage User method
				student.manageUser(userName, password);
				isExecuted = true;
				System.out.println("Username and Password submitted Successfully");
				break;

			case 4:
				isExecuted = true;
				System.out.println("You have successfully logged out and exited from system. thank you!");
				break;

			default:
				System.out.println("Choose valid user type");
			}

			sc.close();

		}
	}

}
