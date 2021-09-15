package com.lt.client;

import java.util.Scanner;

import com.lt.bean.Admin;
import com.lt.bean.User;
import com.lt.jdbc.AdminJdbc;

public class CRSApplication {
	public static void main(String[] args) {
		System.out.println("1. Admin");
		System.out.println("2. Student");
		System.out.println("3. Professor");
		System.out.println("User Type");
		Scanner sc = new Scanner(System.in);
		int userType = sc.nextInt();
		switch (userType) {
		case 1:
			AdminClient admin = new AdminClient();
			AdminJdbc adminJdbc = new AdminJdbc();
			// fetching input for user credentials
			System.out.println(("Enter UserName"));
			String username = sc.next();
			System.out.println(("Enter password"));
			String password = sc.next();
			User checkedUser = adminJdbc.validateUser(username, password);
//			int profile = checkedUser.getRoleId();
			int userID11 = checkedUser.getUserId();
			// fetching admin object from admin table
			Admin adminDetails = adminJdbc.fetchAdmin(userID11);
			AdminClient adminClient = new AdminClient();
			// redirecting to admin client landing page
			adminClient.adminMenu(adminDetails);

		case 2:
			System.out.println("Student");
			StudentClient student = new StudentClient();
			student.studentMenu();

		}
		sc.close();
	}

}
