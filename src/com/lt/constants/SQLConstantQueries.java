package com.lt.constants;

public class SQLConstantQueries {

	public static final String VALIDATE_USER = "SELECT userid, rollid FROM user WHERE username=? AND userpassword=?";

	public static final String FETCH_ADMIN = "SELECT * FROM admin WHERE adminID=?";

	public static final String INSERT_ADMIN = "INSERT INTO admin VALUES (?,?,?,?,?)";

	public static final String DELETE_ADMIN = "DELETE FROM admin WHERE adminid=?";

	public static final String UPDATE_ADMIN = "UPDATE admin SET name=?,gender=?, phonenumber=? WHERE adminid=?";

	public static final String DISPLAY_ADMINS = "SELECT * FROM admin";

	public static final String UPDATE_USER = "UPDATE user SET username=?, userpassword=?, rollid=? WHERE userid=?";

	public static final String DELETE_USER = "DELETE FROM user WHERE userid=?";

	public static final String APPROVE_STUDENT_QUERY = "update student set isapproved = 1 where studentid = ?";

	public static final String INSERT_PAYMENT = "insert into payment(studentId,modeofPayment,referenceId,amount) values(?,?,?,?);";

	public static final String INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";

	public static final String GET_NOTIFICATION = "select * from notification where referenceId = ?;";

	public static final String GET_ROLE = "select rollid from user where userid = ? ";

	public static final String VIEW_PENDING_ADMISSION_QUERY = "select studentid, studentname, gender, phonenumber, semester, branch, userid from student natural join user where isApproved = 0";

}
