//package com.lt.business;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.lt.DAO.AdminDAO;
//import com.lt.DAO.AdminDAOImpl;
//import com.lt.bean.Course;
//import com.lt.bean.Student;
//import com.lt.bean.validator.AdminValidator;
//import com.lt.exception.CourseFoundException;
//import com.lt.exception.CourseNotDeletedException;
//import com.lt.exception.CourseNotFoundException;
//import com.lt.exception.StudentNotFoundForApprovalException;
//import com.lt.jdbc.AdminJdbc;
//
//public class AdminImplService implements AdminInterface {
//	AdminDAO adminDAO = new AdminDAOImpl();
//	AdminJdbc adminJdbc = new AdminJdbc();
//	private static Logger logger = Logger.getLogger(AdminImplService.class);
//
//	@Override
//	public void addProfessor() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void generateReportCard() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<Course> publishResult() throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Student> displayAwaitingAdmissionOfStudents() {
//		return adminJdbc.displayAwaitingAdmissionOfStudents();
//	}
//
//	/**
//	 * Method to approve a Student
//	 * 
//	 * @param studentId
//	 * @param studentList
//	 * @throws StudentNotFoundException
//	 */
//	@Override
//	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
//		AdminJdbc adminJdbc = new AdminJdbc();
//		if (!isValidUnapprovedStudent(studentId, studentList)) {
//			// logger.error("studentId: " + studentId + " is already
//			// approvet/not-present!");
//			throw new StudentNotFoundForApprovalException(studentId);
//		}
//
//		try {
//			adminJdbc.approveStudent(studentId);
//		} catch (StudentNotFoundForApprovalException e) {
//			throw e;
//		}
//
//	}
//
//	/**
//	 * Method to validate if studentId is still unapproved
//	 * 
//	 * @param studentId
//	 * @param studentList
//	 * @return
//	 */
//	public static boolean isValidUnapprovedStudent(int studentId, List<Student> studentList) {
//		for (Student student : studentList) {
//			if (studentId == student.getStudentId()) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public void deleteCourse(String courseCode, List<Course> courseList)
//			throws CourseNotFoundException, CourseNotDeletedException {
//
//		if (!AdminValidator.isValidDropCourse(courseCode, courseList)) {
//			logger.error("courseCode: " + courseCode + " not present in catalog!");
//			throw new CourseNotFoundException(courseCode);
//		}
//
//		try {
//			adminDAO.deleteCourse(courseCode);
//		} catch (CourseNotFoundException | CourseNotDeletedException e) {
//			throw e;
//		}
//
//	}
//
//	@Override
//	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException {
//		if (!AdminValidator.isValidNewCourse(course, courseList)) {
//			logger.error("courseCode: " + course.getCourseCode() + " already present in catalog!");
//			throw new CourseFoundException(course.getCourseCode());
//		}
//
//		try {
//			adminDAO.addCourse(course);
//		} catch (CourseFoundException e) {
//			throw e;
//		}
//
//	}
//
//	@Override
//	public List<Course> viewCourses() {
//		return adminDAO.viewCourses();
//	}
//
//}
