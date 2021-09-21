package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Admin;

import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

public class UserDAOImpl implements UserDAO {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public User validateUser(String username, String userpassword) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2, userpassword);
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
//		
		return null;
	}

	@Override
	public void updateUser(int userId, User user) {
		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			logger.info("Updating the user and executing it");
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_USER);
			int userId1 = user.getUserId();
			String username = user.getUserName();
			String password = user.getUserPassword();
			int roleId = user.getRoleId();

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, roleId);
			stmt.setInt(4, userId1);

			// Executing query
			stmt.executeUpdate();
			logger.info("Updated the record");

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	// provide details of all admins
	@Override
	public List<Admin> displayAdmins() {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list = new ArrayList<Admin>();
			logger.info("Display admins --");
			// Creating ArrayList of admin
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setGender(rs.getString("gender"));
				admin.setPhoneNumber(rs.getLong("phonenumber"));
				admin.setUserid(rs.getInt("userid"));
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
