package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Admin;

public class AdminDAO {

	public static List<Admin> adminDetails = new ArrayList<>();
	static {
		adminDetails.add(new Admin(101, "Biswarup", "M", 5));
		adminDetails.add(new Admin(102, "Akshay", "M", 6));
		adminDetails.add(new Admin(103, "Akhilesh", "M", 7));
		adminDetails.add(new Admin(104, "Nikita", "F", 8));
		adminDetails.add(new Admin(105, "Bhabani", "M", 9));
		adminDetails.add(new Admin(106, "Srinivas", "M", 10));
	}

	public List<Admin> createAdmin(Admin admin) {
		adminDetails.add(admin);
		System.out.println(adminDetails);
		return adminDetails;

	}

}
