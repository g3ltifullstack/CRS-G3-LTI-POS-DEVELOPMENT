package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Notification;
import com.lt.bean.Student;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;


public class RegisterCourseDAOImpl implements RegisterCourseDAOInterface  {

	// gives the count of courses selected by student
	public boolean numberOfCoursesSelected (Student student) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.NUMBER_OF_COURSES_SELECTED);

			int studentId= student.getStudentId();
			stmt.setInt(1, studentId);

			//Executing query
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				int number= rs.getInt("count(CourseID)");
				if(number==4)
					return true;
			}

		} catch (SQLException ex) {
			
		}
		
		return false;


	}

	// submit registration by student
	public void submitRegistration (Student student) {
		//set registartion status as successful
		student.setRegistrationStatus(true);

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			// update registration status of student in student database
			// declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_REGISTARTION_STATUS);
			int studentId= student.getStudentId();
			stmt.setInt(1,studentId);

			// Executing query
			stmt.executeUpdate();
			
			// update course registration status
			stmt = connection.prepareStatement(SQLConstantQueries. REGISTRATION_OF_COURSES);

			stmt.setInt(1, studentId);
			stmt.executeUpdate();

			// update the number of students enrolled in that course by +1
			stmt = connection.prepareStatement(SQLConstantQueries. UPDATE_ENROLLED_STUDENTS_NUMBER);

			stmt.setInt(1, studentId);
			stmt.executeUpdate();

		} catch (SQLException ex) {
			
		}
		

	}

	// updating registration database and generating registration details
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId)  {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.SUBMIT_REGISTRATION_DETAILS);
			int studentId= student.getStudentId();
			String regId=2020+""+studentId;
			int registrationId=Integer.parseInt(regId);

			stmt.setInt(1, registrationId);
			stmt.setInt(2, studentId);
			stmt.setDouble(3, payableAmount);
			stmt.setInt(4, payModeId);

			//Executing query
			stmt.executeUpdate();


		} catch (SQLException ex) {
			
		}
		

	}

	// fetch registration details of student in notification instance
	public Notification showRegistrationReciept(Student student) {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries. SHOW_REGISTRATION_RECIEPT);
			stmt.setInt(1,student.getStudentId());

			ResultSet rs = stmt.executeQuery();

			if(rs.next())
			{
				Notification notification= new Notification();
				notification.setRegistrationId(rs.getInt("RegistrationID"));
				notification.setStudentId(rs.getInt("StudentID"));
				notification.setPayableAmount(rs.getDouble("PaymentAmount"));
				notification.setPayModeId(rs.getInt("PaymentModeID"));
				notification.setTimeStamp(rs.getString("RegistrationDate"));

				return notification;

			}
		}
		catch(SQLException ex) {
			
		}
		
		return null;
	}

	// generate list of students enrolled in a course
	public List<Integer> displayRegisteredStudentsInCourse(int courseId) {

		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			
			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_ENROLLED_STUDENT_ID);
			stmt.setInt(1, courseId);
			ResultSet rs = stmt.executeQuery();
			List<Integer> list= new ArrayList<Integer>();
			while(rs.next())
			{
				int studentId= rs.getInt("StudentID");
				list.add(studentId);
			}

			//returning list of studentId
			return list;
		}
		catch(SQLException ex) {
			
		}
		
		return null;
	} 

}
