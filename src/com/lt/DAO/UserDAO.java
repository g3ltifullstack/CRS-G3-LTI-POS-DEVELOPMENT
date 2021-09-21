package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.User;
import com.lt.utils.DBUtil;

public interface UserDAO {
	/**
	 * Method to verify credentials of Users from DataBase
	 * 
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 */
	public User validateUser(String username, String password);

	public void updateUser(int userId, User user);

	public List<Admin> displayAdmins();

	default public void deleteUser(int userId, String query) {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		try {

			// Establishing the connection
			PreparedStatement stmt = null;

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, userId);
			// Executing query
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				return;
			}
//				else 
//				throw new UserNotFoundException();

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}
}
