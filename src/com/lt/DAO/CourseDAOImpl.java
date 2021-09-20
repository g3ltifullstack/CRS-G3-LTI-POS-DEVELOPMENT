package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.CourseNotFoundException;
import com.lt.utils.DBUtil;

public class CourseDAOImpl implements CourseDAO {
	// Initializing the logger
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);

	// insert a new cousre in database against a course Id and catalog Id
	@Override
	public void insertCourse(Course course) {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		// Establishing the connection
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_COURSE);
			int courseID = course.getCourseId();
			String title = course.getCourseTitle();
			String description = course.getCourseDescription();
			int semester = course.getSemester();
			String branch = course.getBranch();
			int catalogId = course.getCatalogId();
			int credits = course.getCredits();

			stmt.setInt(1, courseID);
			stmt.setInt(2, catalogId);
			stmt.setString(3, title);
			stmt.setString(4, description);
			stmt.setInt(5, credits);
			stmt.setInt(6, semester);
			stmt.setString(7, branch);

			// Executing query
			stmt.executeUpdate();
			logger.info("Course added!");

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}

	}

	// delete a cousre from course database using course Id
	@Override
	public void deleteCourse(int courseId) throws CourseNotFoundException {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		// Establishing the connection
		PreparedStatement stmt = null;
		try {

			stmt = connection.prepareStatement(SQLConstantQueries.DELETE_COURSE + courseId);
			// Executing query
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				logger.info("Course with courseId " + courseId + " deleted !");
				return;

			}
			throw new CourseNotFoundException();
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}

	}

}
