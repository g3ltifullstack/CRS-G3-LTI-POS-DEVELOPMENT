package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.User;

public class UserDAO {
	public static List<User> userDetails = new ArrayList<>();
	static {
		userDetails.add(new User(101, "Biswarup", "bis", 101));
		userDetails.add(new User(102, "Akshay", "aks", 102));
		userDetails.add(new User(103, "Akhilesh", "akh", 103));
		userDetails.add(new User(104, "Nikita", "nik", 104));
		userDetails.add(new User(105, "Bhabani", "bha", 105));
		userDetails.add(new User(106, "Srinivas", "sri", 106));
	}

	public List<User> createUser(User User) {
		userDetails.add(User);
		System.out.println(userDetails);
		return userDetails;

	}

}
