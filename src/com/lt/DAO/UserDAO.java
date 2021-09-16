package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.utils.DBUtil;

public interface UserDAO {
	public User validateUser(String username, String password);

	public Student fetchStudent(int studentId);

	public Admin fetchAdmin(int adminId);

	public Professor fetchProfessor(int professorId);

	public void createUser(User user);

	public void createStudent(Student student);

	public void createProfessor(Professor professor);

	public void createAdmin(Admin admin);

	public void updateUser(int userId, User user);

	public void updateStudent(int studentId, Student student);

	public void updateProfessor(int professorId, Professor professor);

	public void updateAdmin(int adminId, Admin admin);

	public List<Student> displayStudents();

	public List<Professor> displayProfessors();

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
