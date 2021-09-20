package com.lt.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.lt.bean.Admin;
import com.lt.bean.User;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.jdbc.AdminJdbc;

public class UserClient {

	public static void main(String[] args) throws SQLException {
		// initializing the scanner
		Scanner sc = new Scanner(System.in);
		// initializing the instance courseOperation to carry out user operations
		UserInterface userInterface = new UserImplService();
		while (true) {
			System.out.println("*******WELCOME TO COURSE REGISTRATION SYSTEM***********");
			System.out.println("Enter your credentials");

			// fetching input for user credentials
			System.out.println("Enter UserName");
			String username = sc.next();
			System.out.println("Enter password");
			String password = sc.next();

			// validating the user credentials
			User checkedUser = userInterface.validateUser(username, password); // bh bh
			int profile = checkedUser.getRoleId(); // 3
			int userId = checkedUser.getUserId(); // 4

			switch (profile) { // 3

			// if user is an admin
			case 3:
				// fetching admin object from admin table
				Admin admin = userInterface.fetchAdmin(userId);
				AdminClient adminClient = new AdminClient();
				// redirecting to admin client landing page
				adminClient.adminMenu(admin);
				continue;
			}

			break;
		}

		sc.close();

	}
}
