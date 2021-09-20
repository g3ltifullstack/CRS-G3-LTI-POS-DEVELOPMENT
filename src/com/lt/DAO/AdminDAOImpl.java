//package com.lt.DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.lt.bean.Course;
//import com.lt.constants.SQLConstantQueries;
//import com.lt.exception.CourseFoundException;
//import com.lt.exception.CourseNotDeletedException;
//import com.lt.exception.CourseNotFoundException;
//import com.lt.utils.DBUtil;
//
//public class AdminDAOImpl implements AdminDAO{
//	private static Logger logger = Logger.getLogger(AdminDAOImpl.class);
//
//
//	@Override
//	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException {
//		Connection connection = DBUtil.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			String sql = SQLConstantQueries.DELETE_COURSE_QUERY;
//			stmt = connection.prepareStatement(sql);
//			
//			stmt.setString(1,courseCode);
//			int row = stmt.executeUpdate();
//			
//			logger.info(row + " entries deleted.");
//			if(row == 0) {
//				logger.error(courseCode + " not in catalog!");
//				throw new CourseNotFoundException(courseCode);
//			}
//
//			logger.info("Course with courseCode: " + courseCode + " deleted.");
//			
//		}catch(SQLException se) {
//			
//			logger.error(se.getMessage());
//			throw new CourseNotDeletedException(courseCode);
//		}
//		
//	}
//
//	@Override
//	public void addCourse(Course course) throws CourseFoundException {
//		Connection connection = DBUtil.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			String sql = SQLConstantQueries.ADD_COURSE_QUERY;
//			stmt = connection.prepareStatement(sql);
//			
//			stmt.setString(1, course.getCourseCode());
//			stmt.setString(2, course.getCourseName());
//			
//			stmt.setInt(3, 1);
//			int row = stmt.executeUpdate();
//			
//			logger.info(row + " course added");
//			if(row == 0) {
//				logger.error("Course with courseCode: " + course.getCourseCode() + "not added to catalog.");
//				throw new CourseFoundException(course.getCourseCode());
//			}
//			
//			logger.info("Course with courseCode: " + course.getCourseCode() + " is added to catalog."); 
//			
//		}catch(SQLException se) {
//			
//			logger.error(se.getMessage());
//			throw new CourseFoundException(course.getCourseCode());
//			
//		}
//	}
//
//	@Override
//	public List<Course> viewCourses() {
//		Connection connection = DBUtil.getConnection();
//		PreparedStatement stmt = null;
//		List<Course> courseList = new ArrayList<>();
//		try {
//			
//			String sql = SQLConstantQueries.VIEW_COURSE_QUERY;
//			stmt = connection.prepareStatement(sql);
//			stmt.setInt(1, catalogId);
//			ResultSet resultSet = stmt.executeQuery();
//			
//			while(resultSet.next()) {
//				
//				Course course = new Course();
//				course.setCourseCode(resultSet.getString(1));
//				course.setCourseName(resultSet.getString(2));
//				course.setInstructorId(resultSet.getString(3));
//				courseList.add(course);
//				
//			}
//			
//			logger.info(courseList.size() + " courses in catalogId: " + catalogId + ".");
//			
//		}catch(SQLException se) {
//			
//			logger.error(se.getMessage());
//			
//		}
//		
//		return courseList; 
//	}
////	// provide list of courses available for a student to select
////		// mapped with student's with branch and semester
////		public List<Course> displayCourses(Student student) {
////
////			//Establishing the connection
////			Connection connection= DBUtil.getConnection();
////
////			//Declaring prepared statement and executing query
////			PreparedStatement stmt= null;
////			try {
////				int semester= student.getSemester();
////				String branch= student.getBranch();
////				stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
////				stmt.setInt(1, semester);
////				stmt.setString(2,branch);
////
////				ResultSet rs = stmt.executeQuery();
////
////				List<Course> list= new ArrayList<Course>();
////
////				//Creating ArrayList of Course
////				while(rs.next())
////				{
////					Course course = new Course();
////					course.setBranch(branch);
////					course.setSemester(semester);
////					course.setCourseId(rs.getInt("CourseID"));
////					course.setCourseTitle(rs.getString("CourseTitle"));
////					course.setCourseDescription(rs.getString("CourseDescription"));
////					course.setCatalogId(rs.getInt("CatalogId"));
////					course.setCredits(rs.getInt("Credits"));
////					list.add(course);
////
////				}
////
////				return list;
////			}
////			catch(SQLException ex) {
////				logger.error(ex.getMessage());
////			}
//////			finally{
//////				closeConnection(connection,stmt);
//////			}
////			
////			return null;
////			
////		}
//}
