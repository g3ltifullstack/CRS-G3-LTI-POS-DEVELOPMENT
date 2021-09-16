package com.lt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

public class AdminJdbc {

	public User validateUser(String username, String pass) {
		// Step 2
		// Declare the Connection or prepared statement variable here
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// // Step 3 Register Driver here and create connection and Step 4 make/open a
			// connection

			System.out.println("Connecting to database...");
			conn = DBUtil.getConnection();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			// Declaring prepared statement
			stmt = conn.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2, pass);
			// STEP 5: Extract data from result set

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User checkeduser = new User();
				checkeduser.setUserId(rs.getInt("userid"));
				checkeduser.setRoleId(rs.getInt("rollid"));

				return checkeduser;
			}

		} catch (SQLException ex) {
			ex.getMessage();
		}
		System.out.println("Goodbye!");
		return null;
	}

	// * // fetch admin from admin database against admin Id
	public Admin fetchAdmin(int adminid) {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement
			stmt = null;
			stmt = connection.prepareStatement(SQLConstantQueries.FETCH_ADMIN);
			stmt.setInt(1, adminid);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(adminid);
				admin.setName(rs.getString("name"));
				admin.setPhoneNumber(rs.getLong("phonenumber"));
				admin.setGender(rs.getString("gender"));

				return admin;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	// create a new admin
	public void createAdmin(Admin admin) {

		// Establishing the connection
		System.out.println("establishing connection");
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_ADMIN);
			int adminid = admin.getAdminId();
			String name = admin.getName();
			String gender = admin.getGender();
			long phoneNo = admin.getPhoneNumber();
			int userid = admin.getUserid();

			stmt.setInt(1, adminid);
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setLong(4, phoneNo);
			stmt.setInt(5, userid);

			// Executing query
			stmt.executeUpdate();
			System.out.println(("Admin" + " added!"));

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	// update admin against adminId
	public void updateAdmin(int adminID, Admin admin) {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_ADMIN);
			int adminid = admin.getAdminId();
			String name = admin.getName();
			long phoneNo = admin.getPhoneNumber();
			String gender = admin.getGender();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, adminid);

			// Executing query
			stmt.executeUpdate();
			System.out.println(("Admin details updated !"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public List<Admin> displayAdmins() {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list = new ArrayList<Admin>();

			// Creating ArrayList of admin
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("AdminID"));
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getLong("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				list.add(admin);

			}

			// returning list of admins
			return list;
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return null;
	}

}
