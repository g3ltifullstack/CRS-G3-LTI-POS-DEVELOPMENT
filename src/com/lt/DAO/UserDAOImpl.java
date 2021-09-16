package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User validateUser(String username, String userpassword) { // bh bh
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username); // bh
			stmt.setString(2, userpassword);// bh
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
	public Student fetchStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin fetchAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createProfessor(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(int userId, User user) {
		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			System.out.println("Updating the user and executing it");
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
			System.out.println("Updated the record");

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	@Override
	public void updateStudent(int studentId, Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProfessor(int professorId, Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAdmin(int adminId, Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> displayStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> displayProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> displayAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
